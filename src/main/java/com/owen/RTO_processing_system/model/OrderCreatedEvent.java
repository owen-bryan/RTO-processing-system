package com.owen.RTO_processing_system.model;

import java.math.BigDecimal;
import java.util.UUID;

public class OrderCreatedEvent {
    
    private UUID orderId;
    private String productID;
    private int quantity;
    private BigDecimal total;
    private String status;
    
    public OrderCreatedEvent() {
    }

    public OrderCreatedEvent(UUID orderId, String productID, int quantity, BigDecimal total, String status) {
        this.orderId = orderId;
        this.productID = productID;
        this.quantity = quantity;
        this.total = total;
        this.status = status;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    
}
