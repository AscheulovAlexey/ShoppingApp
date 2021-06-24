package com.app.shopping.inventoryservice.controller;

import com.app.shopping.inventoryservice.model.Inventory;
import com.app.shopping.inventoryservice.repository.InventoryRepository;
import jdk.jshell.spi.ExecutionControl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryRestController {

    private final InventoryRepository inventoryRepository;

    @GetMapping("/{scuCode}")
    Boolean isInStock(@PathVariable String skuCode){
        Inventory inventory = inventoryRepository.findBySkuCode(skuCode)
                .orElseThrow(() -> new RuntimeException("Cannot find Product by sku code" + skuCode));
        return inventory.getStock() > 0;
    }
}
