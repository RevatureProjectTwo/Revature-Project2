package com.Revature.ecommerce.project2WesPSamvelA.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Revature.ecommerce.project2WesPSamvelA.dao.TransactionDao;
import com.Revature.ecommerce.project2WesPSamvelA.dao.UserDao;
import com.Revature.ecommerce.project2WesPSamvelA.entity.TransactionEntity;
import com.Revature.ecommerce.project2WesPSamvelA.entity.UserEntity;
import com.Revature.ecommerce.project2WesPSamvelA.pojo.TransactionPojo;
import com.Revature.ecommerce.project2WesPSamvelA.pojo.UserPojo;
@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	UserDao userDao;
	@Autowired
	TransactionDao transDao;

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
		
		allTransactionsEntity.forEach((eachEntity)->allTransactionsPojo.add(new TransactionPojo(eachEntity.getTransId(),eachEntity.getTransUserId(),eachEntity.getTransDate(),eachEntity.getTransTotalPrice())));
		
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
}
