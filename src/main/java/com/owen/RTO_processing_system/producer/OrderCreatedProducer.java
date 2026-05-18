package com.owen.RTO_processing_system.producer;

import java.util.UUID;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.owen.RTO_processing_system.dto.out.OrderCreatedEvent;
import com.owen.RTO_processing_system.model.Order;
import com.owen.RTO_processing_system.repository.OrderRepository;

@Service
public class OrderCreatedProducer {
    
    private final KafkaTemplate<UUID, OrderCreatedEvent> kafkaTemplate;
    private final OrderRepository orderRepository;
    private static final String TOPIC = "orders.created";
    
    public OrderCreatedProducer (KafkaTemplate<UUID, OrderCreatedEvent> kafkaTemplate, OrderRepository orderRepository) {
        this.kafkaTemplate = kafkaTemplate;
        this.orderRepository = orderRepository;
    }

    public void sendOrderCreatedEvent (OrderCreatedEvent event) {
        Order order = orderRepository.findById (event.getOrderId()).orElseThrow();
        kafkaTemplate.send (TOPIC, event.getOrderId(), event);
        System.out.println("Sent event to kafka: " + order.getId());
    }

}
