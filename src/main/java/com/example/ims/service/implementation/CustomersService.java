package com.example.ims.service.implementation;

import com.example.ims.Entity.Customer;
import com.example.ims.dto.CustomerResponseDTO;
import com.example.ims.dto.response.APIResponse;
import com.example.ims.repository.CustomersRepository;
import com.example.ims.service.CustomersServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CustomersService implements CustomersServiceInterface {

    private final CustomersRepository customersRepository;

    @Autowired
    public CustomersService(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    @Override
    public APIResponse<List<CustomerResponseDTO>> getAllCustomers() {
        List<Customer> customers = customersRepository.findAll();

        List<CustomerResponseDTO> customerResponseDTOList = customers
                .stream()
                .map(customer -> CustomerResponseDTO.builder()
                        .id(customer.getCustomerId())
                        .name(customer.getName())
                        .Address(customer.getAddress())
                        .email(customer.getEmail())
                        .phone(customer.getPhone())
                        .build())
                .toList();

        return APIResponse.ok(customerResponseDTOList, "Customers fetched successfully");
    }





}
