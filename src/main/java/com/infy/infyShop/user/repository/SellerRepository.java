package com.infy.infyShop.user.repository;

import org.springframework.data.repository.CrudRepository;

import com.infy.infyShop.user.entity.Seller;

public interface SellerRepository extends CrudRepository<Seller,Integer>{

	Seller findByEmail(String email);

}