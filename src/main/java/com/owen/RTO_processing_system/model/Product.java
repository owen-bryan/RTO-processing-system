package com.owen.RTO_processing_system.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "product")
public class Product {
    
    @Id
    @GeneratedValue
    private UUID id;

    @Column (nullable = false)
    private String name;

    @Column (nullable = false)
    private int quanity;

    public Product(String name, int quanity) {
        this.name = name;
        this.quanity = quanity;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuanity() {
        return quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }

    
}
