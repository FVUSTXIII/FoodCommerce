package com.project.food.commerce.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.food.commerce.dto.StoreResponseDTO;
import com.project.food.commerce.service.StoreService;

@RestController
public class StoreController {

	@Autowired
	StoreService storeService;
	
	@GetMapping("/stores")
	public ResponseEntity<StoreResponseDTO> getAllStoreDetails(
			@RequestParam(defaultValue = "0")Integer pageNo,
			@RequestParam(defaultValue = "5")Integer pageSize) {
		StoreResponseDTO storeResponseDto =  storeService.getAllStoreDetails(pageNo, pageSize);
		return new ResponseEntity<StoreResponseDTO>(storeResponseDto, HttpStatus.OK);
	}
}
