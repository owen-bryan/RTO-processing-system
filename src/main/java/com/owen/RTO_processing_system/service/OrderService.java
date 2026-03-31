package com.owen.RTO_processing_system.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.owen.RTO_processing_system.dto.CreateOrderRequest;
import com.owen.RTO_processing_system.dto.OrderResponse;
import com.owen.RTO_processing_system.model.Order;
import com.owen.RTO_processing_system.repository.OrderRepository;

@Service
public class OrderService {
    
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderResponse createOrder (CreateOrderRequest request) {

        if (request.getTotalAmount() == null || request.getTotalAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }

        Order order = new Order (
            request.getUserId(),
            request.getTotalAmount(),
            "CREATED"
        );
        
        Order saved = orderRepository.save (order);

        return new OrderResponse(
            saved.getId(),
            saved.getUserId(),
            saved.getTotalAmount(),
            saved.getStatus(),
            saved.getCreatedAt()
        );
    }
}
