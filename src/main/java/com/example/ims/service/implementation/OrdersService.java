package com.example.ims.service.implementation;

import com.example.ims.Entity.Customer;
import com.example.ims.Entity.Item;
import com.example.ims.Entity.OrderItem;
import com.example.ims.Entity.Orders;
import com.example.ims.dto.OrderDTO;
import com.example.ims.dto.OrderItemsDTO;
import com.example.ims.dto.response.APIResponse;
import com.example.ims.exception.BadRequestException;
import com.example.ims.exception.ResourceNotFoundException;
import com.example.ims.repository.CustomersRepository;
import com.example.ims.repository.ItemsRepository;
import com.example.ims.repository.OrderItemRepository;
import com.example.ims.repository.OrdersRepository;
import com.example.ims.service.OrdersServiceInterface;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class OrdersService implements OrdersServiceInterface {

    private final OrdersRepository ordersRepository;
    private final OrderItemRepository orderItemRepository;
    private final CustomersRepository customersRepository;
    private final ItemsRepository itemsRepository;

    @Autowired
    public OrdersService(OrdersRepository ordersRepository, OrderItemRepository orderItemRepository, CustomersRepository customersRepository, ItemsRepository itemsRepository) {
        this.ordersRepository = ordersRepository;
        this.orderItemRepository = orderItemRepository;
        this.customersRepository = customersRepository;
        this.itemsRepository = itemsRepository;
    }

    @Override
    public APIResponse<List<OrderDTO>> getAllOrders() {
        List<Orders> orders = ordersRepository.findAll();

        //get all orders and the items in each order
        List<OrderDTO> orderDTOList = orders
                .stream()
                .map(order -> OrderDTO.builder()
                        .id(order.getOrderId())
                        .customerId(order.getCustomer().getCustomerId())
                        .date(order.getDate())
                        .orderItemsDTOS(orderItemRepository.findAllByOrder(order)
                                .stream()
                                .map(orderItem -> OrderItemsDTO.builder()
                                        .id(orderItem.getOrderItemId())
                                        .itemId(orderItem.getItem().getItemId())
                                        .quantity(orderItem.getQuantity())
                                        .build())
                                .toList())
                        .build())
                .toList();
        return APIResponse.ok(orderDTOList, "Orders fetched successfully");
    }

    // Method to create a new order
    @Override
    @Transactional
    public APIResponse<OrderDTO> createOrder(OrderDTO orderDTO) {

        //every order must have at least one item
        if (orderDTO.getOrderItemsDTOS().isEmpty()) {
            throw new BadRequestException("Order must have at least one item");
        }

        //check if the customer exists
        Customer customer = customersRepository.findById(orderDTO.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException(Customer.class, "id", orderDTO.getCustomerId().toString()));



        //check if the item exists and quantity is enough
        for (OrderItemsDTO orderItemsDTO : orderDTO.getOrderItemsDTOS()) {

            if (!itemsRepository.existsById(orderItemsDTO.getItemId())) {
                throw new ResourceNotFoundException(Item.class, "id", orderItemsDTO.getItemId().toString());
            }

            Item item = itemsRepository.findById(orderItemsDTO.getItemId()).get();
            if (item.getQuantity() < orderItemsDTO.getQuantity()) {
                throw new BadRequestException("Item with id " + orderItemsDTO.getItemId() + " does not have enough quantity");
            }
        }




        //create the order
        Orders order = Orders.builder()
                .customer(customer)
                //the date is set to the current server time
                .date(new Date())
                .build();
        ordersRepository.save(order);



        //create the order items
        for (OrderItemsDTO orderItemsDTO : orderDTO.getOrderItemsDTOS()) {
            orderItemRepository.save(OrderItem.builder()
                    .order(order)
                    .item(itemsRepository.findById(orderItemsDTO.getItemId()).get())
                    .quantity(orderItemsDTO.getQuantity())
                    .build());

            //update the item quantity
            Item item = itemsRepository.findById(orderItemsDTO.getItemId()).get();
            item.setQuantity(item.getQuantity() - orderItemsDTO.getQuantity());
            itemsRepository.save(item);

        }

        //create the orderDTO to return
        OrderDTO savedOrderDTO = OrderDTO.builder()
                .id(order.getOrderId())
                .customerId(order.getCustomer().getCustomerId())
                .date(order.getDate())
                .orderItemsDTOS(orderItemRepository.findAllByOrder(order)
                        .stream()
                        .map(orderItem -> OrderItemsDTO.builder()
                                .id(orderItem.getOrderItemId())
                                .itemId(orderItem.getItem().getItemId())
                                .quantity(orderItem.getQuantity())
                                .build())
                        .toList())
                .build();


        return APIResponse.created(savedOrderDTO, "Order created successfully");

    }

    @Override
    public APIResponse<OrderDTO> getOrderById(Long id) {
        Orders order = ordersRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Orders.class, "id", id.toString()));

        OrderDTO orderDTO = OrderDTO.builder()
                .id(order.getOrderId())
                .customerId(order.getCustomer().getCustomerId())
                .date(order.getDate())
                .orderItemsDTOS(orderItemRepository.findAllByOrder(order)
                        .stream()
                        .map(orderItem -> OrderItemsDTO.builder()
                                .id(orderItem.getOrderItemId())
                                .itemId(orderItem.getItem().getItemId())
                                .quantity(orderItem.getQuantity())
                                .build())
                        .toList())
                .build();

        return APIResponse.ok(orderDTO, "Order fetched successfully");
    }

    @Override
    @Transactional
    public APIResponse<OrderDTO> updateOrder(Long id, OrderDTO orderDTO) {
        Orders order = ordersRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Orders.class, "id", id.toString()));

        //check if the customer exists
        Customer customer = customersRepository.findById(orderDTO.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException(Customer.class, "id", orderDTO.getCustomerId().toString()));

        //update the order
        order.setCustomer(customer);
        ordersRepository.save(order);

        //check if the item exists
        for (OrderItemsDTO orderItemsDTO : orderDTO.getOrderItemsDTOS()) {

            if (!itemsRepository.existsById(orderItemsDTO.getItemId())) {
                throw new ResourceNotFoundException(Item.class, "id", orderItemsDTO.getItemId().toString());
            }

        }


        //delete all the order items and reset the item quantity
        for (OrderItem orderItem : orderItemRepository.findAllByOrder(order)) {
            Item item = orderItem.getItem();
            item.setQuantity(item.getQuantity() + orderItem.getQuantity());
            itemsRepository.save(item);

            orderItemRepository.delete(orderItem);
        }



        //create the order items
        for (OrderItemsDTO orderItemsDTO : orderDTO.getOrderItemsDTOS()) {
            orderItemRepository.save(OrderItem.builder()
                    .order(order)
                    .item(itemsRepository.findById(orderItemsDTO.getItemId()).get())
                    .quantity(orderItemsDTO.getQuantity())
                    .build());

            //update the item quantity
            Item item = itemsRepository.findById(orderItemsDTO.getItemId()).get();
            item.setQuantity(item.getQuantity() - orderItemsDTO.getQuantity());
            itemsRepository.save(item);
        }

        //create the orderDTO to return
        OrderDTO savedOrderDTO = OrderDTO.builder()
                .id(order.getOrderId())
                .customerId(order.getCustomer().getCustomerId())
                .date(order.getDate())
                .orderItemsDTOS(orderItemRepository.findAllByOrder(order)
                        .stream()
                        .map(orderItem -> OrderItemsDTO.builder()
                                .id(orderItem.getOrderItemId())
                                .itemId(orderItem.getItem().getItemId())
                                .quantity(orderItem.getQuantity())
                                .build())
                        .toList())
                .build();

        return APIResponse.ok(savedOrderDTO, "Order updated successfully");
    }

    @Override
    @Transactional
    public APIResponse<OrderDTO> deleteOrder(Long id) {
        Orders order = ordersRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Orders.class, "id", id.toString()));

        //change the quantity of the items in the order
        for (OrderItem orderItem : orderItemRepository.findAllByOrder(order)) {
            Item item = orderItem.getItem();
            item.setQuantity(item.getQuantity() + orderItem.getQuantity());
            itemsRepository.save(item);

            orderItemRepository.delete(orderItem);
        }

        ordersRepository.delete(order);

        return APIResponse.deleted(null, "Order deleted successfully");
    }


    @Override
    @Transactional
    public APIResponse<OrderDTO> partialUpdateOrder(Long id, OrderDTO orderDTO) {
        Orders order = ordersRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Orders.class, "id", id.toString()));

        //check if the customer attribute is present
        if (orderDTO.getCustomerId() != null) {
            Customer customer = customersRepository.findById(orderDTO.getCustomerId())
                    .orElseThrow(() -> new ResourceNotFoundException(Customer.class, "id", orderDTO.getCustomerId().toString()));
            order.setCustomer(customer);

            //update the order
            ordersRepository.save(order);
        }



        //check if the order items attribute is present
        if (orderDTO.getOrderItemsDTOS() != null) {

            //check if the item exists
            for (OrderItemsDTO orderItemsDTO : orderDTO.getOrderItemsDTOS()) {

                if (!itemsRepository.existsById(orderItemsDTO.getItemId())) {
                    throw new ResourceNotFoundException(Item.class, "id", orderItemsDTO.getItemId().toString());
                }

            }

            //change the quantity of the items in the order
            for (OrderItem orderItem : orderItemRepository.findAllByOrder(order)) {
                Item item = orderItem.getItem();
                item.setQuantity(item.getQuantity() + orderItem.getQuantity());
                itemsRepository.save(item);

                orderItemRepository.delete(orderItem);
            }


            //create the order items
            for (OrderItemsDTO orderItemsDTO : orderDTO.getOrderItemsDTOS()) {
                orderItemRepository.save(OrderItem.builder()
                        .order(order)
                        .item(itemsRepository.findById(orderItemsDTO.getItemId()).get())
                        .quantity(orderItemsDTO.getQuantity())
                        .build());

                //update the item quantity
                Item item = itemsRepository.findById(orderItemsDTO.getItemId()).get();
                item.setQuantity(item.getQuantity() - orderItemsDTO.getQuantity());
                itemsRepository.save(item);

            }
        }

        //create the orderDTO to return
        OrderDTO savedOrderDTO = OrderDTO.builder()
                .id(order.getOrderId())
                .customerId(order.getCustomer().getCustomerId())
                .date(order.getDate())
                .orderItemsDTOS(orderItemRepository.findAllByOrder(order)
                        .stream()
                        .map(orderItem -> OrderItemsDTO.builder()
                                .id(orderItem.getOrderItemId())
                                .itemId(orderItem.getItem().getItemId())
                                .quantity(orderItem.getQuantity())
                                .build())
                        .toList())
                .build();

        return APIResponse.ok(savedOrderDTO, "Order updated successfully");
    }

}
