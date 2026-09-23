package com.owen.RTO_processing_system.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.owen.RTO_processing_system.model.Product;


public interface ProductRepository extends JpaRepository<Product, UUID>{
    
    public List<Product> findByName(String name);
}
