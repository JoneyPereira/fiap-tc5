package com.fiap.tc5apicarts.services;


import com.fiap.tc5apicarts.client.ProductFeignClient;
import com.fiap.tc5apicarts.dto.OrderDTO;
import com.fiap.tc5apicarts.dto.ProductDTO;
import com.fiap.tc5apicarts.dto.StockDTO;
import com.fiap.tc5apicarts.dto.StockOutputDTO;
import com.fiap.tc5apicarts.entities.Order;
import com.fiap.tc5apicarts.entities.Product;
import com.fiap.tc5apicarts.entities.enums.OrderStatus;
import com.fiap.tc5apicarts.exceptions.ResourceNotFoundException;
import com.fiap.tc5apicarts.repositories.OrderRepository;
import com.fiap.tc5apicarts.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductFeignClient productFeignClient;

    @Transactional(readOnly = true)
    public List<OrderDTO> findAll() {
        List<Order> listOrders = orderRepository.findOrdersWithProducts();
        return listOrders.stream().map(OrderDTO::new).collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public OrderDTO findById(UUID uuid){
        Optional<Order> obj = orderRepository.findById(uuid);
        Order order = obj.orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado, uuid: " + uuid));
        return new OrderDTO(order);
    }
    @Transactional
    public OrderDTO insert(OrderDTO dto) {
        Order order = new Order(null,
                Instant.now(), OrderStatus.PENDING);

        for (ProductDTO p : dto.getProducts()){
            StockDTO stock = productFeignClient.findByUuid(p.getId_product());
            var input = stock.getAmount_stock();
            var output = p.getAmount();
            stock.setAmount_stock(input - output);

            order.getProducts().add(copyDtoToEntity(stock, p));
            productRepository.save(copyToEntity(stock));
        }

        order = orderRepository.save(order);

        //dto.getProducts().forEach();

        return new OrderDTO(order);
    }
    @Transactional
    public OrderDTO setPaid(UUID uuid){
        try {
            Order order = orderRepository.getReferenceById(uuid);
            order.setStatus(OrderStatus.PAID);

            for (Product p : order.getProducts()){
                StockOutputDTO stockOutputDTO = new StockOutputDTO();
                stockOutputDTO.setId_product(p.getId_product());
                stockOutputDTO.setAmount_stock(1);
                productFeignClient.outPutStock(stockOutputDTO);
            }
            order = orderRepository.save(order);
            return new OrderDTO(order);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Objeto não encontrado, uuid: " + uuid);
        }
    }

    private Product copyToEntity(StockDTO dto){
        var product = new Product();
        product.setId_product(dto.getId_product());
        product.setPrice(BigDecimal.valueOf(dto.getPrice()));
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setImageuri(dto.getImageUri());
        return product;
    }

    private Product copyDtoToEntity(StockDTO dto, ProductDTO p){
        var product = new Product();
        product.setId_product(dto.getId_product());
        product.setPrice(BigDecimal.valueOf(dto.getPrice()));
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setImageuri(dto.getImageUri());
        product.setAmount(p.getAmount());
        return product;
    }

    private OrderDTO copyEntityToDto(Order order,OrderDTO dto){
        var orderDto = new OrderDTO();
        orderDto.setId_order(order.getId_order());
        orderDto.setStatus(order.getStatus());
        orderDto.setMoment(order.getMoment());
        orderDto.setProducts(dto.getProducts());
        return orderDto;
    }
}
