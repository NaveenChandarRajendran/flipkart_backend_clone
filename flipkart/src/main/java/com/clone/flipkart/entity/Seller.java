package com.clone.flipkart.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sellers")
public class Seller {
	@Id
	private Long sellerId;
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "seller_id")
	private User user;
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name="gst_number")
	private String gstNumber;
	
	private Double rating;

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getGstNumber() {
		return gstNumber;
	}

	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}
	
	
	
	
}
