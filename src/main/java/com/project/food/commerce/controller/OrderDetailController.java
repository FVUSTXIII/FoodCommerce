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

import com.project.food.commerce.dto.OrderHistoryResponseDTO;
import com.project.food.commerce.dto.OrderRequestDTO;
import com.project.food.commerce.dto.OrderResponseDTO;
import com.project.food.commerce.dto.ProductResponseDTO;
import com.project.food.commerce.dto.ResponseDTO;
import com.project.food.commerce.service.OrderDetailsService;

@RestController
public class OrderDetailController {
	
	@Autowired
	OrderDetailsService orderDetailsService;
	
	@PostMapping("/orderdetails")
	public ResponseEntity<OrderResponseDTO> completeOrder(@Valid @RequestBody OrderRequestDTO orderRequestDTO) {
		return new ResponseEntity<OrderResponseDTO> (orderDetailsService.saveOrderDetails(orderRequestDTO), HttpStatus.OK);
	}
	
	@GetMapping("/users/{userId}/orderdetails")
	public ResponseEntity<OrderHistoryResponseDTO> getAllOrderHistory(
			@RequestParam(defaultValue = "0")Integer pageNo,
			@RequestParam(defaultValue = "5")Integer pageSize, 
			@PathVariable("userId") Integer userId){
		OrderHistoryResponseDTO orderHistoryResponseDto =  orderDetailsService.getAllOrderHistory(pageNo, pageSize, userId);
		return new ResponseEntity<OrderHistoryResponseDTO>(orderHistoryResponseDto, HttpStatus.OK);
	}
}

