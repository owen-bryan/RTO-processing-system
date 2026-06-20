package com.owen.RTO_processing_system.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_items")
@NoArgsConstructor
public class OrderItems {
  
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Getter
    @Setter
    private UUID id;
   
    @ManyToOne
    @JoinColumn (name = "order_id", nullable = false)
    private Order order;
   
    @Column(nullable = false)
    @Getter
    @Setter
    private String productName;
    
    @Column(nullable = false)
    @Getter
    @Setter
    private int quantity;

    @Column(nullable = false)
    @Getter
    @Setter
    private boolean allocated;

    public OrderItems(Order order, String productName, int quantity) {
        this.order = order;
        this.productName = productName;
        this.quantity = quantity;
        this.allocated = false;
    }
    
    
}
