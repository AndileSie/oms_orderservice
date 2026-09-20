package com.fnb.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fnb.orderservice.entity.OrderItem;
@Repository 
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
