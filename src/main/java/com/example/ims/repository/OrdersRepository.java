package com.example.ims.repository;

import com.example.ims.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Order, Long> {

}
