package com.owen.RTO_processing_system.repository;

import com.owen.RTO_processing_system.model.OrderItems;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemsRepository extends JpaRepository <OrderItems, UUID> {
    
}
