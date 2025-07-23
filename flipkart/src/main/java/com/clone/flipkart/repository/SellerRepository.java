package com.clone.flipkart.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.clone.flipkart.entity.Seller;
import com.clone.flipkart.entity.User;
public interface SellerRepository extends JpaRepository<Seller, Long> {

}
