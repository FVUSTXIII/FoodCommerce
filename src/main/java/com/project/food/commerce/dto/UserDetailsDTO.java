package com.project.food.commerce.dto;

public class UserDetailsDTO {
	private String userName;
	private String eMail;
	private String phoneNo;
	private ResponseDTO responseDTO;
		
	public UserDetailsDTO(String userName, String eMail, String phoneNo) {
		
		this.userName = userName;
		this.eMail = eMail;
		this.phoneNo = phoneNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public ResponseDTO getResponseDTO() {
		return responseDTO;
	}
	public void setResponseDTO(ResponseDTO responseDTO) {
		this.responseDTO = responseDTO;
	}
		
}
