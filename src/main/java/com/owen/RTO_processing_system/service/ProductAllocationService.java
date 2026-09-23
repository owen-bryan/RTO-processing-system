package com.owen.RTO_processing_system.service;

import org.springframework.stereotype.Service;

import com.owen.RTO_processing_system.Kafka.producer.ProductAllocatedProducer;
import com.owen.RTO_processing_system.dto.in.AllocateProductRequest;
import com.owen.RTO_processing_system.dto.out.ProductReservedEvent;
import com.owen.RTO_processing_system.model.Order;
import com.owen.RTO_processing_system.model.OrderItems;
import com.owen.RTO_processing_system.model.OrderStatus;
import com.owen.RTO_processing_system.repository.OrderRepository;
import com.owen.RTO_processing_system.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductAllocationService {
    
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final ProductAllocatedProducer productAllocatedProducer;

    public ProductReservedEvent allocateProduct (AllocateProductRequest event) {

        for (OrderItems item : event.getOrderItems()) {
            if (item.getQuantity() > item.getProduct().getQuantity()) {
                Order order = orderRepository.findById (event.getOrderId()).orElseThrow();
                order.setStatus(OrderStatus.PENDING);
                orderRepository.save (order);
                throw new IllegalArgumentException("OrderedQuantity is Greater than stock.");
            } 

            item.setAllocated(true);
            item.getProduct().setQuantity(item.getProduct().getQuantity() - item.getQuantity());

            productRepository.save(item.getProduct());
        }
        //check items if they are available. if not throw and set order to pending.

        //Allocated the product. and then sned a product allocated event.

        ProductReservedEvent response = new ProductReservedEvent(event.getOrderId(), event.getOrderItems());
        
        productAllocatedProducer.sendProductReservedEvent(response);

        return response;
    }
}
