package com.clone.flipkart.dto.UserDto;

import flipkart_enum.UserType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserRequestDto {
	@NotBlank(message = "Name is required")
	private String name;
	
	@NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
	private String email;
	
	@NotBlank(message = "Password is required")
	@Size(min = 6, message = "Password must be at least 6 characters")
	private String password;
	
	@NotBlank(message = "Phone number is required")
	@Pattern(regexp = "\\d{10}", message = "Phone number must be exactly 10 digits")
	private String phone;
	
	@NotNull(message = "User type is required")
	private UserType user_type;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getUser_type() {
		return user_type;
	}

	public void setUser_type(UserType user_type) {
		this.user_type = user_type;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}
