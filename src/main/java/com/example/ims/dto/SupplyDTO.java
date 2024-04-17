package com.example.ims.dto;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SupplyDTO {

    private Long id;

    @NotBlank(message = "Item ID is required")
    private Long itemId;

    @NotBlank(message = "Supplier ID is required")
    private Long supplierId;

    @NotBlank(message = "Quantity is required")
    private Integer quantity;

    @NotBlank(message = "Price Per Unit is required")
    private Double ppu;

    private Date date;

}
