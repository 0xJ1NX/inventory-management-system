package com.example.ims.controller;

import com.example.ims.dto.OrderDTO;
import com.example.ims.dto.response.APIResponse;
import com.example.ims.service.OrdersServiceInterface;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/api/v1/orders")
public class OrdersController {

    private final OrdersServiceInterface ordersServices;

    @Autowired
    public OrdersController(OrdersServiceInterface ordersServices) {
        this.ordersServices = ordersServices;
    }

    @GetMapping
    public ResponseEntity<Object> getAllOrders() {
        log.info("Request to get all orders");
        APIResponse<List<OrderDTO>> response = ordersServices.getAllOrders();
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @PostMapping
    public ResponseEntity<Object> createOrder(@Valid @RequestBody OrderDTO order) {
        log.info("Request to create a new order: {}", order);
        APIResponse<OrderDTO> response = ordersServices.createOrder(order);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOrderById(@PathVariable Long id) {
        log.info("Request to get order by id: {}", id);
        APIResponse<OrderDTO> response = ordersServices.getOrderById(id);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateOrder(@PathVariable Long id,@Valid @RequestBody OrderDTO order) {
        log.info("Request to update order by id: {}", id);
        APIResponse<OrderDTO> response = ordersServices.updateOrder(id, order);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteOrder(@PathVariable Long id) {
        log.info("Request to delete order by id: {}", id);
        APIResponse<OrderDTO> response = ordersServices.deleteOrder(id);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> partialUpdateOrder(@PathVariable Long id, @RequestBody OrderDTO order) {
        log.info("Request to partial update order by id: {}", id);
        APIResponse<OrderDTO> response = ordersServices.partialUpdateOrder(id, order);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

}
