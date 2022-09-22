package com.Revature.ecommerce.project2WesPSamvelA.service;

import java.util.List;

import com.Revature.ecommerce.project2WesPSamvelA.pojo.TransactionPojo;
import com.Revature.ecommerce.project2WesPSamvelA.pojo.UserPojo;

public interface UserService 
{

	UserPojo addUser(UserPojo newUserPojo);

	UserPojo validateAUser(UserPojo userPojo);

	List<TransactionPojo> viewAllOrders(int userId);

	UserPojo updateProfile(UserPojo updatedUser);

}
