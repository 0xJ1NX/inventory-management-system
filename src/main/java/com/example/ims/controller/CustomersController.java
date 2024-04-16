package com.example.ims.controller;

import com.example.ims.dto.CustomerCreationDTO;
import com.example.ims.dto.CustomerResponseDTO;
import com.example.ims.dto.response.APIResponse;
import com.example.ims.service.CustomersServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping
    public ResponseEntity<Object> getAllCustomers() {
        log.info("Request to get all customers");
        APIResponse<List<CustomerResponseDTO>> response = customersServices.getAllCustomers();
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }


//    @PostMapping
//    public ResponseEntity<Object> createCustomer(@RequestBody CustomerCreationDTO customer) {
//        log.info("Request to create a new customer: {}", customer);
//        APIResponse<CustomerResponseDTO> response = customersServices.createCustomer(customer);
//        return ResponseEntity.status(response.getHttpStatus()).body(response);
//    }
//
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Object> getCustomerById(@PathVariable Long id) {
//        log.info("Request to get customer by id: {}", id);
//        APIResponse<CustomerResponseDTO> response = customersServices.getCustomerById(id);
//        return ResponseEntity.status(response.getHttpStatus()).body(response);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Object> updateCustomer(@PathVariable Long id, @RequestBody CustomerCreationDTO customer) {
//        log.info("Request to update customer by id: {}", id);
//        APIResponse<CustomerResponseDTO> response = customersServices.updateCustomer(id, customer);
//        return ResponseEntity.status(response.getHttpStatus()).body(response);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Object> deleteCustomer(@PathVariable Long id) {
//        log.info("Request to delete customer by id: {}", id);
//        APIResponse<CustomerResponseDTO> response = customersServices.deleteCustomer(id);
//        return ResponseEntity.status(response.getHttpStatus()).body(response);
//    }
//
//    //partial update
//    @PatchMapping("/{id}")
//    public ResponseEntity<Object> patchCustomer(@PathVariable Long id, @RequestBody CustomerCreationDTO customer) {
//        log.info("Request to patch customer by id: {}", id);
//        APIResponse<CustomerResponseDTO> response = customersServices.patchCustomer(id, customer);
//        return ResponseEntity.status(response.getHttpStatus()).body(response);
//    }
//

}
