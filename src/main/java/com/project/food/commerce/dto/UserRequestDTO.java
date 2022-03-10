package com.project.food.commerce.dto;

import javax.validation.constraints.NotEmpty;

public class UserRequestDTO {

	@NotEmpty(message = "User name should not be empty")
	private String userName;
	@NotEmpty(message = "User password should not be empty")
	private String password;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
