package com.example.ims.controller;

import com.example.ims.dto.SupplierDTO;
import com.example.ims.dto.response.APIResponse;
import com.example.ims.service.SuppliersServiceInterface;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/api/v1/suppliers")
public class SuppliersController {

    private final SuppliersServiceInterface suppliersServices;

    @Autowired
    public SuppliersController(SuppliersServiceInterface suppliersServices) {
        this.suppliersServices = suppliersServices;
    }

    @GetMapping
    public ResponseEntity<Object> getAllSuppliers() {
        log.info("Request to get all suppliers");
        APIResponse<List<SupplierDTO>> response = suppliersServices.getAllSuppliers();
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @PostMapping
    public ResponseEntity<Object> createSupplier(@Valid @RequestBody SupplierDTO supplier) {
        log.info("Request to create a new supplier: {}", supplier);
        APIResponse<SupplierDTO> response = suppliersServices.createSupplier(supplier);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getSupplierById(@PathVariable Long id) {
        log.info("Request to get supplier by id: {}", id);
        APIResponse<SupplierDTO> response = suppliersServices.getSupplierById(id);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateSupplier(@PathVariable Long id,@Valid @RequestBody SupplierDTO supplier) {
        log.info("Request to update supplier by id: {}", id);
        APIResponse<SupplierDTO> response = suppliersServices.updateSupplier(id, supplier);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSupplier(@PathVariable Long id) {
        log.info("Request to delete supplier by id: {}", id);
        APIResponse<SupplierDTO> response = suppliersServices.deleteSupplier(id);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> partialUpdateSupplier(@PathVariable Long id, @RequestBody SupplierDTO supplier) {
        log.info("Request to partial update supplier by id: {}", id);
        APIResponse<SupplierDTO> response = suppliersServices.partialUpdateSupplier(id, supplier);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

}
