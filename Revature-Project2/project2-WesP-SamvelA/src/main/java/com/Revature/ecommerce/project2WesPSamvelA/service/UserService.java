package com.Revature.ecommerce.project2WesPSamvelA.service;

// import java.util.List;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import com.Revature.ecommerce.project2WesPSamvelA.entity.UserEntity;
import com.Revature.ecommerce.project2WesPSamvelA.pojo.UserPojo;


public interface UserService {
	
	UserPojo addUser(UserPojo userPojo);
	
	UserPojo getEmployee(int userId);
	UserPojo getUser(int userId);

	UserEntity getUserByUsernameAndPassword(String userUserName, String userPassword);

	String signToken(String username, String password);
	UserPojo authenticate(String token) throws Exception;
	
	

}
