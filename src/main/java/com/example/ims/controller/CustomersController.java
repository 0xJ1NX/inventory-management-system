package com.example.ims.controller;

import com.example.ims.service.CustomersServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomersController {

    private final CustomersServiceInterface customersServices;

    @Autowired
    public CustomersController(CustomersServiceInterface customersServices) {
        this.customersServices = customersServices;
    }










}
