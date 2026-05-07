package com.owen.RTO_processing_system.dto;

import java.math.BigDecimal;

import com.owen.RTO_processing_system.model.Order;

public class PaymentRequest {

    private Order order;
    private BigDecimal amount;
    private String status;
    
    public PaymentRequest() {
    }

    public PaymentRequest(Order order, BigDecimal amount, String status) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    
}