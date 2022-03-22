package com.project.food.commerce.dto;

import org.springframework.beans.factory.annotation.Value;

public interface StoreOpenInterface {
	
	@Value("#{target.storeName + ' ' + target.storeRating}")
	public String getNameAndRating();

}
