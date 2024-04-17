package com.example.ims.repository;

import com.example.ims.Entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuppliersRepository extends JpaRepository<Supplier, Long> {

    Supplier findByPhone(String phone);


}
