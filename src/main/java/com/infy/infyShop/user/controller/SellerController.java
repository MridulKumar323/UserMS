package com.infy.infyShop.user.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.infyShop.user.dto.SellerDTO;
import com.infy.infyShop.user.service.SellerService;

@RestController
@RequestMapping("seller")
public class SellerController {
	
	@Autowired
	SellerService sellerService;
	
	@PostMapping(value="/register")
	public ResponseEntity<String> register(@RequestBody @Valid SellerDTO sellerDTO){
		String message = sellerService.userRegister(sellerDTO);
		return new ResponseEntity<>(message,HttpStatus.OK);
	}
	
	@GetMapping(value="/login")
	public ResponseEntity<String> login(@RequestBody SellerDTO sellerDTO){
		String message = sellerService.userLogin(sellerDTO);
		return new ResponseEntity<>(message,HttpStatus.OK);
	}
}