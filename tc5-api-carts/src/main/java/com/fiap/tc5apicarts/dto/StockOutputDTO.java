package com.fiap.tc5apicarts.dto;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.UUID;

@Jacksonized
@Builder
@Data
public class StockOutputDTO {

    private UUID id_product;
    private Integer amount_stock;

    public StockOutputDTO() {
    }

    public StockOutputDTO(UUID id_product, Integer stock) {
        this.id_product = id_product;
        this.amount_stock = stock;
    }
}
