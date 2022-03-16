package com.project.food.commerce.service.implementations;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.project.food.commerce.entity.Store;
import com.project.food.commerce.exception.ProductListEmptyException;
import com.project.food.commerce.exception.StoreNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.food.commerce.dto.ProductDetails;
import com.project.food.commerce.dto.ProductRequestDTO;
import com.project.food.commerce.dto.ProductResponseDTO;
import com.project.food.commerce.dto.ResponseDTO;
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
	public Product saveProductDetails(ProductRequestDTO productRequestDto) {
		Product product = new Product();
		BeanUtils.copyProperties(productRequestDto, product);
		product.setProductCategory(ProductCategory.valueOf(productRequestDto.getProductCategory()));
		Optional<Store> storeOptional =  storeRepo.findById(productRequestDto.getStoreId());
		if (!storeOptional.isPresent()) {
			throw new StoreNotFoundException("Store Not Found: "+ productRequestDto.getStoreId());
		}
			
		product.setStore(storeOptional.get());
		return productRepo.save(product);
	}
	
	
	@Override
	public ProductResponseDTO getAllProductsInStore(Integer pageNo, Integer pageSize, Integer storeId) {
		
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<Product> productPage = productRepo.findByStoreStoreId(storeId,paging);
		List<Product> productsList = productPage.getContent();
		
		Optional<Store> _store = storeRepo.findById(storeId); 
		if (!_store.isPresent()) {
			throw new StoreNotFoundException("Store Not Found: " + storeId);
		}
		if (productsList.isEmpty()) {
			throw new ProductListEmptyException("There are no products for this store id: "+ storeId);
		}
		List<ProductDetails> productDetailsList = productsList.stream()
				.map(product -> {
						ProductDetails productDetail = new ProductDetails();
						BeanUtils.copyProperties(product, productDetail);
						return productDetail;
					}).collect(Collectors.toList());
		ResponseDTO responseDTO = new ResponseDTO("Products Details for a Store Fetch Success", 200);
		ProductResponseDTO productResponseDto = new ProductResponseDTO();
		productResponseDto.setProductList(productDetailsList);
		productResponseDto.setResponseDTO(responseDTO);
	
		
		return productResponseDto;
	}
	
}
