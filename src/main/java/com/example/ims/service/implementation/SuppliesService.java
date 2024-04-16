package com.example.ims.service.implementation;

import com.example.ims.repository.SuppliesRepository;
import com.example.ims.service.SuppliesServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuppliesService implements SuppliesServiceInterface {

    private final SuppliesRepository suppliesRepository;

    @Autowired
    public SuppliesService(SuppliesRepository suppliesRepository) {
        this.suppliesRepository = suppliesRepository;
    }


}
