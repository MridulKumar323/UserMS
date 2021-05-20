package com.infy.infyShop.user.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.infy.infyShop.user.dto.WishlistDTO;
import com.infy.infyShop.user.entity.Wishlist;
import com.infy.infyShop.user.repository.WishlistRepository;

@Service
public class WishlistServiceImpl implements WishlistService{
	
	@Autowired
	WishlistRepository wishlistRepo;

	@Override
	public String addToWishlist(WishlistDTO wishlistDTO) {
		// TODO Auto-generated method stub
		Wishlist wish=new Wishlist();
		wish.setBuyerId(wishlistDTO.getBuyerId());
		wish.setProdId(wishlistDTO.getProdId());
		wishlistRepo.save(wish);
		return "Product added to wishlist successfully";
	}

	@Override
	public String deleteFromWishlist(WishlistDTO wishlistDTO) {
		// TODO Auto-generated method stub
		Wishlist wish=new Wishlist();
		wish.setBuyerId(wishlistDTO.getBuyerId());
		wish.setProdId(wishlistDTO.getProdId());
		wishlistRepo.delete(wish);
		return "Product deleted from wishlist successfully";
	}

	@Override
	public List<WishlistDTO> getAll() {
		// TODO Auto-generated method stub
		List<WishlistDTO> list=new ArrayList<>();
		List<Wishlist> wishlist=(List<Wishlist>) wishlistRepo.findAll();
		for(Wishlist w:wishlist) {
			WishlistDTO wdto=new WishlistDTO();
			wdto.setBuyerId(w.getBuyerId());
			wdto.setProdId(w.getProdId());
			list.add(wdto);
		}
		return list;
	}

	@Override
	public List<WishlistDTO> getByBuyerId(int buyerId) {
		// TODO Auto-generated method stub
		List<WishlistDTO> list=new ArrayList<>();
		List<Wishlist> wishlist=(List<Wishlist>) wishlistRepo.findBybuyerId(buyerId);
		for(Wishlist w:wishlist) {
			WishlistDTO wdto=new WishlistDTO();
			wdto.setBuyerId(w.getBuyerId());
			wdto.setProdId(w.getProdId());
			list.add(wdto);
		}
		return list;
	}

	
	
}
