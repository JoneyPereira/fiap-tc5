package com.fiap.tc5apicarts.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class StockDTO {

    private UUID id_product;
    private String name;
    private Double price;
    private String description;
    private String imageUri;
    private Integer amount_stock;
    private List<InputDTO> inputs = new ArrayList<>();
    private List<OutputDTO> outputs = new ArrayList<>();
    public StockDTO() {
    }
    public StockDTO(UUID id_product, String name, Double price, String description, String imageUri)
    {
        this.id_product = id_product;
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageUri = imageUri;
    }
}
