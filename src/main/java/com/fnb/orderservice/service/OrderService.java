package com.fnb.orderservice.service;

import com.fnb.orderservice.dto.OrderRequestDto;
import com.fnb.orderservice.dto.OrderResponseDto;

public interface OrderService {
    OrderResponseDto placeOrder(OrderRequestDto orderRequestDto);
}
