package com.infy.infyShop.user.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.infyShop.user.dto.BuyerDTO;
import com.infy.infyShop.user.entity.Buyer;
import com.infy.infyShop.user.repository.BuyerRepository;

@Service
@Transactional
public class BuyerServiceImpl implements BuyerService{
	
	@Autowired
	BuyerRepository buyerRepository;
	
	public String userRegister(BuyerDTO buyerDTO) {
		Buyer buyer=new Buyer();
		buyer.setEmail(buyerDTO.getEmail());
		buyer.setName(buyerDTO.getName());
		buyer.setPhoneNumber(buyerDTO.getPhoneNumber());
		buyer.setPassword(buyerDTO.getPassword());
		buyer.setIsPrivileged(buyerDTO.getIsPrivileged());
		buyer.setIsActive(buyerDTO.getIsActive());
		buyer.setRewardPoints(buyerDTO.getRewardPoints());
		buyerRepository.save(buyer);
		return buyer.getName();
		}
	
	public String userLogin(BuyerDTO buyerDTO) {
		Buyer buyer=buyerRepository.findByEmail(buyerDTO.getEmail());
		if(buyer==null) {
			return "Invalid Credentials";
		}
		if(buyerDTO.getPassword().equals(buyer.getPassword())) {
			return "Login Succesful";
		}
		else return "Invalid Password";
	}
}
