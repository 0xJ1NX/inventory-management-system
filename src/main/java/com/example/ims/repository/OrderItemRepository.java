package com.example.ims.repository;

import com.example.ims.Entity.OrderItem;
import com.example.ims.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    //find All order items by order
    List<OrderItem> findAllByOrder(Orders order);

    void deleteAllByOrder(Orders order);
}
