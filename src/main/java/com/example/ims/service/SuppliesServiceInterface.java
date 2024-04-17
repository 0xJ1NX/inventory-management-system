package com.example.ims.service;

import com.example.ims.dto.SupplyDTO;
import com.example.ims.dto.response.APIResponse;

import java.util.List;

public interface SuppliesServiceInterface {

    APIResponse<List<SupplyDTO>> getAllSupplies();

    APIResponse<SupplyDTO> createSupply(SupplyDTO supplyDTO);

    APIResponse<SupplyDTO> getSupplyById(Long id);

    APIResponse<SupplyDTO> updateSupply(Long id, SupplyDTO supplyDTO);

    APIResponse<SupplyDTO> deleteSupply(Long id);

    APIResponse<SupplyDTO> partialUpdateSupply(Long id, SupplyDTO supplyDTO);


}
