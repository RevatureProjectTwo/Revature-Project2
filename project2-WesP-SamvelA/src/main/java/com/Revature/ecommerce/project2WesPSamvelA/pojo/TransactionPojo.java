package com.Revature.ecommerce.project2WesPSamvelA.pojo;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import com.Revature.ecommerce.project2WesPSamvelA.entity.CardEntity;

public class TransactionPojo 
{
	private int transId;
	private int transUserId;
	private LocalDate transDate;
	private double transTotalPrice;
	private List<CardPojo> allCards;
	
	
	
	
	public TransactionPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransactionPojo(int transId, int transUserId, LocalDate transDate, double transTotalPrice,
			List<CardPojo> allCards) {
		super();
		this.transId = transId;
		this.transUserId = transUserId;
		this.transDate = transDate;
		this.transTotalPrice = transTotalPrice;
		this.allCards = allCards;
	}

	public int getTransId() {
		return transId;
	}

	public void setTransId(int transId) {
		this.transId = transId;
	}

	public int getTransUserId() {
		return transUserId;
	}

	public void setTransUserId(int transUserId) {
		this.transUserId = transUserId;
	}

	public LocalDate getTransDate() {
		return transDate;
	}

	public void setTransDate(LocalDate transDate) {
		this.transDate = transDate;
	}

	public double getTransTotalPrice() {
		return transTotalPrice;
	}

	public void setTransTotalPrice(double transTotalPrice) {
		this.transTotalPrice = transTotalPrice;
	}

	public List<CardPojo> getAllCards() {
		return allCards;
	}

	public void setAllCards(List<CardPojo> allCards) {
		this.allCards = allCards;
	}

	@Override
	public String toString() {
		return "TransactionPojo [transId=" + transId + ", transUserId=" + transUserId + ", transDate=" + transDate
				+ ", transTotalPrice=" + transTotalPrice + ", allCards=" + allCards + "]";
	}
	
	
	
	
}
