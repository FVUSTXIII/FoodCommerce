package com.project.food.commerce.service;

import com.project.food.commerce.dto.ProductRequestDTO;
import com.project.food.commerce.dto.ProductResponseDTO;

public interface ProductService {

	void saveProductDetails(ProductRequestDTO productRequestDto);
	ProductResponseDTO getAllProductsInStore(Integer storeId);
	
}
