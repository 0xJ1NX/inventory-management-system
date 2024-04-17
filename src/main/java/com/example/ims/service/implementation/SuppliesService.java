package com.example.ims.service.implementation;

import com.example.ims.Entity.Item;
import com.example.ims.Entity.Supplier;
import com.example.ims.Entity.Supply;
import com.example.ims.dto.SupplyDTO;
import com.example.ims.dto.response.APIResponse;
import com.example.ims.exception.BadRequestException;
import com.example.ims.exception.ResourceNotFoundException;
import com.example.ims.repository.ItemsRepository;
import com.example.ims.repository.SuppliersRepository;
import com.example.ims.repository.SuppliesRepository;
import com.example.ims.service.SuppliesServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SuppliesService implements SuppliesServiceInterface {

    private final SuppliesRepository suppliesRepository;
    private final ItemsRepository itemsRepository;
    private final SuppliersRepository suppliersRepository;

    @Autowired
    public SuppliesService(SuppliesRepository suppliesRepository, ItemsRepository itemsRepository, SuppliersRepository supplier) {
        this.suppliesRepository = suppliesRepository;
        this.itemsRepository = itemsRepository;
        this.suppliersRepository = supplier;
    }

    @Override
    public APIResponse<List<SupplyDTO>> getAllSupplies() {
        List<Supply> supplies = suppliesRepository.findAll();

        List<SupplyDTO> supplyDTOSList = supplies
                .stream()
                .map(supply -> SupplyDTO.builder()
                        .id(supply.getSupplyID())
                        .itemId(supply.getItem().getItemId())
                        .quantity(supply.getQuantity())
                        .ppu(supply.getPpu().doubleValue())
                        .supplierId(supply.getSupplier().getSupplierId())
                        .date(supply.getDate())
                        .build())
                .toList();
        return APIResponse.ok(supplyDTOSList, "Supplies fetched successfully");
    }

    @Override
    @Transactional
    public APIResponse<SupplyDTO> createSupply(SupplyDTO supplyDTO) {
        //id should be null when creating a new supply
        if (supplyDTO.getId() != null) {
            throw new BadRequestException("Id should be null when creating a new supply");
        }

        //Date should be null when creating a new supply
        if (supplyDTO.getDate() != null) {
            throw new BadRequestException("Date should be null when creating a new supply");
        }

        //check if the item exists
        if (itemsRepository.findById(supplyDTO.getItemId()).isEmpty()) {
            throw new ResourceNotFoundException(Item.class, "id", supplyDTO.getItemId().toString());
        }

        //check if supplier exists
        if (suppliersRepository.findById(supplyDTO.getSupplierId()).isEmpty()) {
            throw new ResourceNotFoundException(Supplier.class, "id", supplyDTO.getSupplierId().toString());
        }

        Supply supply = Supply.builder()
                .item(itemsRepository.findById(supplyDTO.getItemId()).get())
                .quantity(supplyDTO.getQuantity())
                .ppu(BigDecimal.valueOf(supplyDTO.getPpu()))
                .supplier(suppliersRepository.findById(supplyDTO.getSupplierId()).get())
                .date(new Date())
                .build();

        suppliesRepository.save(supply);

        //change the quantity of the item in the items table
        Item item = itemsRepository.findById(supplyDTO.getItemId()).get();
        item.setQuantity(item.getQuantity() + supplyDTO.getQuantity());
        itemsRepository.save(item);


        return APIResponse.created(SupplyDTO.builder()
                .id(supply.getSupplyID())
                .itemId(supply.getItem().getItemId())
                .quantity(supply.getQuantity())
                .ppu(supply.getPpu().doubleValue())
                .supplierId(supply.getSupplier().getSupplierId())
                .date(supply.getDate())
                .build(), "Supply created successfully");


    }


    @Override
    public APIResponse<SupplyDTO> getSupplyById(Long id) {
        Supply supply = suppliesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Supply.class, "id", id.toString()));

        SupplyDTO supplyDTO = SupplyDTO.builder()
                .id(supply.getSupplyID())
                .itemId(supply.getItem().getItemId())
                .quantity(supply.getQuantity())
                .ppu(supply.getPpu().doubleValue())
                .supplierId(supply.getSupplier().getSupplierId())
                .date(supply.getDate())
                .build();

        return APIResponse.ok(supplyDTO, "Supply fetched successfully");
    }

    @Override
    @Transactional
    public APIResponse<SupplyDTO> updateSupply(Long id, SupplyDTO supplyDTO) {

        Supply supply = suppliesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Supply.class, "id", id.toString()));

        //id should not be updated
        if (supplyDTO.getId() != null) {
            throw new BadRequestException("Id should not be updated");
        }

        //date should not be updated
        if (supplyDTO.getDate() != null) {
            throw new BadRequestException("Date should not be updated");
        }

        //check if the item exists
        if (itemsRepository.findById(supplyDTO.getItemId()).isEmpty()) {
            throw new ResourceNotFoundException(Item.class, "id", supplyDTO.getItemId().toString());
        }

        //check if supplier exists
        if (suppliersRepository.findById(supplyDTO.getSupplierId()).isEmpty()) {
            throw new ResourceNotFoundException(Supplier.class, "id", supplyDTO.getSupplierId().toString());
        }

        //change the quantity of the item in the items table
        Item oldItem = itemsRepository.findById(supply.getItem().getItemId()).orElse(null);
        assert oldItem != null;
        oldItem.setQuantity(oldItem.getQuantity() - supply.getQuantity());
        itemsRepository.save(oldItem);

        supply.setItem(itemsRepository.findById(supplyDTO.getItemId()).get());
        supply.setQuantity(supplyDTO.getQuantity());
        supply.setPpu(BigDecimal.valueOf(supplyDTO.getPpu()));
        //date should not be updated
        suppliesRepository.save(supply);

        //change the quantity of the item in the items table
        Item item = itemsRepository.findById(supplyDTO.getItemId()).get();
        item.setQuantity(item.getQuantity() + supplyDTO.getQuantity());
        itemsRepository.save(item);


        SupplyDTO updatedSupplyDTO = SupplyDTO.builder()
                .id(supply.getSupplyID())
                .itemId(supply.getItem().getItemId())
                .supplierId(supply.getSupplier().getSupplierId())
                .quantity(supply.getQuantity())
                .ppu(supply.getPpu().doubleValue())
                .date(supply.getDate())
                .build();

        return APIResponse.ok(updatedSupplyDTO, "Supply updated successfully");
    }

    @Override
    @Transactional
    public APIResponse<SupplyDTO> deleteSupply(Long id) {

        Supply supply = suppliesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Supply.class, "id", id.toString()));

        //change the quantity of the item in the items table
        Item item = itemsRepository.findById(supply.getItem().getItemId()).orElse(null);
        assert item != null;
        item.setQuantity(item.getQuantity() - supply.getQuantity());
        itemsRepository.save(item);

        suppliesRepository.delete(supply);

        return APIResponse.deleted(null, "Supply deleted successfully");
    }


    @Override
    @Transactional
    public APIResponse<SupplyDTO> partialUpdateSupply(Long id, SupplyDTO supplyDTO) {

        Supply supply = suppliesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Supply.class, "id", id.toString()));

        if (supplyDTO.getItemId() != null) {
            //check if the item exists

            Optional<Item> itemOptional = itemsRepository.findById(supplyDTO.getItemId());
            if (itemOptional.isEmpty()) {
                throw new ResourceNotFoundException(Item.class, "id", supplyDTO.getItemId().toString());
            }

            //change the quantity of the item in the items table
            Item item = itemsRepository.findById(supply.getItem().getItemId()).orElse(null);
            assert item != null;
            item.setQuantity(item.getQuantity() - supply.getQuantity());
            itemsRepository.save(item);

            supply.setItem(itemOptional.get());

            //change the quantity of the item in the items table
            item = itemsRepository.findById(supplyDTO.getItemId()).orElse(null);
            assert item != null;
            item.setQuantity(item.getQuantity() + supply.getQuantity());
            itemsRepository.save(item);
        }

        if (supplyDTO.getQuantity() != null) {
            //change the quantity of the item in the items table
            Item item = itemsRepository.findById(supply.getItem().getItemId()).orElse(null);
            assert item != null;
            item.setQuantity(item.getQuantity() - supply.getQuantity() + supplyDTO.getQuantity());
            itemsRepository.save(item);
            supply.setQuantity(supplyDTO.getQuantity());
        }

        if (supplyDTO.getPpu() != null) {
            supply.setPpu(BigDecimal.valueOf(supplyDTO.getPpu()));
        }

        if (supplyDTO.getSupplierId() != null) {
            //check if supplier exists
            Optional<Supplier> supplierOptional = suppliersRepository.findById(supplyDTO.getSupplierId());
            if (supplierOptional.isEmpty()) {
                throw new ResourceNotFoundException(Supplier.class, "id", supplyDTO.getSupplierId().toString());
            }
            supply.setSupplier(supplierOptional.get());
        }

        suppliesRepository.save(supply);

        SupplyDTO updatedSupplyDTO = SupplyDTO.builder()
                .id(supply.getSupplyID())
                .itemId(supply.getItem().getItemId())
                .quantity(supply.getQuantity())
                .ppu(supply.getPpu().doubleValue())
                .supplierId(supply.getSupplier().getSupplierId())
                .date(supply.getDate())
                .build();

        return APIResponse.ok(updatedSupplyDTO, "Supply updated successfully");
    }




}
