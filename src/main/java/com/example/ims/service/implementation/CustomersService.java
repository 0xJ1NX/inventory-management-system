package com.example.ims.service.implementation;

import com.example.ims.Entity.Customer;
import com.example.ims.dto.CustomerDTO;
import com.example.ims.dto.response.APIResponse;
import com.example.ims.exception.BadRequestException;
import com.example.ims.exception.ResourceNotFoundException;
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
    public APIResponse<List<CustomerDTO>> getAllCustomers() {
        List<Customer> customers = customersRepository.findAll();

        List<CustomerDTO> customerDTOList = customers
                .stream()
                .map(customer -> CustomerDTO.builder()
                        .id(customer.getCustomerId())
                        .name(customer.getName())
                        .Address(customer.getAddress())
                        .email(customer.getEmail())
                        .phone(customer.getPhone())
                        .build())
                .toList();

        return APIResponse.ok(customerDTOList, "Customers fetched successfully");
    }


    @Override
    public APIResponse<CustomerDTO> createCustomer(CustomerDTO customerDTO) {

        //id should be null when creating a new customer
        if (customerDTO.getId() != null) {
            throw new BadRequestException("Id should be null when creating a new customer");
        }

        //check if the user already exists by phone number
        if (customersRepository.findByPhone(customerDTO.getPhone()) != null) {
            throw new BadRequestException("Customer with phone number " + customerDTO.getPhone() + " already exists");
        }

        //check if the user already exists by email
        if (customersRepository.findByEmail(customerDTO.getEmail()) != null) {
            throw new BadRequestException("email already exists");
        }


        Customer customer = Customer.builder()
                .name(customerDTO.getName())
                .address(customerDTO.getAddress())
                .email(customerDTO.getEmail())
                .phone(customerDTO.getPhone())
                .build();

        Customer savedCustomer = customersRepository.save(customer);

        CustomerDTO savedCustomerDTO = CustomerDTO.builder()
                .id(savedCustomer.getCustomerId())
                .name(savedCustomer.getName())
                .Address(savedCustomer.getAddress())
                .email(savedCustomer.getEmail())
                .phone(savedCustomer.getPhone())
                .build();

        return APIResponse.created(savedCustomerDTO, "Customer created successfully");
    }


    @Override
    public APIResponse<CustomerDTO> getCustomerById(Long id) {
        Customer customer = customersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Customer.class, "id", id.toString()));

        CustomerDTO customerDTO = CustomerDTO.builder()
                .id(customer.getCustomerId())
                .name(customer.getName())
                .Address(customer.getAddress())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .build();

        return APIResponse.ok(customerDTO, "Customer fetched successfully");
    }

    @Override
    public APIResponse<CustomerDTO> updateCustomer(Long id, CustomerDTO customerDTO) {
        Customer customer = customersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Customer.class, "id", id.toString()));

        customer.setName(customerDTO.getName());
        customer.setAddress(customerDTO.getAddress());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhone(customerDTO.getPhone());

        Customer updatedCustomer = customersRepository.save(customer);

        CustomerDTO updatedCustomerDTO = CustomerDTO.builder()
                .id(updatedCustomer.getCustomerId())
                .name(updatedCustomer.getName())
                .Address(updatedCustomer.getAddress())
                .email(updatedCustomer.getEmail())
                .phone(updatedCustomer.getPhone())
                .build();

        return APIResponse.ok(updatedCustomerDTO, "Customer updated successfully");
    }

    @Override
    public APIResponse<CustomerDTO> deleteCustomer(Long id) {
        Customer customer = customersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Customer.class, "id", id.toString()));

        customersRepository.delete(customer);

        CustomerDTO customerDTO = CustomerDTO.builder()
                .id(customer.getCustomerId())
                .name(customer.getName())
                .Address(customer.getAddress())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .build();

        return APIResponse.deleted(customerDTO, "Customer deleted successfully");
    }

    @Override
    public APIResponse<CustomerDTO> partialUpdateCustomer(Long id, CustomerDTO customerDTO) {
        Customer customer = customersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Customer.class, "id", id.toString()));

        if (customerDTO.getName() != null) {
            customer.setName(customerDTO.getName());
        }

        if (customerDTO.getAddress() != null) {
            customer.setAddress(customerDTO.getAddress());
        }

        if (customerDTO.getEmail() != null) {
            customer.setEmail(customerDTO.getEmail());
        }

        if (customerDTO.getPhone() != null) {
            customer.setPhone(customerDTO.getPhone());
        }

        Customer updatedCustomer = customersRepository.save(customer);

        CustomerDTO updatedCustomerDTO = CustomerDTO.builder()
                .id(updatedCustomer.getCustomerId())
                .name(updatedCustomer.getName())
                .Address(updatedCustomer.getAddress())
                .email(updatedCustomer.getEmail())
                .phone(updatedCustomer.getPhone())
                .build();

        return APIResponse.ok(updatedCustomerDTO, "Customer updated successfully");
    }


}
