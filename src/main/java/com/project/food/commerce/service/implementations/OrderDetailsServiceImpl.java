package com.project.food.commerce.service.implementations;

import java.time.LocalDate;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.food.commerce.dto.OrderRequestDTO;
import com.project.food.commerce.dto.OrderResponseDTO;
import com.project.food.commerce.dto.ProductResponseDTO;
import com.project.food.commerce.dto.ResponseDTO;
import com.project.food.commerce.entity.OrderDetail;
import com.project.food.commerce.entity.OrderProduct;
import com.project.food.commerce.entity.Status;
import com.project.food.commerce.repository.OrderDetailRepository;
import com.project.food.commerce.service.OrderDetailsService;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService{

	@Autowired
	OrderDetailRepository orderRepo;
	
	@Override
	public OrderResponseDTO saveOrderDetails(OrderRequestDTO orderRequestDTO) {
		// TODO Auto-generated method stub
		OrderDetail orderDetail = new OrderDetail();
		BeanUtils.copyProperties(orderRequestDTO, orderDetail);
		orderDetail.setTotalPrice(orderRequestDTO.getTotalPrice());
		orderRequestDTO
		.getProductList()
		.forEach(orderDetailProduct -> {
			OrderProduct orderProduct = new OrderProduct();
			BeanUtils.copyProperties(orderDetailProduct, orderProduct);
			orderDetail.addProduct(orderProduct);
		});
		orderDetail.setStatus(Status.ACCEPTED);
		orderDetail.setOrderDate(LocalDate.now());
		orderRepo.save(orderDetail);
		OrderResponseDTO response = new OrderResponseDTO();
		ResponseDTO responseDTO = new ResponseDTO("Order Placed Successfully", 200);
		response.setOrderNumber(orderDetail.getOrderDetailId().toString());
		response.setResponseDTO(responseDTO);
		return response;
	}

}
