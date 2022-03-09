package com.project.food.commerce.dto;

import java.util.ArrayList;
import java.util.List;

public class StoreResponseDTO {
	private List<StoreDetails> storeList = new ArrayList<>();
	private ResponseDTO responseDTO;
	public List<StoreDetails> getStoreList() {
		return storeList;
	}
	public void setStoreList(List<StoreDetails> storeList) {
		this.storeList = storeList;
	}
	public ResponseDTO getResponseDTO() {
		return responseDTO;
	}
	public void setResponseDTO(ResponseDTO responseDTO) {
		this.responseDTO = responseDTO;
	}
	
	
}
