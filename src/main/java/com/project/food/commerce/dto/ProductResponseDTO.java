package com.project.food.commerce.dto;

import java.util.ArrayList;
import java.util.List;

public class ProductResponseDTO {

	private List<ProductDetails> productList = new ArrayList<>();
	private ResponseDTO responseDTO;
	public List<ProductDetails> getProductList() {
		return productList;
	}
	public void setProductList(List<ProductDetails> productList) {
		this.productList = productList;
	}
	public ResponseDTO getResponseDTO() {
		return responseDTO;
	}
	public void setResponseDTO(ResponseDTO responseDTO) {
		this.responseDTO = responseDTO;
	}

}
