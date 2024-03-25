package com.fiap.tc5apicarts.services;


import com.fiap.tc5apicarts.client.ProductFeignClient;
import com.fiap.tc5apicarts.dto.CartDTO;
import com.fiap.tc5apicarts.dto.ProductDTO;
import com.fiap.tc5apicarts.dto.StockDTO;
import com.fiap.tc5apicarts.entities.Product;
import com.fiap.tc5apicarts.entities.enums.CartStatus;
import com.fiap.tc5apicarts.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Service
public class CartService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductFeignClient productFeignClient;

    @Transactional
    public CartDTO insert(UUID uuid, Integer amount) {
        CartDTO cart = new CartDTO(Instant.now(), CartStatus.PENDING);
        StockDTO productStock = productFeignClient.findByUuid(uuid);
        var product = copyDtoToEntity(productStock, amount);
        cart.getProducts().add(product);
        cart.setTotal(product.getTotal());
        return cart;
    }

    private ProductDTO copyDtoToEntity(StockDTO dto, Integer amount){
        var product = new ProductDTO();
        product.setId_product(dto.getId_product());
        product.setPrice(BigDecimal.valueOf(dto.getPrice()));
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setImageUri(dto.getImageUri());
        product.setAmount(amount);
        return product;
    }
}
