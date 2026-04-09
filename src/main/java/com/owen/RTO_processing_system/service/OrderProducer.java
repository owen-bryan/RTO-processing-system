package com.owen.RTO_processing_system.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.owen.RTO_processing_system.model.OrderCreatedEvent;

@Service
public class OrderProducer {
    
    private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;

    public OrderProducer (KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrderCreatedEvent (OrderCreatedEvent event) {
        kafkaTemplate.send("orders.created", event);
        System.out.println("Sent event to kafka: " + event.getOrderId());
    }
}
