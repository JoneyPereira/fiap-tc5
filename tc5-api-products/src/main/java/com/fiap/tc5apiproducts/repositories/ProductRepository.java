package com.fiap.tc5apiproducts.repositories;

import com.fiap.tc5apiproducts.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    List<Product> findAllByOrderByNameAsc();
}
