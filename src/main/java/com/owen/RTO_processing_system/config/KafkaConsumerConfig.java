package com.owen.RTO_processing_system.config;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.UUIDDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JacksonJsonDeserializer;

import com.owen.RTO_processing_system.model.Order;

@Configuration
public class KafkaConsumerConfig {


    @Bean
    ConsumerFactory<UUID, Order> consumerFactory () {
        JacksonJsonDeserializer<Order> deserializer = new JacksonJsonDeserializer<>(Order.class);
        deserializer.addTrustedPackages("*");

        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, UUIDDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, deserializer);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "RTO-processing");

        return new DefaultKafkaConsumerFactory<>(props, new UUIDDeserializer(), deserializer);
    }

    @Bean
    ConcurrentKafkaListenerContainerFactory <UUID, Order> kafkaListenerContainerFactory () {
        ConcurrentKafkaListenerContainerFactory<UUID, Order> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());

        return factory;
    }
}
