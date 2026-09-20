package com.fnb.orderservice.dto;

import lombok.Builder;
import lombok.Data;

@Data 
@Builder 
public class OrderItemRequestDto {
    private Long orderItemId;
    private int quantity;
}
