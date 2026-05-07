package com.owen.RTO_processing_system.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.owen.RTO_processing_system.model.Order;

@Service
public class OrderConsumer {

    @KafkaListener (topics = "order.created")
    public void consumeOrder (Order order)
    {
        System.out.println ("Consumed order: " + order.getId());
    }

    @KafkaListener (topics = "order.payment")
    public void consumePayment (Order order)
    {
        System.out.println ("Processed payment" + order.getId());
    }
}