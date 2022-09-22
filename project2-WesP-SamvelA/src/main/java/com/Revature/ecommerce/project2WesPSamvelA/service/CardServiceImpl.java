package com.Revature.ecommerce.project2WesPSamvelA.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Revature.ecommerce.project2WesPSamvelA.dao.CardDao;
import com.Revature.ecommerce.project2WesPSamvelA.entity.CardEntity;
import com.Revature.ecommerce.project2WesPSamvelA.pojo.CardPojo;
@Service
public class CardServiceImpl implements CardService
{
	@Autowired
	CardDao cardDao;

	@Override
	public CardPojo addNewCard(CardPojo newCard) 
	{
		CardEntity newCardEntity = new CardEntity();
		BeanUtils.copyProperties(newCard, newCardEntity);
		cardDao.saveAndFlush(newCardEntity);
		
		newCard.setCardId(newCardEntity.getCardId());
		return newCard;
	}
	@Override
	public List<CardPojo> getAllCards() 
	{
		List<CardEntity> allCardsEntity = cardDao.findAll();
		List<CardPojo> allCardsPojo = new ArrayList<CardPojo>();
		
		allCardsEntity.forEach((eachEntity)->allCardsPojo.add
				(new CardPojo(eachEntity.getCardId(), eachEntity.getCardName(),eachEntity.getCardType(),eachEntity.getCardRarity(), eachEntity.getCardSet(),eachEntity.getCardValue(), eachEntity.getCardQuantity(), eachEntity.getCardUrl())));
		return allCardsPojo;
	}

	
}