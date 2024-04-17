package com.example.ims.service.implementation;

import com.example.ims.Entity.Item;
import com.example.ims.dto.ItemDTO;
import com.example.ims.dto.response.APIResponse;
import com.example.ims.exception.BadRequestException;
import com.example.ims.exception.ResourceNotFoundException;
import com.example.ims.repository.ItemsRepository;
import com.example.ims.service.ItemsServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ItemsService implements ItemsServiceInterface {

    private final ItemsRepository itemsRepository;

    @Autowired
    public ItemsService(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }


    @Override
    public APIResponse<List<ItemDTO>> getAllItems() {
        List<Item> items = itemsRepository.findAll();

        List<ItemDTO> itemDTOList = items
                .stream()
                .map(item -> ItemDTO.builder()
                        .id(item.getItemId())
                        .name(item.getName())
                        .description(item.getDescription())
                        .quantity(item.getQuantity())
                        .price(item.getPrice().doubleValue())
                        .build())
                .toList();

        return APIResponse.ok(itemDTOList, "Items fetched successfully");
    }

    @Override
    @Transactional
    public APIResponse<ItemDTO> createItem(ItemDTO itemDTO) {

        //id should be null when creating a new item
        if (itemDTO.getId() != null) {
            throw new BadRequestException("Id should be null when creating a new item");
        }

        //check if the item already exists by name
        if (itemsRepository.findByName(itemDTO.getName()) != null) {
            throw new BadRequestException("Item with name " + itemDTO.getName() + " already exists");
        }

        //item quantity should be null
        if (itemDTO.getQuantity() != null) {
            throw new BadRequestException("Quantity should be null when creating a new item");
        }

        Item item = Item.builder()
                .name(itemDTO.getName())
                .description(itemDTO.getDescription())
                .quantity(0)
                //convert double to big decimal
                .price(BigDecimal.valueOf(itemDTO.getPrice()))
                .build();

        itemsRepository.save(item);

        return APIResponse.created(ItemDTO.builder()
                .id(item.getItemId())
                .name(item.getName())
                .description(item.getDescription())
                .quantity(item.getQuantity())
                .price(item.getPrice().doubleValue())
                .build(), "Item created successfully");
    }


    @Override
    public APIResponse<ItemDTO> getItemById(Long id) {

        Item item = itemsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Item.class, "id", id.toString()));

        return APIResponse.ok(ItemDTO.builder()
                .id(item.getItemId())
                .name(item.getName())
                .description(item.getDescription())
                .quantity(item.getQuantity())
                .price(item.getPrice().doubleValue())
                .build(), "Item fetched successfully");
    }

    @Override
    @Transactional
    public APIResponse<ItemDTO> updateItem(Long id, ItemDTO itemDTO) {

        Item item = itemsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Item.class, "id", id.toString()));


        item.setName(itemDTO.getName());
        item.setDescription(itemDTO.getDescription());
        item.setPrice(BigDecimal.valueOf(itemDTO.getPrice()));

        itemsRepository.save(item);

        return APIResponse.ok(ItemDTO.builder()
                .id(item.getItemId())
                .name(item.getName())
                .description(item.getDescription())
                .quantity(item.getQuantity())
                .price(item.getPrice().doubleValue())
                .build(), "Item updated successfully");
    }

    @Override
    @Transactional
    public APIResponse<ItemDTO> deleteItem(Long id) {

        Item item = itemsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Item.class, "id", id.toString()));

        itemsRepository.delete(item);

        return APIResponse.deleted(ItemDTO.builder()
                .id(item.getItemId())
                .name(item.getName())
                .description(item.getDescription())
                .quantity(item.getQuantity())
                .price(item.getPrice().doubleValue())
                .build(), "Item deleted successfully");
    }

    @Override
    @Transactional
    public APIResponse<ItemDTO> partialUpdateItem(Long id, ItemDTO itemDTO) {

        Item item = itemsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Item.class, "id", id.toString()));

        if (itemDTO.getName() != null) {
            item.setName(itemDTO.getName());
        }

        if (itemDTO.getDescription() != null) {
            item.setDescription(itemDTO.getDescription());
        }

        if (itemDTO.getPrice() != null) {
            item.setPrice(BigDecimal.valueOf(itemDTO.getPrice()));
        }

        itemsRepository.save(item);

        return APIResponse.ok(ItemDTO.builder()
                .id(item.getItemId())
                .name(item.getName())
                .description(item.getDescription())
                .quantity(item.getQuantity())
                .price(item.getPrice().doubleValue())
                .build(), "Item updated successfully");
    }




}
