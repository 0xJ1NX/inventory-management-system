package com.example.ims.service;



import com.example.ims.dto.CustomerResponseDTO;
import com.example.ims.dto.response.APIResponse;

import java.util.List;

public interface CustomersServiceInterface {

    // Method to get all customers
    APIResponse<List<CustomerResponseDTO>> getAllCustomers();



}

