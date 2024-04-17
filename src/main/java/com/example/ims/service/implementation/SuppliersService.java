package com.example.ims.service.implementation;

import com.example.ims.Entity.Supplier;
import com.example.ims.dto.SupplierDTO;
import com.example.ims.dto.response.APIResponse;
import com.example.ims.exception.BadRequestException;
import com.example.ims.exception.ResourceNotFoundException;
import com.example.ims.repository.SuppliersRepository;
import com.example.ims.service.SuppliersServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuppliersService implements SuppliersServiceInterface {

    private final SuppliersRepository suppliersRepository;

    @Autowired
    public SuppliersService(SuppliersRepository suppliersRepository) {
        this.suppliersRepository = suppliersRepository;
    }



    @Override
    public APIResponse<List<SupplierDTO>> getAllSuppliers() {
        List<Supplier> suppliers = suppliersRepository.findAll();

        List<SupplierDTO> supplierDTOList = suppliers
                .stream()
                .map(supplier -> SupplierDTO.builder()
                        .id(supplier.getSupplierId())
                        .name(supplier.getName())
                        .address(supplier.getAddress())
                        .email(supplier.getEmail())
                        .phone(supplier.getPhone())
                        .build())
                .toList();

        return APIResponse.ok(supplierDTOList, "Suppliers fetched successfully");
    }

    @Override
    public APIResponse<SupplierDTO> createSupplier(SupplierDTO supplierDTO) {

        //id should be null when creating a new supplier
        if (supplierDTO.getId() != null) {
            throw new BadRequestException("Id should be null when creating a new supplier");
        }

        //check if the user already exists by phone number
        if (suppliersRepository.findByPhone(supplierDTO.getPhone()) != null) {
            throw new BadRequestException("Supplier with phone number " + supplierDTO.getPhone() + " already exists");
        }

        Supplier supplier = Supplier.builder()
                .name(supplierDTO.getName())
                .address(supplierDTO.getAddress())
                .email(supplierDTO.getEmail())
                .phone(supplierDTO.getPhone())
                .build();

        Supplier savedSupplier = suppliersRepository.save(supplier);

        SupplierDTO savedSupplierDTO = SupplierDTO.builder()
                .id(savedSupplier.getSupplierId())
                .name(savedSupplier.getName())
                .address(savedSupplier.getAddress())
                .email(savedSupplier.getEmail())
                .phone(savedSupplier.getPhone())
                .build();

        return APIResponse.created(savedSupplierDTO, "Supplier created successfully");
    }

    @Override
    public APIResponse<SupplierDTO> getSupplierById(Long id) {
        Supplier supplier = suppliersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Supplier.class, "id", id.toString()));

        SupplierDTO supplierDTO = SupplierDTO.builder()
                .id(supplier.getSupplierId())
                .name(supplier.getName())
                .address(supplier.getAddress())
                .email(supplier.getEmail())
                .phone(supplier.getPhone())
                .build();

        return APIResponse.ok(supplierDTO, "Supplier fetched successfully");
    }

    @Override
    public APIResponse<SupplierDTO> updateSupplier(Long id, SupplierDTO supplierDTO) {
        Supplier supplier = suppliersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Supplier.class, "id", id.toString()));

        supplier.setName(supplierDTO.getName());
        supplier.setAddress(supplierDTO.getAddress());
        supplier.setEmail(supplierDTO.getEmail());
        supplier.setPhone(supplierDTO.getPhone());

        Supplier updatedSupplier = suppliersRepository.save(supplier);

        SupplierDTO updatedSupplierDTO = SupplierDTO.builder()
                .id(updatedSupplier.getSupplierId())
                .name(updatedSupplier.getName())
                .address(updatedSupplier.getAddress())
                .email(updatedSupplier.getEmail())
                .phone(updatedSupplier.getPhone())
                .build();

        return APIResponse.ok(updatedSupplierDTO, "Supplier updated successfully");
    }

    @Override
    public APIResponse<SupplierDTO> deleteSupplier(Long id) {
        Supplier supplier = suppliersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Supplier.class, "id", id.toString()));

        suppliersRepository.delete(supplier);

        SupplierDTO supplierDTO = SupplierDTO.builder()
                .id(supplier.getSupplierId())
                .name(supplier.getName())
                .address(supplier.getAddress())
                .email(supplier.getEmail())
                .phone(supplier.getPhone())
                .build();

        return APIResponse.deleted(supplierDTO, "Supplier deleted successfully");
    }

    @Override
    public APIResponse<SupplierDTO> partialUpdateSupplier(Long id, SupplierDTO supplierDTO) {
        Supplier supplier = suppliersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Supplier.class, "id", id.toString()));

        if (supplierDTO.getName() != null) {
            supplier.setName(supplierDTO.getName());
        }

        if (supplierDTO.getAddress() != null) {
            supplier.setAddress(supplierDTO.getAddress());
        }

        if (supplierDTO.getEmail() != null) {
            supplier.setEmail(supplierDTO.getEmail());
        }

        if (supplierDTO.getPhone() != null) {
            supplier.setPhone(supplierDTO.getPhone());
        }

        Supplier updatedSupplier = suppliersRepository.save(supplier);

        SupplierDTO updatedSupplierDTO = SupplierDTO.builder()
                .id(updatedSupplier.getSupplierId())
                .name(updatedSupplier.getName())
                .address(updatedSupplier.getAddress())
                .email(updatedSupplier.getEmail())
                .phone(updatedSupplier.getPhone())
                .build();

        return APIResponse.ok(updatedSupplierDTO, "Supplier updated successfully");
    }


}
