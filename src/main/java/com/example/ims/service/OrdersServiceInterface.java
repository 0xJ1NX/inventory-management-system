package com.example.ims.service;

import com.example.ims.dto.OrderDTO;
import com.example.ims.dto.response.APIResponse;

import java.util.List;

public interface OrdersServiceInterface {

    // Method to get all orders
    APIResponse<List<OrderDTO>> getAllOrders();

    // Method to create a new order
    APIResponse<OrderDTO> createOrder(OrderDTO orderDTO);

    // Method to get order by id
    APIResponse<OrderDTO> getOrderById(Long id);

    // Method to update order by id
    APIResponse<OrderDTO> updateOrder(Long id, OrderDTO orderDTO);

    // Method to delete order by id
    APIResponse<OrderDTO> deleteOrder(Long id);

    //partial update
    APIResponse<OrderDTO> partialUpdateOrder(Long id, OrderDTO orderDTO);



}
