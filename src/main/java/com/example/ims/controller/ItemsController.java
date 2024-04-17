package com.example.ims.controller;

import com.example.ims.dto.ItemDTO;
import com.example.ims.dto.response.APIResponse;
import com.example.ims.service.ItemsServiceInterface;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/api/v1/items")
public class ItemsController {

    private final ItemsServiceInterface itemsServices;

    @Autowired
    public ItemsController(ItemsServiceInterface itemsServices) {
        this.itemsServices = itemsServices;
    }

    //method to get all items
    @GetMapping
    public ResponseEntity<Object> getAllItems() {
        log.info("Request to get all items");
        APIResponse<List<ItemDTO>> response = itemsServices.getAllItems();
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @PostMapping
    public ResponseEntity<Object> createItem(@Valid @RequestBody ItemDTO item) {
        log.info("Request to create a new item: {}", item);
        APIResponse<ItemDTO> response = itemsServices.createItem(item);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getItemById(@PathVariable Long id) {
        log.info("Request to get item by id: {}", id);
        APIResponse<ItemDTO> response = itemsServices.getItemById(id);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateItem(@PathVariable Long id, @Valid @RequestBody ItemDTO item) {
        log.info("Request to update item by id: {}", id);
        APIResponse<ItemDTO> response = itemsServices.updateItem(id, item);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteItem(@PathVariable Long id) {
        log.info("Request to delete item by id: {}", id);
        APIResponse<ItemDTO> response = itemsServices.deleteItem(id);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> partialUpdateItem(@PathVariable Long id, @RequestBody ItemDTO item) {
        log.info("Request to partial update item by id: {}", id);
        APIResponse<ItemDTO> response = itemsServices.partialUpdateItem(id, item);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }



}
