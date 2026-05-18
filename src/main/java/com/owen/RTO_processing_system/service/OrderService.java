package com.owen.RTO_processing_system.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.owen.RTO_processing_system.dto.in.CreateOrderRequest;
import com.owen.RTO_processing_system.dto.out.OrderCreatedEvent;
import com.owen.RTO_processing_system.dto.out.OrderResponse;
import com.owen.RTO_processing_system.model.Order;
import com.owen.RTO_processing_system.model.OrderItems;
import com.owen.RTO_processing_system.model.OrderStatus;
import com.owen.RTO_processing_system.producer.OrderCreatedProducer;
import com.owen.RTO_processing_system.repository.OrderRepository;

@Service
public class OrderService {
    
    private final OrderRepository orderRepository;
    private final OrderCreatedProducer producer;

    public OrderService(OrderRepository orderRepository, OrderCreatedProducer producer) {
        this.orderRepository = orderRepository;
        this.producer = producer;
    }

    public OrderResponse getOrder (UUID orderId){
        Order order = orderRepository.findById(orderId).orElseThrow();

        return new OrderResponse(order.getId(), order.getUserId(), order.getTotalAmount(), order.getStatus(), order.getCreatedAt());
    }

    public OrderResponse createOrder (CreateOrderRequest request) {

        if (request.getTotalAmount() == null || request.getTotalAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }

        Order order = new Order (
            request.getUserId(),
            request.getTotalAmount(),
            OrderStatus.CREATED,
            new ArrayList<OrderItems>()
        );
        
        Order saved = orderRepository.save (order);

        OrderCreatedEvent event = new OrderCreatedEvent(
            saved.getId(), 
            saved.getTotalAmount(), 
            saved.getStatus(), 
            saved.getItems()
        );

        producer.sendOrderCreatedEvent(event);

        return new OrderResponse(
            saved.getId(),
            saved.getUserId(),
            saved.getTotalAmount(),
            saved.getStatus(),
            saved.getCreatedAt()
        );
    }
}
