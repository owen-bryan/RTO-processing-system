package com.owen.RTO_processing_system.Kafka.producer;

import org.springframework.stereotype.Service;

import com.owen.RTO_processing_system.dto.out.OrderCreatedEvent;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderCreatedProducer {
    
    private final KafkaEventPublisher kafkaEventPublisher;
    private static final String TOPIC = "orders.created";
 

    public void sendOrderCreatedEvent (OrderCreatedEvent event) {
        kafkaEventPublisher.publish(event.getOrderId(), TOPIC, event, OrderCreatedEvent.class);
    }

}
