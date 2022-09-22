package com.Revature.ecommerce.project2WesPSamvelA.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Revature.ecommerce.project2WesPSamvelA.entity.TransactionEntity;
import com.Revature.ecommerce.project2WesPSamvelA.entity.UserEntity;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Integer>
{

	Optional<UserEntity> findByUserUserNameAndUserPassword(String userName, String password);
	Optional<UserEntity> findByUserId(int userId);

	
	
}
