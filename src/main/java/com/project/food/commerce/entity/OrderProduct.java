package com.project.food.commerce.entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Embeddable
public class OrderProduct {
	
	private Integer productId;  //Duda
	private Integer productQuantity;
	private Double productPrice;
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	@Override
	public String toString() {
		return "OrderProduct [productId=" + productId + ", productQuantity=" + productQuantity + ", productPrice="
				+ productPrice + "]";
	}
	
	

}
