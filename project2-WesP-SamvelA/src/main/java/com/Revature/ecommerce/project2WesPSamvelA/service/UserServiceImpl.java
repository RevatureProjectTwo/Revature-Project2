package com.Revature.ecommerce.project2WesPSamvelA.service;

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
	public List<TransactionPojo> viewAllOrders(int userId) 
	{
		List<TransactionEntity> allTransactionsEntity = transDao.findByTransUserId(userId);
		List<TransactionPojo> allTransactionsPojo= new ArrayList<TransactionPojo>();
		
		allTransactionsEntity.forEach((eachTransactionEntity)->{
			TransactionPojo insertTransPojo = new TransactionPojo();
			BeanUtils.copyProperties(eachTransactionEntity, insertTransPojo);
			
			List<CardPojo> allCardPojo = new ArrayList<CardPojo>();
			eachTransactionEntity.getAllCards().forEach((eachCardEntity)->{
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
	public CartPojo updateCart(CartPojo updatedCart, CardPojo addCard) 
	{
		CartEntity updatedCartEntity = cartDao.findByCartUserId(updatedCart.getCartUserId());
		CardEntity addedCardEntity = cardDao.findById(addCard.getCardId());
		
		BeanUtils.copyProperties(updatedCartEntity, updatedCart);
		BeanUtils.copyProperties(addedCardEntity, addCard);
		updatedCart.getAllCards().add(addCard);
		BeanUtils.copyProperties(updatedCart, updatedCartEntity);
		cartDao.save(updatedCartEntity);
		
		return updatedCart;
	}
}
