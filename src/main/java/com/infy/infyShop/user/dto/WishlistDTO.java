package com.infy.infyShop.user.dto;

import com.infy.infyShop.user.entity.Wishlist;

public class WishlistDTO {
	private Integer buyerId;
	private Integer prodId;
	
	public Integer getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}
	public Integer getProdId() {
		return prodId;
	}
	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}
	public static WishlistDTO valueOf(Wishlist wishlist) {
		WishlistDTO wdto=new WishlistDTO();
		wdto.setBuyerId(wishlist.getBuyerId());
		wdto.setProdId(wishlist.getProdId());
		return wdto;
	}
}
