package com.fnb.orderservice.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Builder 
@Data 
public class OrderResponseDto {
    private Long orderId;
    private Long customerId;
    private int quantity;
    private String status;
    private LocalDateTime orderDate;
    private BigDecimal totalAmount;
}
