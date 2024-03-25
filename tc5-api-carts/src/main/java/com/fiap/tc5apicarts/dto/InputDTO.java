package com.fiap.tc5apicarts.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
public class InputDTO {

    private UUID id_input;
    private Double price;
    private Integer amount;
    private Timestamp date_input;
    public InputDTO() {
    }
    public InputDTO(UUID id_input, Double price, Integer amount) {
        this.id_input = id_input;
        this.price = price;
        this.amount = amount;
    }
}
