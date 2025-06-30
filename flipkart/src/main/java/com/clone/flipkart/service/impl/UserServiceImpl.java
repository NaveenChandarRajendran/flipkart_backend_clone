package com.clone.flipkart.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.clone.flipkart.dto.UserDto.UserRequestDto;
import com.clone.flipkart.dto.UserDto.UserResponseDto;
import com.clone.flipkart.dto.UserDto.UserUpdate;
import com.clone.flipkart.entity.User;
import com.clone.flipkart.repository.UserRepository;
import com.clone.flipkart.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	 public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
	        this.userRepository = userRepository;
	        this.passwordEncoder = passwordEncoder;
	 }
	 
	 @Override
	 public UserResponseDto createUser(UserRequestDto userRequest) {
		 User user = new User();
		 user.setEmail(userRequest.getEmail());
		 user.setName(userRequest.getName());
		 user.setPhone(userRequest.getPhone());
		 user.setUser_type(userRequest.getUser_type());
		 user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
		 
		 User savedUser = userRepository.save(user);
		 return new UserResponseDto(savedUser.getId(), savedUser.getName(), savedUser.getEmail(), savedUser.getPhone(), savedUser.getUser_type());
	 }
	 
	 @Override
	 public UserResponseDto getUserById(Long id) {
		 User user =  this.userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
		 return new UserResponseDto(user.getId(), user.getName(), user.getEmail(), user.getPhone(), user.getUser_type());
	 }
	 
	 @Override
	 public List<User> getAllUsers(){
		 return this.userRepository.findAll();
	 }
	 
	 public UserResponseDto updateUser(Long id, UserUpdate user) {
		    Optional<User> optionalUser = userRepository.findById(id);

		    if (optionalUser.isPresent()) {
		        User existingUser = optionalUser.get();
		        
		        existingUser.setEmail(user.getEmail());
		        existingUser.setName(user.getName());
		        existingUser.setPhone(user.getPhone());
		        existingUser.setUser_type(user.getUser_type());

		        User savedUser = userRepository.save(existingUser);

		        return new UserResponseDto(
		            savedUser.getId(),
		            savedUser.getName(),
		            savedUser.getEmail(),
		            savedUser.getPhone(),
		            savedUser.getUser_type()
		        );
		    } else {
		        return null;
		    }
		}
	 
	 @Override
	 public void deleteUser(Long id) {
		 this.userRepository.deleteById(id);
	 }
	
}
