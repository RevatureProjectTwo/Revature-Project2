package com.Revature.ecommerce.project2WesPSamvelA.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Revature.ecommerce.project2WesPSamvelA.dao.CardDao;
import com.Revature.ecommerce.project2WesPSamvelA.dao.CartDao;
import com.Revature.ecommerce.project2WesPSamvelA.dao.TransactionDao;
import com.Revature.ecommerce.project2WesPSamvelA.dao.UserDao;
import com.Revature.ecommerce.project2WesPSamvelA.entity.CardEntity;
import com.Revature.ecommerce.project2WesPSamvelA.entity.CartEntity;
import com.Revature.ecommerce.project2WesPSamvelA.entity.TransactionEntity;
import com.Revature.ecommerce.project2WesPSamvelA.entity.UserEntity;
import com.Revature.ecommerce.project2WesPSamvelA.pojo.CardPojo;
import com.Revature.ecommerce.project2WesPSamvelA.pojo.CartPojo;
import com.Revature.ecommerce.project2WesPSamvelA.pojo.TransactionPojo;
import com.Revature.ecommerce.project2WesPSamvelA.pojo.UserPojo;
@Service
public class UserServiceImpl implements UserService
{
	
	LocalDate date= LocalDate.now();
	@Autowired
	UserDao userDao;
	@Autowired
	TransactionDao transDao;
	@Autowired
	CartDao cartDao;
	@Autowired
	CardDao cardDao;

	@Override
	public UserPojo addUser(UserPojo newUserPojo) 
	{
		UserEntity newUserEntity = new UserEntity();
		BeanUtils.copyProperties(newUserPojo, newUserEntity);
		userDao.saveAndFlush(newUserEntity);
		newUserPojo.setUserId(newUserEntity.getUserId());
		return newUserPojo;
	}

	@Override
	public UserPojo validateAUser(UserPojo userPojo) 
	{
		System.out.println(userPojo);
		Optional<UserEntity> optionalUserEntity= userDao.findByUserUserNameAndUserPassword(userPojo.getUserUserName(), userPojo.getUserPassword());
		
		if(optionalUserEntity.isPresent())
		{
			BeanUtils.copyProperties(optionalUserEntity.get(), userPojo);
		}
		
		return userPojo;
	}

	
	@Override 
	public CartPojo updateTransactions(CartPojo purchasedCart)
	{
		TransactionEntity newTransEntity = new TransactionEntity();
		TransactionPojo newTransaction = new TransactionPojo();
		newTransaction.setTransTotalPrice(purchasedCart.getCartValue());
		newTransaction.setTransUserId(purchasedCart.getCartUserId());
		newTransaction.setTransDate(date);
	
		List<CardEntity> purchasedCardsEntity = new ArrayList<CardEntity>();
			purchasedCart.getAllCards().forEach((eachCardPojo)->
			{
				CardEntity purchasedCardEntity = new CardEntity();
				BeanUtils.copyProperties(eachCardPojo, purchasedCardEntity);
	
				purchasedCardsEntity.add(purchasedCardEntity);	
			});
		
		BeanUtils.copyProperties(newTransaction, newTransEntity);
		newTransEntity.setAllCards(purchasedCardsEntity);
		
		transDao.save(newTransEntity);
		purchasedCart.setCartValue(0);
		
		return purchasedCart;
	}
	
	@Override
	public List<TransactionPojo> viewAllOrders(int userId) 
	{
		List<TransactionEntity> allTransactionsEntity = transDao.findByTransUserId(userId);
		List<TransactionPojo> allTransactionsPojo= new ArrayList<TransactionPojo>();
		
		allTransactionsEntity.forEach((eachTransactionEntity)->
		{
			TransactionPojo insertTransPojo = new TransactionPojo();
			BeanUtils.copyProperties(eachTransactionEntity, insertTransPojo);
			List<CardPojo> allCardPojo = new ArrayList<CardPojo>();
			
			eachTransactionEntity.getAllCards().forEach((eachCardEntity)->
			{
				CardPojo insertCardPojo = new CardPojo();
				BeanUtils.copyProperties(eachCardEntity, insertCardPojo);
				allCardPojo.add(insertCardPojo);			
			});
			
			insertTransPojo.setAllCards(allCardPojo);
			allTransactionsPojo.add(insertTransPojo);
		});		
		
		return allTransactionsPojo;
	}

	@Override
	public UserPojo updateProfile(UserPojo updatedUser) 
	{
		UserEntity updatedUserEntity = new UserEntity();
		BeanUtils.copyProperties(updatedUser, updatedUserEntity);
		userDao.save(updatedUserEntity);
		return updatedUser;
	}

	@Override 
	public CartPojo updateCart(CartPojo cartPojo)
	{
		CartEntity updatedCartEntity = new CartEntity();
		BeanUtils.copyProperties(cartPojo, updatedCartEntity);
		List<CardEntity> addedCardsEntity = new ArrayList<CardEntity>();
		
		cartPojo.getAllCards().forEach((eachCardPojo)->
		{
			CardEntity addedCardEntity = new CardEntity();
			BeanUtils.copyProperties(eachCardPojo, addedCardEntity);
			addedCardsEntity.add(addedCardEntity);
		});
		
		updatedCartEntity.setAllCards(addedCardsEntity);
		cartDao.save(updatedCartEntity);
		return cartPojo;
	}
	
	@Override
	public CartPojo viewCart(int userId) 
	{
		CartEntity fetchedCartEntity = cartDao.findByCartUserId(userId);
		CartPojo viewCart = new CartPojo();
		BeanUtils.copyProperties(fetchedCartEntity, viewCart);
		List<CardPojo> allCardPojo = new ArrayList<CardPojo>();
		
		fetchedCartEntity.getAllCards().forEach((eachCardEntity)->
		{
			CardPojo insertCardPojo = new CardPojo();
			BeanUtils.copyProperties(eachCardEntity, insertCardPojo);
			allCardPojo.add(insertCardPojo);		
		});
		
		viewCart.setAllCards(allCardPojo);
		return viewCart;
	}	
}
