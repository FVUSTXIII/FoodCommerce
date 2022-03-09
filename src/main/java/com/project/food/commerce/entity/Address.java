package com.project.food.commerce.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String nameSt;
	private String number;
	private String neighborhood;
	private String zipCode;
	public String getNameSt() {
		return nameSt;
	}
	public void setNameSt(String nameSt) {
		this.nameSt = nameSt;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getNeighborhood() {
		return neighborhood;
	}
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	@Override
	public String toString() {
		return "AddressUser [nameSt=" + nameSt + ", number=" + number + ", neighborhood=" + neighborhood + ", zipCode="
				+ zipCode + "]";
	}
	
	
}
