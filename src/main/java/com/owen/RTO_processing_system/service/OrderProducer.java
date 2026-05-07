package com.owen.RTO_processing_system.service;

import java.util.UUID;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.owen.RTO_processing_system.dto.OrderCreatedEvent;
import com.owen.RTO_processing_system.dto.PaymentResult;
import com.owen.RTO_processing_system.model.Order;
import com.owen.RTO_processing_system.repository.OrderRepository;

@Service
public class OrderProducer {
    
    private final KafkaTemplate<UUID, Order> kafkaTemplate;
    private final OrderRepository orderRepository;
    
    public OrderProducer (KafkaTemplate<UUID, Order> kafkaTemplate, OrderRepository orderRepository) {
        this.kafkaTemplate = kafkaTemplate;
        this.orderRepository = orderRepository;
    }

    public void sendOrderCreatedEvent (OrderCreatedEvent event) {
        Order order = orderRepository.findById (event.getOrderId()).orElseThrow();
        
        sendOrder("orders.created", order.getId(), order);
    }

    public void sendPaymentProcessedEvent (PaymentResult event) {
        Order order = event.getOrder();

        sendOrder("orders.paid", order.getId(), order);
    }

    private void sendOrder (String topic, UUID id, Order order)
    {
        kafkaTemplate.send(topic, order.getId(), order);
        System.out.println("Sent event to kafka: " + order.getId());
    }
}
