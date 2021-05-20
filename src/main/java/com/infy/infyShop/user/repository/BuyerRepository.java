package com.infy.infyShop.user.repository;

import org.springframework.data.repository.CrudRepository;

import com.infy.infyShop.user.entity.Buyer;

public interface BuyerRepository extends CrudRepository<Buyer,Integer>{

	Buyer findByEmail(String email);
	
}
