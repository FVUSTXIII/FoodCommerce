package com.project.food.commerce.exception;

public class NoAvailableProductsException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public NoAvailableProductsException(String message) {
		super(message);
	}


}
