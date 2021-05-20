package com.infy.infyShop.user.service;

import com.infy.infyShop.user.dto.BuyerDTO;

public interface BuyerService {
	public String userRegister(BuyerDTO buyerdto);
	public String userLogin(BuyerDTO buyerDTO);

}