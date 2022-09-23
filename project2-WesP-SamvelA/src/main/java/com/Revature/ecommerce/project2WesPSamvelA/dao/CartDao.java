package com.Revature.ecommerce.project2WesPSamvelA.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Revature.ecommerce.project2WesPSamvelA.entity.CartEntity;
import com.Revature.ecommerce.project2WesPSamvelA.entity.TransactionEntity;

public interface CartDao extends JpaRepository<CartEntity, Integer>
{

	CartEntity findByCartUserId(int userId);

}
