package com.example.ims.controller;

import com.example.ims.service.SuppliersServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/suppliers")
public class SuppliersController {

    private final SuppliersServiceInterface suppliersServices;

    @Autowired
    public SuppliersController(SuppliersServiceInterface suppliersServices) {
        this.suppliersServices = suppliersServices;
    }

}
