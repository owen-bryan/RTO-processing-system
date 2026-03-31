package com.owen.ROT_processing_system.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.owen.ROT_processing_system.dto.CreateOrderRequest;
import com.owen.ROT_processing_system.dto.OrderResponse;
import com.owen.ROT_processing_system.service.OrderService;

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

}
