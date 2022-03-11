package com.project.food.commerce.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.food.commerce.dto.ProductRequestDTO;
import com.project.food.commerce.dto.ProductResponseDTO;
import com.project.food.commerce.dto.ResponseDTO;
import com.project.food.commerce.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	ProductService productService;
		
	@PostMapping("/products")
	public ResponseEntity<ResponseDTO> saveProductDetails(@Valid @RequestBody ProductRequestDTO productRequestDto) {
		productService.saveProductDetails(productRequestDto);
		return new ResponseEntity<ResponseDTO>(new ResponseDTO("Product Save Success", 200), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/stores/{storeId}/products")
	public ResponseEntity<ProductResponseDTO> getAllProductsInStore(
			@RequestParam(defaultValue = "0")Integer pageNo,
			@RequestParam(defaultValue = "5")Integer pageSize,
			@PathVariable("storeId") Integer storeId){
		ProductResponseDTO productResponseDto =  productService.getAllProductsInStore(pageNo, pageSize, storeId);
		return new ResponseEntity<ProductResponseDTO>(productResponseDto, HttpStatus.OK);
	}
	
}
