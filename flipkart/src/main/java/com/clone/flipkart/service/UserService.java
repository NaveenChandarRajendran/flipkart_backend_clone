package com.clone.flipkart.service;

import java.util.List;

import com.clone.flipkart.dto.UserDto.UserRequestDto;
import com.clone.flipkart.dto.UserDto.UserResponseDto;
import com.clone.flipkart.dto.UserDto.UserUpdate;
import com.clone.flipkart.entity.User;

public interface UserService {
	UserResponseDto createUser(UserRequestDto user);
	UserResponseDto  getUserById(Long id);
	UserResponseDto updateUser(Long id,UserUpdate user);
	List<User> getAllUsers();
	void deleteUser(Long id);
	
}
