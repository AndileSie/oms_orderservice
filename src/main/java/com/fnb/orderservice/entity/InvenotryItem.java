package com.fnb.orderservice.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
@Builder 
@Data 
@Entity 
@Table(name = "inventory_items")
public class InvenotryItem {

    @Id 
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long itemId;

    private String itemName;
    private String description;
    private float price;
    private int stockQuantity;
    private int version;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PostPersist
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

}
