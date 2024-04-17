package com.example.ims.service;

import com.example.ims.dto.ItemDTO;
import com.example.ims.dto.response.APIResponse;

import java.util.List;

public interface ItemsServiceInterface {

    //method to get all items
    APIResponse<List<ItemDTO>> getAllItems();

    //method to create a new item
    APIResponse<ItemDTO> createItem(ItemDTO itemDTO);

    //method to get item by id
    APIResponse<ItemDTO> getItemById(Long id);

    //method to update an item
    APIResponse<ItemDTO> updateItem(Long id, ItemDTO itemDTO);

    //method to delete an item
    APIResponse<ItemDTO> deleteItem(Long id);

    //partial update
    APIResponse<ItemDTO> partialUpdateItem(Long id, ItemDTO itemDTO);


}
