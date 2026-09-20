package com.fnb.orderservice.service.serciveImp;

import org.springframework.stereotype.Service;

import com.fnb.orderservice.dto.OrderRequestDto;
import com.fnb.orderservice.dto.OrderResponseDto;
import com.fnb.orderservice.repository.OrderRepository;
import com.fnb.orderservice.service.OrderService;

import lombok.AllArgsConstructor;

@Service 
@AllArgsConstructor 
public class OrderServiceImp implements OrderService {
    
    private final OrderRepository orderRepository;

    @Override
    public OrderResponseDto placeOrder(OrderRequestDto orderRequestDto) {
        return null;
    }

    
}
