package com.fnb.orderservice.service;

import com.fnb.orderservice.dto.*;

public interface InventoryService {
    InventoryItemResponse addInventoryItem(InventoryItemRequest inventoryItemRequestDto);
}
