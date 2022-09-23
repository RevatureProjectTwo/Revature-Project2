package com.Revature.ecommerce.project2WesPSamvelA.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Revature.ecommerce.project2WesPSamvelA.pojo.CardPojo;
import com.Revature.ecommerce.project2WesPSamvelA.pojo.CartPojo;
import com.Revature.ecommerce.project2WesPSamvelA.pojo.TransactionPojo;
import com.Revature.ecommerce.project2WesPSamvelA.pojo.UserPojo;
import com.Revature.ecommerce.project2WesPSamvelA.service.UserService;

@RestController
@RequestMapping("api/user")
public class UserController 
{

	@Autowired
	UserService userService;
	
	@PostMapping("")
	public UserPojo registerUser(@Valid @RequestBody UserPojo newUserPojo)
	{
		return userService.addUser(newUserPojo);
	}
	
	@PostMapping("/validate")
	public UserPojo checkUserCreds(@RequestBody UserPojo checkUserPojo)
	{
		return userService.validateAUser(checkUserPojo);
	}
	
	@GetMapping("/orders/{uid}")
	public List<TransactionPojo> viewAllOrders(@PathVariable("uid") int userId)
	{
		List<TransactionPojo> allTransactions = userService.viewAllOrders(userId);
		return allTransactions;
	}
	
	@PostMapping("addItem")
	public CartPojo viewCurrentCart(@RequestBody CartPojo updatedCart, CardPojo addCard)
	{
		return userService.updateCart(updatedCart, addCard);
	}
	
	
	@PutMapping("/updateProfile")
	public UserPojo updateProfile(@RequestBody UserPojo updatedUser)
	{
		
		return userService.updateProfile(updatedUser);
	}
}
