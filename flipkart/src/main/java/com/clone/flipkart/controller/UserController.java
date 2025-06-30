package com.clone.flipkart.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clone.flipkart.dto.UserDto.UserRequestDto;
import com.clone.flipkart.dto.UserDto.UserResponseDto;
import com.clone.flipkart.dto.UserDto.UserUpdate;
import com.clone.flipkart.entity.User;
import com.clone.flipkart.service.UserService;
import com.clone.flipkart.util.ApiResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/users")
public class UserController {
	private UserService userService;
	
	public UserController(UserService userService) {
	    this.userService = userService;
	}
	
	@GetMapping
	public List<User> getAllUsers(){
		return this.userService.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserResponseDto> getUserById(@PathVariable Long id) {
		UserResponseDto userRespone =  this.userService.getUserById(id);
		return ResponseEntity.ok(userRespone);
	}     
	
	@PostMapping()
	public ResponseEntity<ApiResponse> createUser(@Valid @RequestBody  UserRequestDto userRequest) {
		UserResponseDto response = userService.createUser(userRequest);
		ApiResponse<UserResponseDto> apiResponse = new ApiResponse<>(
		        "User created successfully",
		        response,
		        HttpStatus.OK.value()
		    );
		return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
	}
	
	@PutMapping()
	public  ResponseEntity<ApiResponse>  updateUser(@Valid @RequestBody UserUpdate user) {
		UserResponseDto updatedUser = userService.updateUser(user.getId(), user);
		ApiResponse<UserResponseDto> apiResponse = new ApiResponse<>(
		        "User updated successfully",
		        updatedUser,
		        HttpStatus.OK.value()
		    );
		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}
	
	@DeleteMapping()
	public void deleteUser(@PathVariable Long id) {
		 userService.deleteUser(id);
	}
}
