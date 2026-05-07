package com.owen.RTO_processing_system.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_items")
public class OrderItems {
  
    @Id
    @GeneratedValue
    private UUID id;
   
    @ManyToOne
    @JoinColumn (name = "order_id", nullable = false)
    private Order order;
   
    @Column(nullable = false)
    private String productName;
    
    @Column(nullable = false)
    private int quantity;
    
    public OrderItems() {
    }

    public OrderItems(Order order, String productName, int quantity) {
        this.order = order;
        this.productName = productName;
        this.quantity = quantity;
    }

    public UUID getOrderManifestID() {
        return id;
    }

    public void setOrderManifestID(UUID id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
}
