package com.owen.RTO_processing_system.dto.out;

import java.math.BigDecimal;
import java.util.UUID;

public class PaymentResult {
    public enum PaymentStatus {
        FAIL, SUCCESS, REFUNDED
    }
    

    private BigDecimal amount;
    private UUID orderId;
    private PaymentStatus status;

    public PaymentResult() {
    }

    public PaymentResult(PaymentStatus status, BigDecimal amount, UUID orderId) {
        this.amount = amount;
        this.orderId = orderId;
        this.status = status;
    }


    public static PaymentResult success (BigDecimal amount, UUID orderId)
    {
        return new PaymentResult(PaymentStatus.SUCCESS, amount, orderId);
    }

    public static PaymentResult fail (BigDecimal amount, UUID orderId)
    {
        return new PaymentResult (PaymentStatus.FAIL, amount, orderId);
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

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }


    
}
