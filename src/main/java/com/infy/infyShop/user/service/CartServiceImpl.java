package com.infy.infyShop.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.infyShop.user.dto.CartDTO;
import com.infy.infyShop.user.entity.Cart;
import com.infy.infyShop.user.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	CartRepository cartRepo;

	@Override
	public String addToCart(CartDTO cartDTO) {
		// TODO Auto-generated method stub
		Cart cart=new Cart();
		cart.setBuyerId(cartDTO.getBuyerId());
		cart.setProdId(cartDTO.getProdId());
		cart.setQuantity(cartDTO.getQuantity());
		cartRepo.save(cart);
		return "Product added to cart successfully";
	}

	@Override
	public String deleteFromCart(CartDTO cartDTO) {
		// TODO Auto-generated method stub
		Cart cart=new Cart();
		cart.setBuyerId(cartDTO.getBuyerId());
		cart.setProdId(cartDTO.getProdId());
		
		cartRepo.delete(cart);
		return "Product deleted from cart successfully";
	}
	public List<CartDTO> getAll() {
		List<CartDTO> list=new ArrayList<>();
		List<Cart> cartlist=(List<Cart>) cartRepo.findAll();
		for(Cart c:cartlist) {
			CartDTO cdto=new CartDTO();
			cdto.setBuyerId(c.getBuyerId());
			cdto.setProdId(c.getProdId());
			cdto.setQuantity(c.getQuantity());
			list.add(cdto);
		}
		return list;
	}

	@Override
	public List<CartDTO> getByBuyerId(int buyerId) {
		// TODO Auto-generated method stub
		List<CartDTO> list=new ArrayList<>();
		List<Cart> cartlist=(List<Cart>) cartRepo.findByBuyerId(buyerId);
		for(Cart c:cartlist) {
			CartDTO cdto=new CartDTO();
			cdto.setBuyerId(c.getBuyerId());
			cdto.setProdId(c.getProdId());
			cdto.setQuantity(c.getQuantity());
			list.add(cdto);
		}
		return list;
	}
}
