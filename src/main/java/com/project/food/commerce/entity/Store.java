package com.project.food.commerce.entity;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Column;

@Entity
public class Store {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer storeId;
	private String storeName;
	private Address address; 
	private Double storeRating;
	@OneToMany (mappedBy="store")
	@AttributeOverride( name = "storeId", column = @Column(name = "store_store_id"))
	private List<Product> product = new ArrayList<>();
	private LocalTime openTill;
	private String storeDescription;	
	
	
	public String getStoreDescription() {
		return storeDescription;
	}
	public void setStoreDescription(String storeDescription) {
		this.storeDescription = storeDescription;
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

	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Double getStoreRating() {
		return storeRating;
	}
	public void setStoreRating(Double storeRating) {
		this.storeRating = storeRating;
	}
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	public LocalTime getOpenTill() {
		return openTill;
	}
	public void setOpenTill(LocalTime openTill) {
		this.openTill = openTill;
	}
	
	

}
