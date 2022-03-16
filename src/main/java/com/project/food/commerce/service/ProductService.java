package com.project.food.commerce.service;

import com.project.food.commerce.dto.ProductRequestDTO;
import com.project.food.commerce.dto.ProductResponseDTO;
import com.project.food.commerce.entity.Product;

public interface ProductService {

	Product saveProductDetails(ProductRequestDTO productRequestDto);
	ProductResponseDTO getAllProductsInStore(Integer pageNo, Integer pageSize, Integer storeId);
	
}
