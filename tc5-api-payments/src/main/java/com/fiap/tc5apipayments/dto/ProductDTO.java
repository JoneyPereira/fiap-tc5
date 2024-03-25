package com.fiap.tc5apipayments.dto;

import com.fiap.tc5apipayments.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private UUID id_product;
    private String name;
    private BigDecimal price;
    private String description;
    private String imageUri;
    private Integer amount;

    public ProductDTO(Product entity) {
        id_product = entity.getId_product();
        name = entity.getName();
        price = entity.getPrice();
        description = entity.getDescription();
        imageUri = entity.getImageuri();
    }

    public BigDecimal getTotal(){
        return price.multiply(BigDecimal.valueOf(amount));
    }
}
