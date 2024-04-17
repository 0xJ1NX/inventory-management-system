package com.example.ims.dto;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SupplyDTO {

    private Long id;

    @NotNull(message = "Item ID is required")
    private Long itemId;

    @NotNull(message = "Supplier ID is required")
    private Long supplierId;

    @NotNull(message = "Quantity is required")
    private Integer quantity;

    @NotNull(message = "Price per unit is required")
    private Double ppu;

    private Date date;

}
