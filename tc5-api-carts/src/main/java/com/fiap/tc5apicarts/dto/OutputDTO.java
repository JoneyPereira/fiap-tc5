package com.fiap.tc5apicarts.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
public class OutputDTO {

    private UUID id_output;
    private Double price;
    private Integer amount;
    private Timestamp date_output;
    public OutputDTO() {
    }
    public OutputDTO(UUID id_output, Double price, Integer amount) {
        this.id_output = id_output;
        this.price = price;
        this.amount = amount;
    }
}
