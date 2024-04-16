package com.example.ims.service.implementation;

import com.example.ims.repository.OrdersRepository;
import com.example.ims.service.OrdersServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService implements OrdersServiceInterface {

    private final OrdersRepository ordersRepository;

    @Autowired
    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }



}
