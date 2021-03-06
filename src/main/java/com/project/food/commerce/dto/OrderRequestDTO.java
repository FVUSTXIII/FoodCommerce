package com.project.food.commerce.dto;

import java.util.List;

import javax.validation.constraints.Size;

public class OrderRequestDTO {
	
	 private Integer userId;
	 private Integer storeId;
	 private Double totalPrice;
	 @Size(min = 1, message = "The product list should at least contain 1 product")
	 private List<OrderDetailProduct> productList; 
	 
	 public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getStoreId() {
		return storeId;
	}
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	public Double getTotalPrice() {
		return productList
				.stream()
				.mapToDouble(total -> (total.getProductPrice() * total.getProductQuantity()))
				.sum();
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public List<OrderDetailProduct> getProductList() {
		return productList;
	}
	public void setProductList(List<OrderDetailProduct> productList) {
		this.productList = productList;
	}
	
	
	
}
