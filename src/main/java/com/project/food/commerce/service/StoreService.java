package com.project.food.commerce.service;
import com.project.food.commerce.dto.StoreOpenInterface;
import com.project.food.commerce.dto.StoreResponseDTO;

public interface StoreService {

	StoreResponseDTO getAllStoreDetails(Integer pageNo, Integer pageSize);
	StoreOpenInterface getSpecificStore(Integer storeId); 
	

}
