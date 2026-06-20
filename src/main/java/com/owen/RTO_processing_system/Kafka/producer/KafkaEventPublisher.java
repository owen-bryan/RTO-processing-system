package com.owen.RTO_processing_system.Kafka.producer;

import java.util.UUID;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaEventPublisher {
    
    
    private final KafkaTemplate <UUID, Object> kafkaTemplate;

    public void publish(UUID key, String topic, Object event, Class<?> eventType)
    {
        kafkaTemplate.send(topic, key, event)
        .whenComplete((result, ex) -> {
            if (ex != null) {
                log.error ("Failed to publish event", ex);
            }
            else {
                log.info ("Published event, of class type {}, for order {}", eventType.getName(), key);
            }
        });
    }
}
