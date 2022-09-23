package com.Revature.ecommerce.project2WesPSamvelA.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Revature.ecommerce.project2WesPSamvelA.entity.CardEntity;
import com.Revature.ecommerce.project2WesPSamvelA.entity.TransactionEntity;
@Repository
public interface TransactionDao extends JpaRepository<TransactionEntity, Integer>
{
	List<TransactionEntity> findByTransUserId(int userId);
}
