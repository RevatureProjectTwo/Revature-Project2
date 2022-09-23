package com.Revature.ecommerce.project2WesPSamvelA.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Revature.ecommerce.project2WesPSamvelA.entity.CardEntity;
@Repository
public interface CardDao extends JpaRepository<CardEntity, Integer>
{
	CardEntity findById(int cardId);
}
