package com.fnb.orderservice.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Builder 
@Data 
public class InventoryItemResponse {
    private Long itemId;

    private String itemName;
    private String description;
    private BigDecimal price;
    private int stockQuantity;
    private int version;
}
