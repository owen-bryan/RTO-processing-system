package com.owen.RTO_processing_system.service;

import org.springframework.stereotype.Service;

import com.owen.RTO_processing_system.Kafka.producer.ProductAllocatedProducer;
import com.owen.RTO_processing_system.dto.in.AllocateProductRequest;
import com.owen.RTO_processing_system.dto.out.ProductReservedEvent;
import com.owen.RTO_processing_system.model.OrderItems;
import com.owen.RTO_processing_system.repository.OrderRepository;
import com.owen.RTO_processing_system.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductAllocationService {
    
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final ProductAllocatedProducer productAllocatedProducer;

    public ProductReservedEvent allocateProduct (AllocateProductRequest event) {

        for (OrderItems item : event.getOrderItems()) {
            
        }
        //check items if they are available. if not throw and set order to pending.

        //Allocated the product. and then sned a product allocated event.

        return null;
    }
}
