package com.owen.RTO_processing_system.Kafka.producer;

import org.springframework.stereotype.Service;

import com.owen.RTO_processing_system.dto.out.PaymentResult;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentProcessedProducer {
    
    private static final String TOPIC = "orders.payment";
    private final KafkaEventPublisher kafkaEventPublisher;

    public void sendPaymentProcessedEvent (PaymentResult event)
    {
        kafkaEventPublisher.publish(event.getOrderId(), TOPIC, event, PaymentResult.class);
        log.info ("Sent event to event publisher: " + event.getOrderId());
    }
}
