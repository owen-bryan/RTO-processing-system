package com.owen.RTO_processing_system.dto.out;

import java.math.BigDecimal;

import com.owen.RTO_processing_system.model.Order;

public class PaymentResult {
    public enum PaymentStatus {
        FAIL, SUCCESS, REFUNDED
    }
    

    private BigDecimal amount;
    private Order order;
    private PaymentStatus status;

    public PaymentResult() {
    }

    public PaymentResult(PaymentStatus status, BigDecimal amount, Order order) {
        this.status = status;
        this.amount = amount;
        this.order = order;
    }

    public static PaymentResult success (BigDecimal amount, Order order)
    {
        return new PaymentResult(PaymentStatus.SUCCESS, amount, order);
    }

    public static PaymentResult fail (BigDecimal amount, Order order)
    {
        return new PaymentResult (PaymentStatus.FAIL, amount, order);
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal ammount) {
        this.amount = ammount;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    
}
