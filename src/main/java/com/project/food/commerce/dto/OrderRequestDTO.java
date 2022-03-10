package com.project.food.commerce.dto;

import java.util.List;

public class OrderRequestDTO {
	
	 private Integer userId;
	 private List<OrderProduct> productList; 
	 private Integer storeId;
	 private Double totalPrice;
	 
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
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public List<OrderProduct> getProductList() {
		return productList;
	}
	public void setProductList(List<OrderProduct> productList) {
		this.productList = productList;
	}
	
}
