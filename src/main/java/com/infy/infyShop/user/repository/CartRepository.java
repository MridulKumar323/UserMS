package com.infy.infyShop.user.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.infy.infyShop.user.entity.Cart;
import com.infy.infyShop.user.entity.CartId;

public interface CartRepository extends CrudRepository<Cart,CartId>{
	List<Cart> findByBuyerId(int buyerId);
}
