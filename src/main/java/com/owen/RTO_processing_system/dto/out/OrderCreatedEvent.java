package com.owen.RTO_processing_system.dto.out;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import com.owen.RTO_processing_system.model.OrderItems;
import com.owen.RTO_processing_system.model.OrderStatus;

public class OrderCreatedEvent {
    
    private UUID orderId;
    private BigDecimal total;
    private OrderStatus status;
    private List<OrderItems> items;
    
    public OrderCreatedEvent() {
    }

    public OrderCreatedEvent(UUID orderId, BigDecimal total, OrderStatus status, List<OrderItems> items) {
        this.orderId = orderId;
        this.total = total;
        this.status = status;
        this.items = items;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItems> getItems() {
        return items;
    }

    public void setItems(List<OrderItems> items) {
        this.items = items;
    }

    
    
}
