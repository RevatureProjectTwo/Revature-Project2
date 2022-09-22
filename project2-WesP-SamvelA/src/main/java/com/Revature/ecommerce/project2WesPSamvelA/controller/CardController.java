package com.Revature.ecommerce.project2WesPSamvelA.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Revature.ecommerce.project2WesPSamvelA.pojo.CardPojo;
import com.Revature.ecommerce.project2WesPSamvelA.service.CardService;

@RestController
@RequestMapping("api/cards")
public class CardController 
{

	@Autowired
	CardService cardService;
	
	@PostMapping("")
	public CardPojo addACard(@Valid @RequestBody CardPojo newCard)
	{
		return cardService.addNewCard(newCard);

	}
	
	@GetMapping("/allCards")
	public List<CardPojo> displayAllCards()
	{
		List<CardPojo> allCards = cardService.getAllCards();
	
		return allCards;
	}
	
	
}
