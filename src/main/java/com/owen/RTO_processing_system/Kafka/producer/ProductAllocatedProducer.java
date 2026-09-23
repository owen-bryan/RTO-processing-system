package com.owen.RTO_processing_system.Kafka.producer;

import org.springframework.stereotype.Service;

import com.owen.RTO_processing_system.dto.out.ProductReservedEvent;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductAllocatedProducer {
    
    private static final String TOPIC = "orders.reserved";
    private final KafkaEventPublisher kafkaEventPublisher;

    public void sendProductReservedEvent (ProductReservedEvent event)
    {
        kafkaEventPublisher.publish (event.getOrderID(), TOPIC, event, ProductReservedEvent.class);
    }
}
