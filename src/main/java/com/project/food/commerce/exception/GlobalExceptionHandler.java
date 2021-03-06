package com.project.food.commerce.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.food.commerce.constants.ApiConstants;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(StoreNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(StoreNotFoundException ex)
	{
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), ApiConstants.STORE_NOT_FOUND);
		errorResponse.setDateTime(LocalDateTime.now());
		return new ResponseEntity <ErrorResponse>(errorResponse, HttpStatus.OK);
	}
	
	@ExceptionHandler(InconsistentPricesException.class)
	public ResponseEntity<ErrorResponse> handleException(InconsistentPricesException ex) {
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), ApiConstants.INCONSISTENT_PRICES_IN_ORDER);
		errorResponse.setDateTime(LocalDateTime.now());
		return new ResponseEntity <ErrorResponse>(errorResponse, HttpStatus.OK);
	}
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(UserNotFoundException ex)
	{
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), ApiConstants.USER_NOT_FOUND);
		errorResponse.setDateTime(LocalDateTime.now());
		return new ResponseEntity <ErrorResponse>(errorResponse, HttpStatus.OK);
	}
	
	@ExceptionHandler(ProductListEmptyException.class)
	public ResponseEntity<ErrorResponse> handleException(ProductListEmptyException ex)
	{
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), ApiConstants.EMPTY_PRODUCT_LIST_BY_STORE);
		errorResponse.setDateTime(LocalDateTime.now());
		return new ResponseEntity <ErrorResponse>(errorResponse, HttpStatus.OK);
	}
	
	@ExceptionHandler(NoAvailableProductsException.class)
	public ResponseEntity<ErrorResponse> handleException(NoAvailableProductsException ex)
	{
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), ApiConstants.NO_AVAILABLE_PRODUCT);
		errorResponse.setDateTime(LocalDateTime.now());
		return new ResponseEntity <ErrorResponse>(errorResponse, HttpStatus.OK);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity <ValidationErrorResponse> handleException(MethodArgumentNotValidException ex)
	{
		ValidationErrorResponse errorResponse = new ValidationErrorResponse("Invalid Arguments Passed", ApiConstants.INVALID_ARGS);
		ex.getBindingResult().getFieldErrors().stream().forEach(error -> {
			errorResponse.getInvalidArguments().put(error.getField(),error.getDefaultMessage());
		});
		
		errorResponse.setDateTime(LocalDateTime.now());
		return new ResponseEntity<ValidationErrorResponse>(errorResponse, HttpStatus.OK);
	}
	@ExceptionHandler(NoProductsWithinOrderException.class)
	public ResponseEntity<ErrorResponse> handleException(NoProductsWithinOrderException ex) {
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), ApiConstants.ORDER_LIST_EMPTY);
		errorResponse.setDateTime(LocalDateTime.now());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.OK);
	}
	
	@ExceptionHandler(EmptyOrderHistoryException.class)
	public ResponseEntity<ErrorResponse> handleException(EmptyOrderHistoryException ex){
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), ApiConstants.EMPTY_ORDER_HISTORY);
		errorResponse.setDateTime(LocalDateTime.now());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.OK);
	}
	
}
