package com.project.food.commerce.service;

import java.util.List;

import com.project.food.commerce.dto.ProductClosedInterface;
import com.project.food.commerce.dto.ProductRequestDTO;
import com.project.food.commerce.dto.ProductResponseDTO;
import com.project.food.commerce.entity.Product;

public interface ProductService {

	Product saveProductDetails(ProductRequestDTO productRequestDto);
	ProductResponseDTO getAllProductsInStore(Integer pageNo, Integer pageSize, Integer storeId);
	ProductClosedInterface getSpecificProduct(Integer productId);
	
}
