package com.clone.flipkart.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import flipkart_enum.UserType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;
	
 
	private String name;
	private String email;
	private String phone;
	private String password;
	
	@Enumerated(EnumType.STRING)
	private UserType user_type;
	
	@CreationTimestamp
	@Column(name = "created_at", updatable = false)
	private LocalDateTime createdAt;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public LocalDateTime getCreate_at() {
		return createdAt;
	}

	public void setCreate_at(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
}
