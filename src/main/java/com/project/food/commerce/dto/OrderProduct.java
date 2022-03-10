package com.project.food.commerce.dto;

public class OrderProduct {
	private Integer productId;
	private Integer productPrice;
	private Integer quantity;
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}
}
