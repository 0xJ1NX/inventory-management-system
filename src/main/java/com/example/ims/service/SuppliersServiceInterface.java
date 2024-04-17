package com.example.ims.service;

import com.example.ims.dto.SupplierDTO;
import com.example.ims.dto.response.APIResponse;

import java.util.List;

public interface SuppliersServiceInterface {

    //method to get all suppliers
    APIResponse<List<SupplierDTO>> getAllSuppliers();

    //method to create a new supplier
    APIResponse<SupplierDTO> createSupplier(SupplierDTO supplierDTO);

    //method to get a supplier by id
    APIResponse<SupplierDTO> getSupplierById(Long id);

    //method to update a supplier
    APIResponse<SupplierDTO> updateSupplier(Long id, SupplierDTO supplierDTO);

    //method to delete a supplier
    APIResponse<SupplierDTO> deleteSupplier(Long id);

    //partial update
    APIResponse<SupplierDTO> partialUpdateSupplier(Long id, SupplierDTO supplierDTO);



}
