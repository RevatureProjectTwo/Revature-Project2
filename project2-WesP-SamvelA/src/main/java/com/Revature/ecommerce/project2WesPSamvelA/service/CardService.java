package com.Revature.ecommerce.project2WesPSamvelA.service;

import java.util.List;

import com.Revature.ecommerce.project2WesPSamvelA.pojo.CardPojo;

public interface CardService 
{

	List<CardPojo> getAllCards();

	CardPojo addNewCard(CardPojo newCard);

}
