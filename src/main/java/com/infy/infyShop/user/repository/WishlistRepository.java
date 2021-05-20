package com.infy.infyShop.user.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.infy.infyShop.user.entity.Wishlist;
import com.infy.infyShop.user.entity.WishlistId;

public interface WishlistRepository extends CrudRepository<Wishlist,WishlistId>{
	List<Wishlist> findBybuyerId(int buyerId);
}
