package com.clone.flipkart.service;

import java.util.List;

import com.clone.flipkart.entity.Seller;

public interface SellerService {
	List<Seller> getAllSellers();
	Seller getSellerById(Long id);
	Seller createSeller(Long userId, Seller seller);
	Seller updateSeller(Seller SellerUpdate);
	void deleteSeller(Long id);
}
