package com.project.food.commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.food.commerce.dto.OrderRequestDTO;
import com.project.food.commerce.dto.OrderResponseDTO;
import com.project.food.commerce.dto.ResponseDTO;
import com.project.food.commerce.service.OrderDetailsService;

@RestController
public class OrderDetailController {
	
	@Autowired
	OrderDetailsService orderDetailsService;
	
	@PostMapping("/orderdetails")
	public ResponseEntity<OrderResponseDTO> completeOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
		return new ResponseEntity<OrderResponseDTO> (orderDetailsService.saveOrderDetails(orderRequestDTO), HttpStatus.OK);
	}
}

