package com.project.food.commerce.dto;

import java.util.ArrayList;
import java.util.List;

public class OrderHistoryResponseDTO {
	
	private List<OrderHistoryDetails> historyList = new ArrayList<>();
	private ResponseDTO responseDTO;
	public List<OrderHistoryDetails> getHistoryList() {
		return historyList;
	}
	public void setHistoryList(List<OrderHistoryDetails> historyList) {
		this.historyList = historyList;
	}
	public ResponseDTO getResponseDTO() {
		return responseDTO;
	}
	public void setResponseDTO(ResponseDTO responseDTO) {
		this.responseDTO = responseDTO;
	}

	
	

}
