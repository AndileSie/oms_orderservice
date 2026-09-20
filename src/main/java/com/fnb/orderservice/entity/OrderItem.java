package com.fnb.orderservice.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data 
@Entity 
@Table (name = "order_items")
@Builder 
public class OrderItem {
    @Id 
    @GeneratedValue (strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long orderItemId;
    
    @ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
    @JoinColumn(name = "orderId", nullable = false)
    private Order order;

    @ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
    @JoinColumn(name = "itemId", nullable = false)
    private InvenotryItem inventoryItem;

    private int quantity;

    private BigDecimal unitPriceAtPurchase;

    private BigDecimal subTotal;
}
