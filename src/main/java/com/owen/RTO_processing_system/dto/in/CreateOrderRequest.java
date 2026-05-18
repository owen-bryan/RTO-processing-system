package com.owen.RTO_processing_system.dto.in;

import java.math.BigDecimal;
import java.util.UUID;

public class CreateOrderRequest {
    
    private UUID userId;
    private BigDecimal totalAmount;
    
    public UUID getUserId() {
        return userId;
    }
    public void setUserId(UUID userId) {
        this.userId = userId;
    }
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    
}
