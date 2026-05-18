package com.owen.RTO_processing_system.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.owen.RTO_processing_system.dto.in.PaymentRequest;
import com.owen.RTO_processing_system.dto.out.OrderCreatedEvent;
import com.owen.RTO_processing_system.dto.out.PaymentResult;
import com.owen.RTO_processing_system.dto.out.PaymentResult.PaymentStatus;
import com.owen.RTO_processing_system.model.Order;
import com.owen.RTO_processing_system.producer.PaymentProcessedProducer;
import com.owen.RTO_processing_system.repository.OrderRepository;
import com.owen.RTO_processing_system.service.PaymentService;

@Service
public class OrderConsumer {

    private final PaymentService paymentService;
    private final PaymentProcessedProducer producer;
    private final OrderRepository orderRepository;

    public OrderConsumer (PaymentService paymentService, PaymentProcessedProducer producer, OrderRepository orderRepository)
    {
        this.paymentService = paymentService;
        this.producer = producer;
        this.orderRepository = orderRepository;
    }

    @KafkaListener (topics = "orders.created")
    public void consumeOrder (OrderCreatedEvent event)
    {

        System.out.println ("Consumed OrderCreadtedEvent for order: " + event.getOrderId());

        Order order = orderRepository.findById(event.getOrderId()).orElseThrow();

        PaymentRequest request = new PaymentRequest(order, event.getTotal(), event.getStatus());
        PaymentResult result = paymentService.charge(request);

        if (result.getStatus() == PaymentStatus.SUCCESS)
        {
            producer.sendPaymentProcessedEvent(result);
        }
    }

    @KafkaListener (topics = "orders.payment")
    public void consumePayment (PaymentResult event)
    {
        System.out.println ("Processed payment" + event.getOrder().getId());
    }
}