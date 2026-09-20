package com.fnb.orderservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fnb.orderservice.dto.InventoryItemRequest;
import com.fnb.orderservice.dto.InventoryItemResponse;
import com.fnb.orderservice.service.InventoryService;

import lombok.AllArgsConstructor;

@RestController 
@AllArgsConstructor 
@RequestMapping ("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @PostMapping("/add")
    public ResponseEntity<InventoryItemResponse> addInventory(@RequestBody InventoryItemRequest inventoryItemRequestDto) {
        
        return ResponseEntity.status(HttpStatus.CREATED).body(inventoryService.addInventoryItem(inventoryItemRequestDto));
    }

}
