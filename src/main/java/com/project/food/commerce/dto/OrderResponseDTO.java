package com.project.food.commerce.dto;
import java.util.*;
public class OrderResponseDTO {
	private ResponseDTO responseDTO;
	private static Random random = new Random();
	private String OrderNumber;
	public ResponseDTO getResponseDTO() {
		return responseDTO;
	}
	public void setResponseDTO(ResponseDTO responseDTO) {
		this.responseDTO = responseDTO;
	}
	public String getOrderNumber() {
		int targetStringLength = random.nextInt(15);
		return random.ints(97, 122)
                .limit(targetStringLength+1)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString() + this.OrderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		OrderNumber = orderNumber;
	}
	
}
