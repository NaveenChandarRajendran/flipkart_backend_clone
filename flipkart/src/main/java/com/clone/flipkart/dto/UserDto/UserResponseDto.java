package com.clone.flipkart.dto.UserDto;

import flipkart_enum.UserType;

public class UserResponseDto {
	private Long id;
	private String name;
	private String email;
	private String phone;
	private UserType user_type;
	
	public UserResponseDto(Long id, String name, String email, String phone, UserType user_type) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.user_type = user_type;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public UserType getUser_type() {
		return user_type;
	}
	
	
}
