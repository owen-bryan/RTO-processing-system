package com.owen.RTO_processing_system.Kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.owen.RTO_processing_system.Kafka.producer.PaymentProcessedProducer;
import com.owen.RTO_processing_system.dto.in.PaymentRequest;
import com.owen.RTO_processing_system.dto.out.OrderCreatedEvent;
import com.owen.RTO_processing_system.dto.out.PaymentResult;
import com.owen.RTO_processing_system.dto.out.PaymentResult.PaymentStatus;
import com.owen.RTO_processing_system.model.Order;
import com.owen.RTO_processing_system.repository.OrderRepository;
import com.owen.RTO_processing_system.service.PaymentService;

@Service
public class OrderCreatedConsumer {

    private final PaymentService paymentService;
    private final PaymentProcessedProducer producer;
    private final OrderRepository orderRepository;

    private static final Logger log = LoggerFactory.getLogger(OrderCreatedConsumer.class);

    public OrderCreatedConsumer (PaymentService paymentService, PaymentProcessedProducer producer, OrderRepository orderRepository)
    {
        this.paymentService = paymentService;
        this.producer = producer;
        this.orderRepository = orderRepository;
    }

    @KafkaListener (topics = "orders.created")
    public void consumeOrder (OrderCreatedEvent event)
    {

        log.info("Consumed OrderCreadtedEvent for order: " + event.getOrderId());

        Order order = orderRepository.findById(event.getOrderId()).orElseThrow();

        PaymentRequest request = new PaymentRequest(order, event.getTotal(), event.getStatus());
        PaymentResult result = paymentService.charge(request);

        if (result.getStatus() == PaymentStatus.SUCCESS)
        {
            producer.sendPaymentProcessedEvent(result);
        }
        else
        {
            log.info("Payment failed for order: " + order.getId());
        }
    }

  
}