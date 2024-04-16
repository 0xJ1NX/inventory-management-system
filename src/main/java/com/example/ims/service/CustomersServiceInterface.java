package com.example.ims.service;



import com.example.ims.dto.CustomerDTO;
import com.example.ims.dto.response.APIResponse;

import java.util.List;

public interface CustomersServiceInterface {

    // Method to get all customers
    APIResponse<List<CustomerDTO>> getAllCustomers();

    // Method to create a new customer
    APIResponse<CustomerDTO> createCustomer(CustomerDTO customerDTO);

    // Method to get a customer by id
    APIResponse<CustomerDTO> getCustomerById(Long id);

    // Method to update a customer
    APIResponse<CustomerDTO> updateCustomer(Long id, CustomerDTO customerDTO);

    // Method to delete a customer
    APIResponse<CustomerDTO> deleteCustomer(Long id);

    //partial update
    APIResponse<CustomerDTO> partialUpdateCustomer(Long id, CustomerDTO customerDTO);

//    // Method to get all orders of a customer
//    APIResponse<List<OrderDTO>> getCustomerOrders(Long id);


    //methode to create a new order for a customer
//    APIResponse<OrderDTO> createOrder(Long customerId, OrderDTO orderDTO);





}

