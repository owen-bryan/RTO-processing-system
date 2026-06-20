package com.owen.RTO_processing_system.Kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.owen.RTO_processing_system.dto.in.AllocateProductRequest;
import com.owen.RTO_processing_system.dto.out.PaymentResult;
import com.owen.RTO_processing_system.model.Order;
import com.owen.RTO_processing_system.model.OrderStatus;
import com.owen.RTO_processing_system.repository.OrderRepository;
import com.owen.RTO_processing_system.service.ProductAllocationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProcessedPaymentConsumer {
    
    
    private final OrderRepository orderRepository;
    private final ProductAllocationService productAllocationService;

    @KafkaListener (topics = "orders.payment")
    public void consumePayment (PaymentResult event)
    {
        
        log.info ("Read orders.payment event " + event.getOrderId());
        Order order = orderRepository.findById(event.getOrderId()).orElseThrow();
        
        order.setStatus(OrderStatus.PROCCESSING);
        orderRepository.save(order);
        
        AllocateProductRequest request = new AllocateProductRequest(order.getId(), order.getItems());

        productAllocationService.allocateProduct(request);
    }
}
