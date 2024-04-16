package com.example.ims.controller;

import com.example.ims.service.SuppliesServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/v1/supplies")
public class SuppliesController {

    private final SuppliesServiceInterface suppliesServices;

    @Autowired
    public SuppliesController(SuppliesServiceInterface suppliesServices) {
        this.suppliesServices = suppliesServices;
    }

}
