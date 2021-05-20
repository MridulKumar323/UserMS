package com.infy.infyShop.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.infy.infyShop.user.dto.CartDTO;
import com.infy.infyShop.user.dto.ProductDTO;
import com.infy.infyShop.user.service.CartService;

@RestController
@CrossOrigin
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@PostMapping(value="/add")
	public ResponseEntity<String> addToCart(@RequestBody CartDTO cartDTO){
		return new ResponseEntity<>(cartService.addToCart(cartDTO),HttpStatus.OK);
	}

	@PostMapping(value="/delete")
	public ResponseEntity<String> deleteFromCart(@RequestBody CartDTO cartDTO){
		return new ResponseEntity<>(cartService.deleteFromCart(cartDTO),HttpStatus.OK);
	}

	@GetMapping(value="/viewCart")
	public ResponseEntity<List<CartDTO>> getAll(){
		return new ResponseEntity<>(cartService.getAll(),HttpStatus.OK);
	}

	@GetMapping(value="/viewCart/{buyerId}")
	public ResponseEntity<List<ProductDTO>> getByBuyerId(Integer buyerId){
		List<CartDTO> cartList=cartService.getAll();
		List<ProductDTO> productList=new ArrayList<>();
		for(CartDTO cdto:cartList) {
			ProductDTO pdto=new RestTemplate().getForObject("http://localhost:8100/api/productid/"+cdto.getProdId(),ProductDTO.class);
			productList.add(pdto);
		}
		return new ResponseEntity<>(productList,HttpStatus.OK);
	}
} 
