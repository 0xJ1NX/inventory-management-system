package com.example.ims.controller;

import com.example.ims.service.ItemsServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/v1/items")
public class ItemsController {

    private final ItemsServiceInterface itemsServices;

    @Autowired
    public ItemsController(ItemsServiceInterface itemsServices) {
        this.itemsServices = itemsServices;
    }
}
