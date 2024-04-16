package com.example.ims.service.implementation;

import com.example.ims.repository.ItemsRepository;
import com.example.ims.service.ItemsServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemsService implements ItemsServiceInterface {

    private final ItemsRepository itemsRepository;

    @Autowired
    public ItemsService(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

}
