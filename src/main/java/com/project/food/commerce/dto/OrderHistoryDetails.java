package com.project.food.commerce.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderHistoryDetails {

	 private Integer userId;
	 private Integer storeId;
	 private String storeName;
	 private Double totalPrice;
	 private List<OrderDetailProduct> productList = new ArrayList<OrderDetailProduct>(); 
	 private LocalDate orderDate;
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
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public Double getTotalPrice() {
		return totalPrice;
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
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	
	public void addDetailProduct(OrderDetailProduct orderDetailProduct) {
		this.productList.add(orderDetailProduct);
	}
	 
	 
}
