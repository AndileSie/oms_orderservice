package com.fnb.orderservice.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fnb.orderservice.entity.InvenotryItem;
@Repository 
public interface InventoryItemRepository extends JpaRepository<InvenotryItem, Long> {

    
} 