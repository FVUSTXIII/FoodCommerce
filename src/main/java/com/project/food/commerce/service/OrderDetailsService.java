package com.project.food.commerce.service;

import com.project.food.commerce.dto.OrderHistoryResponseDTO;
import com.project.food.commerce.dto.OrderRequestDTO;
import com.project.food.commerce.dto.OrderResponseDTO;
import com.project.food.commerce.dto.ProductResponseDTO;

public interface OrderDetailsService {

	OrderResponseDTO saveOrderDetails(OrderRequestDTO orderRequestDTO);
	OrderHistoryResponseDTO getAllOrderHistory(Integer pageNo, Integer pageSize,Integer userId);
	
	
}
