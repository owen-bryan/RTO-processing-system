package com.owen.RTO_processing_system.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.owen.RTO_processing_system.dto.CreateOrderRequest;
import com.owen.RTO_processing_system.dto.OrderResponse;
import com.owen.RTO_processing_system.service.OrderService;


@RestController
@RequestMapping ("/orders")
public class OrdersController {
    

    private final OrderService orderService;

    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public OrderResponse insertOrder (@RequestBody CreateOrderRequest request){
        return orderService.createOrder(request);
    }

    @GetMapping("/{orderId}")
    public OrderResponse getOrder(@RequestParam UUID orderId) {
        return orderService.getOrder(orderId);
    }
    

}
