package com.infy.infyShop.user.service;

import java.util.List;

import com.infy.infyShop.user.dto.WishlistDTO;

public interface WishlistService {
	String addToWishlist(WishlistDTO wishlistDTO);
	String deleteFromWishlist(WishlistDTO wishlistDTO);
	List<WishlistDTO> getAll();
	List<WishlistDTO> getByBuyerId(int buyerId);
}
