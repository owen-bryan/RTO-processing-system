package com.owen.RTO_processing_system.dto.in;

import java.math.BigDecimal;

import com.owen.RTO_processing_system.model.Order;
import com.owen.RTO_processing_system.model.OrderStatus;

public class PaymentRequest {

    private Order order;
    private BigDecimal amount;
    private OrderStatus status;
    
    public PaymentRequest() {
    }

    public PaymentRequest(Order order, BigDecimal amount, OrderStatus status) {
        this.order = order;
        this.amount = amount;
        this.status = status;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    
    
}