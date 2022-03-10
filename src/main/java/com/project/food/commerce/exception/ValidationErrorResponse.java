package com.project.food.commerce.exception;

import java.util.HashMap;
import java.util.Map;

public class ValidationErrorResponse extends ErrorResponse{

	Map<String, String> invalidArguments = new HashMap<String, String>();
	
	
	public Map<String, String> getInvalidArguments() {
		return invalidArguments;
	}



	public void setInvalidArguments(Map<String, String> invalidArguments) {
		this.invalidArguments = invalidArguments;
	}



	public ValidationErrorResponse(String message, String storeNotFound) {
		super(message, storeNotFound);
		// TODO Auto-generated constructor stub
	}

}
