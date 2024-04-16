package com.example.ims.dto;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class CustomerResponseDTO {
    private Long id;

    private String name;

    private String Address;

    private String email;

    private String phone;
}
