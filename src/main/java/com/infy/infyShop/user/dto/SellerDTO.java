package com.infy.infyShop.user.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

public class SellerDTO {
	private Integer sellerId;
	@Pattern(regexp="[A-Za-z][\\sA-Za-z]*[A-Za-z]",message="Name should contain only alphabets and spaces, and shouldn't start or end with whitespaces")
	private String name;
	@Pattern(regexp="[A-Za-z0-9]+@[A-Za-z0-9]+[.][A-Za-z]+",message="Invalid E-mail address")
	private String email;
	@Min(value=6000000000L,message="Invalid Phone Number")
	@Max(value=9999999999L,message="Invalid Phone Number")
	private Long phoneNumber;
	@Pattern(regexp=".{7,20}",message="Password must be between 7 and 20 characters in length")
	@Pattern(regexp=".*[A-Z]+.*",message="Password must contain at least 1 uppercase character")
	@Pattern(regexp=".*[a-z]+.*",message="Password must contain at least 1 lowercase character")
	@Pattern(regexp=".*[-!@#$%^&*]+.*",message="Password must contain at least 1 special character")
	private String password;
	private Boolean isActive=false;
	
	public Integer getSellerId() {
		return sellerId;
	}
	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
}
