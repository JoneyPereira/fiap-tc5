package com.fiap.tc5apicarts.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_product")
public class Product {

    @Id
    private UUID id_product;

    private String name;
    private BigDecimal price;
    private String description;
    private String imageuri;
    private Integer amount;
}
