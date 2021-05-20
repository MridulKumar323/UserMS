package com.infy.infyShop.user.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.infy.infyShop.user.dto.CartDTO;
import com.infy.infyShop.user.dto.ProductDTO;
import com.infy.infyShop.user.dto.WishlistDTO;
import com.infy.infyShop.user.service.CartService;
import com.infy.infyShop.user.service.WishlistService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@CrossOrigin
public class WishlistController {

	@Autowired
	WishlistService wishlistService;
	
	@PostMapping(value="/addWishlist")
	public ResponseEntity<String> addToWishlist(@RequestBody WishlistDTO wishlistDTO){
		return new ResponseEntity<>(wishlistService.addToWishlist(wishlistDTO),HttpStatus.OK);
	}

	@PostMapping(value="/deleteWishlist")
	public ResponseEntity<String> deleteFromWishlist(@RequestBody WishlistDTO wishlistDTO){
		return new ResponseEntity<>(wishlistService.deleteFromWishlist(wishlistDTO),HttpStatus.OK);
	}
	@GetMapping(value="/viewWishlist")
	public ResponseEntity<List<WishlistDTO>> getAll(){
		return new ResponseEntity<>(wishlistService.getAll(),HttpStatus.OK);
	}

	@GetMapping(value="/viewWishlist/{buyerId}")
	public ResponseEntity<List<ProductDTO>> getByBuyerId(Integer buyerId){
		List<WishlistDTO> wishlist=wishlistService.getAll();
		List<ProductDTO> productList=new ArrayList<>();
		for(WishlistDTO wdto:wishlist) {
			ProductDTO pdto=new RestTemplate().getForObject("http://localhost:8100/api/productid/"+wdto.getProdId(),ProductDTO.class);
			productList.add(pdto);
		}
		return new ResponseEntity<>(productList,HttpStatus.OK);
	}
}
