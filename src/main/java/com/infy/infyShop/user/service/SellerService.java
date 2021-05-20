package com.infy.infyShop.user.service;

import javax.validation.Valid;

import com.infy.infyShop.user.dto.SellerDTO;

public interface SellerService {
	public String userRegister(SellerDTO sellerDTO);
	public String userLogin(@Valid SellerDTO sellerDTO);
}
