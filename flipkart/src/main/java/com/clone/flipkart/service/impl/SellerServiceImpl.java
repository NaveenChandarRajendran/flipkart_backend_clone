package com.clone.flipkart.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.clone.flipkart.dto.UserDto.UserResponseDto;
import com.clone.flipkart.dto.UserDto.UserUpdate;
import com.clone.flipkart.entity.Seller;
import com.clone.flipkart.entity.User;
import com.clone.flipkart.repository.SellerRepository;
import com.clone.flipkart.repository.UserRepository;
import com.clone.flipkart.service.SellerService;

@Service
public class SellerServiceImpl  implements SellerService{
	private final SellerRepository sellerRepository;
	private final UserRepository userRepository;
	public SellerServiceImpl(SellerRepository sellerRepository, UserRepository userRepository) {
		this.sellerRepository = sellerRepository;
		this.userRepository = userRepository;
	}
	
	@Override
	public Seller createSeller(Long userId, Seller sellerReq) {
		User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found with id: " + userId));;
	
		Seller seller = new Seller();
		
		seller.setRating(sellerReq.getRating());
		seller.setCompanyName(sellerReq.getCompanyName());
		seller.setGstNumber(sellerReq.getGstNumber());
		seller.setUser(user);
		return sellerRepository.save(seller)
	}
	
	 @Override
	 public List<Seller> getAllSellers(){
		 return this.sellerRepository.findAll();
	 }
	 
	 @Override
	 public Seller getSellerById(Long id) {
		 Seller seller =  this.sellerRepository.findById(id).orElseThrow(() -> new RuntimeException("Seller not found with ID: " + id));
		 return seller;
	 }
	
	 
	 public Seller updateSeller(Long id, Seller seller) {
		    Optional<Seller> optionalSeller = sellerRepository.findById(id);

		    if (optionalSeller.isPresent()) {
		        Seller existingSeller = optionalSeller.get();

		        existingSeller.setCompanyName(seller.getCompanyName());
		        existingSeller.setGstNumber(seller.getGstNumber());
		        existingSeller.setRating(seller.getRating());

		        Seller savedSeller = sellerRepository.save(existingSeller);

		        return savedSeller;
		    } else {
		        return null;
		    }
		}
	 
	 @Override
	 public void deleteSeller(Long id) {
		 this.sellerRepository.deleteById(id);
	 }
	
	
	
	
	

}
