package com.project.food.commerce.dto;

import java.util.List;



import springfox.documentation.spring.web.json.Json;

public class MessageBuilder {
	private List<String> property_names;
	private List<Object> properties;
	
	public MessageBuilder(List<String> property_names, List<Object> properties) {
		this.properties = properties;
		this.property_names = property_names;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String JsonResponse = "";
		for(int i = 0; i < property_names.size(); i++) {
			if (i == 0) {
				JsonResponse += "{\n\t"; 
			}
			JsonResponse += property_names.get(i) + ": " + properties.get(i).toString() + ",\n";
			if (i == property_names.size()-1) {
				JsonResponse = JsonResponse.substring(0, JsonResponse.length()-3);
				JsonResponse += "}";
			}
		}
		
		return JsonResponse;
	}
}
