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

import com.infy.infyShop.user.dto.BuyerDTO;
import com.infy.infyShop.user.service.BuyerService;

@RestController
@RequestMapping("buyer")
public class BuyerController {
	
	@Autowired
	BuyerService buyerService;
	
	@PostMapping(value="/register")
	public ResponseEntity<String> register(@RequestBody @Valid BuyerDTO buyerDTO){
		String message = buyerService.userRegister(buyerDTO);
		return new ResponseEntity<>(message,HttpStatus.OK);
	}
	
	@GetMapping(value="/login")
	public ResponseEntity<String> login(@RequestBody BuyerDTO buyerDTO){
		String message = buyerService.userLogin(buyerDTO);
		return new ResponseEntity<>(message,HttpStatus.OK);
	}
	
}