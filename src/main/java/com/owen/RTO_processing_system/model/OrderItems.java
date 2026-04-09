package com.owen.RTO_processing_system.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_items")
public class OrderItems {
  
    @Id
    @GeneratedValue
    private UUID id;
   
    @Column(nullable = false)
    private UUID orderID;
   
    @Column(nullable = false)
    private String productName;
    
    @Column(nullable = false)
    private int quanity;
    
    public OrderItems() {
    }

    public OrderItems(UUID orderID, String productName, int quanity) {
        this.orderID = orderID;
        this.productName = productName;
        this.quanity = quanity;
    }

    public UUID getOrderManifestID() {
        return id;
    }

    public void setOrderManifestID(UUID id) {
        this.id = id;
    }

    public UUID getOrderID() {
        return orderID;
    }

    public void setOrderID(UUID orderID) {
        this.orderID = orderID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuanity() {
        return quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }

    
}
