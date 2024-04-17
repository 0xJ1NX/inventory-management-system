package com.example.ims.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
@Builder
public class OrderDTO {

    private Long id;

    private Date date;

    @NotBlank(message = "Customer ID is required")
    private Long customerId;

    @JsonAlias("orderItems")
    List<OrderItemsDTO> orderItemsDTOS;

}
