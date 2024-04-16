package com.example.ims.repository;

import com.example.ims.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepository extends JpaRepository<Customer, Long> {
    Customer findByEmail(String email);
    Customer findByPhone(String phone);
    Customer findByCustomerId(Long customerId);
}
