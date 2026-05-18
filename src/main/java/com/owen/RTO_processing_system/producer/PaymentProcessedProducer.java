package com.owen.RTO_processing_system.producer;

import java.util.UUID;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.owen.RTO_processing_system.dto.out.PaymentResult;
import com.owen.RTO_processing_system.repository.OrderRepository;

@Service
public class PaymentProcessedProducer {
    private static final String TOPIC = "orders.payment";
    private final KafkaTemplate<UUID, PaymentResult> kafkaTemplate;
    private final OrderRepository repository;
    
    public PaymentProcessedProducer(KafkaTemplate<UUID, PaymentResult> kafkaTemplate, OrderRepository repository) {
        this.kafkaTemplate = kafkaTemplate;
        this.repository = repository;
    }

    public void sendPaymentProcessedEvent (PaymentResult event)
    {
        kafkaTemplate.send(TOPIC, event.getOrder().getId(), event);
        System.out.println("Sent event to kafka: " + event.getOrder().getId());
    }
}
