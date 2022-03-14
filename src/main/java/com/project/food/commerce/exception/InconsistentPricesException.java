package com.project.food.commerce.exception;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.project.food.commerce.dto.MessageBuilder;

public class InconsistentPricesException extends RuntimeException {
	public InconsistentPricesException (String message) {
		super(message);
	}
	@Override
	
	
	public String getMessage() {
		// TODO Auto-generated method stub222222
		String message = "";
		String separador = Pattern.quote("|");
		List<String> mess = Arrays.asList(super.getMessage().split(separador));
		
		for (int i = 0; i < mess.size(); i++) {
			if (i == 0) {
				message += "[\n\t";
			}
			String[] properties = mess.get(i).split(",");
			String[] property_names = {"Product Name", "Listed Product Price", "Actual Product Price"};
			MessageBuilder messageBuilder = new MessageBuilder(Arrays.asList(property_names), Arrays.asList(properties));
			message += messageBuilder.toString();
			if (i == mess.size()-1) {
				message += "\n]";
			}
		}
		return message;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
