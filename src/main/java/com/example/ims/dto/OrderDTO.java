package com.example.ims.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
@Builder
public class OrderDTO {

    private Long id;

    private Date date;

    private Long customerId;

    List<OrderDetailsDTO> orderDetails;

}
