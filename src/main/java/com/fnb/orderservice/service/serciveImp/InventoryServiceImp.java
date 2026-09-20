package com.fnb.orderservice.service.serciveImp;

import org.springframework.stereotype.Service;

import com.fnb.orderservice.dto.InventoryItemRequest;
import com.fnb.orderservice.dto.InventoryItemResponse;
import com.fnb.orderservice.entity.InvenotryItem;
import com.fnb.orderservice.repository.InventoryItemRepository;
import com.fnb.orderservice.service.InventoryService;

import lombok.AllArgsConstructor;

@Service 
@AllArgsConstructor 
public class InventoryServiceImp implements InventoryService {

    private final InventoryItemRepository inventoryItemRepository;
    @Override
    public InventoryItemResponse addInventoryItem(InventoryItemRequest inventoryItemRequestDto) {
        
        InvenotryItem inventoryItem = InvenotryItem.builder()
                .itemName(inventoryItemRequestDto.getItemName())
                .stockQuantity(inventoryItemRequestDto.getStockQuantity())
                .price(inventoryItemRequestDto.getPrice())
                .description(inventoryItemRequestDto.getDescription())
                .build();

        inventoryItem = inventoryItemRepository.save(inventoryItem);

        return InventoryItemResponse.builder()
                .itemId(inventoryItem.getItemId())
                .itemName(inventoryItem.getItemName())
                .stockQuantity(inventoryItem.getStockQuantity())
                .price(inventoryItem.getPrice())
                .description(inventoryItem.getDescription())
                .build();
    }

}
