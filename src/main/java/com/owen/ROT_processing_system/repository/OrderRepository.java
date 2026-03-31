package com.owen.ROT_processing_system.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.owen.ROT_processing_system.model.Order;

public interface OrderRepository extends JpaRepository <Order, UUID>{
    
}
