package com.project.food.commerce.dto;

import java.time.LocalTime;

public class StoreDetails {
	private Integer storeId;
    private String storeName;
    private String storeDescription;
    private Double storeRating;
    //private LocalTime openTill;
    
    
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
	public String getStoreDescription() {
		return storeDescription;
	}
	public void setStoreDescription(String storeDescription) {
		this.storeDescription = storeDescription;
	}

	public Double getStoreRating() {
		return storeRating;
	}

	public void setStoreRating(Double storeRating) {
		this.storeRating = storeRating;
	}
	
}
