package com.example.ims.controller;

import com.example.ims.service.OrdersServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/v1/orders")
public class OrdersController {

    private final OrdersServiceInterface ordersServices;

    @Autowired
    public OrdersController(OrdersServiceInterface ordersServices) {
        this.ordersServices = ordersServices;
    }

}
