package com.fnb.orderservice.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data 
@Builder 
public class OrderRequestDto {
    private Long customerId;
    private List<OrderItemRequestDto> items;
}
