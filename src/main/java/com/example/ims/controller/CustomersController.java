package com.example.ims.controller;

import com.example.ims.dto.CustomerResponseDTO;
import com.example.ims.dto.response.APIResponse;
import com.example.ims.service.CustomersServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@RequestMapping(value = "/api/v1/customers")
public class CustomersController {


    private final CustomersServiceInterface customersServices;

    @Autowired
    public CustomersController(CustomersServiceInterface customersServices) {
        this.customersServices = customersServices;
    }

    //method to get all customers
    //it returns a list of all customers in json format
    @GetMapping
    public ResponseEntity<Object> getAllCustomers() {
        log.info("Request to get all customers");
        APIResponse<List<CustomerResponseDTO>> response = customersServices.getAllCustomers();
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }


}
