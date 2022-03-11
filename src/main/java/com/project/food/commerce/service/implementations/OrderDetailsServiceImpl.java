package com.project.food.commerce.service.implementations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.food.commerce.dto.OrderDetailProduct;
import com.project.food.commerce.dto.OrderHistoryDetails;
import com.project.food.commerce.dto.OrderHistoryResponseDTO;
import com.project.food.commerce.dto.OrderRequestDTO;
import com.project.food.commerce.dto.OrderResponseDTO;
import com.project.food.commerce.dto.ProductDetails;
import com.project.food.commerce.dto.ProductResponseDTO;
import com.project.food.commerce.dto.ResponseDTO;
import com.project.food.commerce.entity.OrderDetail;
import com.project.food.commerce.entity.OrderProduct;
import com.project.food.commerce.entity.Product;
import com.project.food.commerce.entity.Status;
import com.project.food.commerce.exception.EmptyOrderHistoryException;
import com.project.food.commerce.exception.NoAvailableProductsException;
import com.project.food.commerce.exception.NoProductsWithinOrderException;
import com.project.food.commerce.repository.OrderDetailRepository;
import com.project.food.commerce.repository.ProductRepository;
import com.project.food.commerce.repository.StoreRepository;
import com.project.food.commerce.service.OrderDetailsService;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService{

	@Autowired
	OrderDetailRepository orderRepo;
	
	@Autowired
	StoreRepository storeRepo;
	
	@Autowired
	ProductRepository productRepo;
	
	
	
	
	@Override
	public OrderResponseDTO saveOrderDetails(OrderRequestDTO orderRequestDTO) {
		List<String> noAvailable = new ArrayList<String>();
		OrderDetail orderDetail = new OrderDetail();
		BeanUtils.copyProperties(orderRequestDTO, orderDetail);
		orderDetail.setTotalPrice(orderRequestDTO.getTotalPrice());
		orderRequestDTO
		.getProductList()
		.forEach(orderDetailProduct -> {
			OrderProduct orderProduct = new OrderProduct();
			Optional<Product> product = productRepo.findById(orderDetailProduct.getProductId());
            if (!product.get().getIsAvailable()) {
            	noAvailable.add(product.get().getProductName());
           		}
			BeanUtils.copyProperties(orderDetailProduct, orderProduct);
			orderDetail.addProduct(orderProduct);
			
		});
		if(!noAvailable.isEmpty()) {
			String concatenate = "";
			for(String s: noAvailable) {
				concatenate+=s+", ";
			}
			concatenate=concatenate.substring(0, concatenate.length()-2);
			throw new NoAvailableProductsException("These products are not available:  "+ concatenate);	
		}
		
		if (orderDetail.getOrderProduct().isEmpty()) {
			throw new NoProductsWithinOrderException("This order contains 0 products and cannot be completed.");
		}
		
		orderDetail.setStatus(Status.ACCEPTED);
		orderDetail.setOrderDate(LocalDate.now());
		orderRepo.save(orderDetail);
		OrderResponseDTO response = new OrderResponseDTO();
		ResponseDTO responseDTO = new ResponseDTO("Order Placed Successfully", 200);
		response.setOrderNumber(orderDetail.getOrderDetailId().toString());
		response.setResponseDTO(responseDTO);
		return response;
	}

	@Override
	public OrderHistoryResponseDTO getAllOrderHistory(Integer userId) {
		List<OrderDetail> orderHistoryList = orderRepo.findByUserId(userId);
		if(!orderHistoryList.isEmpty())
			{
			throw new EmptyOrderHistoryException("The order history is empty");
			}
		List<OrderHistoryDetails> orderHistoryDetailsList = orderHistoryList.stream()
				.map(historyDetail -> {
					    OrderHistoryDetails orderHistoryDetail = new OrderHistoryDetails();
						BeanUtils.copyProperties(historyDetail, orderHistoryDetail);
						historyDetail.getOrderProduct().forEach(orderProduct ->{
							OrderDetailProduct orderDetailProduct = new  OrderDetailProduct();
							BeanUtils.copyProperties(orderProduct, orderDetailProduct);
							orderHistoryDetail.addDetailProduct(orderDetailProduct);
						});
						orderHistoryDetail.setStoreName(storeRepo.findById(orderHistoryDetail.getStoreId()).get().getStoreName());
						return orderHistoryDetail;
					}).collect(Collectors.toList());
		ResponseDTO responseDTO = new ResponseDTO("Products Details for a Store Fetch Success", 200);
		OrderHistoryResponseDTO orderHistoryResponseDto = new OrderHistoryResponseDTO();
		orderHistoryResponseDto.setHistoryList(orderHistoryDetailsList);
		orderHistoryResponseDto.setResponseDTO(responseDTO);
		return orderHistoryResponseDto;
	}

}
