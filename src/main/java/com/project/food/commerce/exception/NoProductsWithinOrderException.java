package com.project.food.commerce.exception;

public class NoProductsWithinOrderException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public NoProductsWithinOrderException(String message) {
		super(message);
	}
	
}
