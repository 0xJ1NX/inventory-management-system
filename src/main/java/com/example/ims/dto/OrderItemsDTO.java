package com.example.ims.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderItemsDTO {

    private Long id;

    private Integer quantity;

    private Long itemId;

}
