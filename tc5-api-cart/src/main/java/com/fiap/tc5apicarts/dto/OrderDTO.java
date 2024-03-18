package com.fiap.tc5apicarts.dto;


import com.fiap.tc5apicarts.entities.Order;
import com.fiap.tc5apicarts.entities.Product;
import com.fiap.tc5apicarts.entities.enums.OrderStatus;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.time.Instant;
import java.util.*;

@Jacksonized
@Builder
@Data
public class OrderDTO {

    private UUID id_order;
    private Instant moment;
    private OrderStatus status;
    private Set<Product> products = new HashSet<>();

    public OrderDTO() {
    }
    public OrderDTO(UUID id_order, Instant moment, OrderStatus status) {
        this.id_order = id_order;
        this.moment = moment;
        this.status = status;
    }
    public OrderDTO(Order entity) {
        id_order = entity.getId_order();
        moment = entity.getMoment();
        status = entity.getStatus();
        products = entity.getProducts();
    }
}
