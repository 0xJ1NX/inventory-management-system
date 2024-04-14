package com.example.ims.service.implementation;

import com.example.ims.Entity.Customer;
import com.example.ims.dto.CustomerAdditionDTO;
import com.example.ims.dto.CustomerReturnDTO;
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

//    @Override
//    public List<CustomerReturnDTO> getAllCustomers() {
//
//        List<Customer> customers = customersRepository.findAll();
//
//    }


}
