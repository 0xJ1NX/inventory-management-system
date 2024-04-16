package com.example.ims.service.implementation;

import com.example.ims.repository.SuppliersRepository;
import com.example.ims.service.SuppliersServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuppliersService implements SuppliersServiceInterface {

    private final SuppliersRepository suppliersRepository;

    @Autowired
    public SuppliersService(SuppliersRepository suppliersRepository) {
        this.suppliersRepository = suppliersRepository;
    }



}
