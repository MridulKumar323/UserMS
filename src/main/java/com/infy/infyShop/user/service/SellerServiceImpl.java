package com.infy.infyShop.user.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.infyShop.user.dto.SellerDTO;
import com.infy.infyShop.user.entity.Seller;
import com.infy.infyShop.user.repository.SellerRepository;

@Service
@Transactional
public class SellerServiceImpl implements SellerService{
	
	@Autowired 
	SellerRepository sellerRepository;
	
	public String userRegister(SellerDTO sellerDTO) {
		Seller seller = new Seller();
		seller.setName(sellerDTO.getName());
		seller.setEmail(sellerDTO.getEmail());
		seller.setPhoneNumber(sellerDTO.getPhoneNumber());
		seller.setPassword(sellerDTO.getPassword());
		seller.setIsActive(sellerDTO.getIsActive());
		sellerRepository.save(seller);
		return seller.getName();
	}
	
	public String userLogin(SellerDTO sellerDTO) {
		Seller seller=sellerRepository.findByEmail(sellerDTO.getEmail());
		if(seller==null) {
			return "Invalid Credentials";
		}
		if(sellerDTO.getPassword().equals(seller.getPassword())) {
			return "Login Succesful";
		}
		else return "Invalid Password";
	}
}
