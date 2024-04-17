package com.example.ims.controller;

import com.example.ims.dto.SupplyDTO;
import com.example.ims.dto.response.APIResponse;
import com.example.ims.service.SuppliesServiceInterface;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/api/v1/supplies")
public class SuppliesController {

    private final SuppliesServiceInterface suppliesServices;

    @Autowired
    public SuppliesController(SuppliesServiceInterface suppliesServices) {
        this.suppliesServices = suppliesServices;
    }


    @GetMapping
    public ResponseEntity<Object> getAllSupplies() {
        log.info("Request to get all supplies");
        APIResponse<List<SupplyDTO>> response = suppliesServices.getAllSupplies();
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @PostMapping
    public ResponseEntity<Object> createSupply(@Valid @RequestBody SupplyDTO supply) {
        log.info("Request to create a new supply: {}", supply);
        APIResponse<SupplyDTO> response = suppliesServices.createSupply(supply);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getSupplyById(@PathVariable Long id) {
        log.info("Request to get supply by id: {}", id);
        APIResponse<SupplyDTO> response = suppliesServices.getSupplyById(id);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateSupply(@PathVariable Long id, @Valid @RequestBody SupplyDTO supply) {
        log.info("Request to update supply by id: {}", id);
        APIResponse<SupplyDTO> response = suppliesServices.updateSupply(id, supply);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSupply(@PathVariable Long id) {
        log.info("Request to delete supply by id: {}", id);
        APIResponse<SupplyDTO> response = suppliesServices.deleteSupply(id);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> updateSupplyStatus(@PathVariable Long id, @RequestBody SupplyDTO supply) {
        log.info("Request to update supply status by id: {}", id);
        APIResponse<SupplyDTO> response = suppliesServices.partialUpdateSupply(id, supply);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

}
