package com.example.ims.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderDetailsDTO {

    private long orderDetailId;

    private int quantity;

    private long itemId;

}
