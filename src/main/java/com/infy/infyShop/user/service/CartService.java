package com.infy.infyShop.user.service;

import java.util.List;

import com.infy.infyShop.user.dto.CartDTO;

public interface CartService {
	String addToCart(CartDTO cartDTO);
	String deleteFromCart(CartDTO cartDTO);
	List<CartDTO> getAll();
	List<CartDTO> getByBuyerId(int buyerId);
}
