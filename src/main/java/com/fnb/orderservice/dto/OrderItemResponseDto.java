package com.fnb.orderservice.dto;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data 
@Builder 

public class OrderItemResponseDto {

    private Long orderItemId;
    private int quantity;
    private BigDecimal price;
    private BigDecimal totalPrice;
    

}
