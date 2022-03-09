package com.project.food.commerce.service.implementations;

import java.util.Optional;

import com.project.food.commerce.entity.Store;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.food.commerce.dto.ProductRequestDTO;
import com.project.food.commerce.entity.Product;
import com.project.food.commerce.entity.ProductCategory;
import com.project.food.commerce.repository.ProductRepository;
import com.project.food.commerce.repository.StoreRepository;
import com.project.food.commerce.service.ProductService;



@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	StoreRepository storeRepo;
	
	@Autowired
	ProductRepository productRepo; 
	
	@Override
	public void saveProductDetails(ProductRequestDTO productRequestDto) {
		Product product = new Product();
		BeanUtils.copyProperties(productRequestDto, product);
		product.setProductCategory(ProductCategory.valueOf(productRequestDto.getProductCategory()));
		Optional<Store> storeOptional =  storeRepo.findById(productRequestDto.getStoreId());
		if (storeOptional.isPresent()) {
			product.setStore(storeOptional.get());
		}
		productRepo.save(product);
	}
	
}
