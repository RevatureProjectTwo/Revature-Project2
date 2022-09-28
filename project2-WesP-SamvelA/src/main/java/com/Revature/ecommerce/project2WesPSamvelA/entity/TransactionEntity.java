package com.Revature.ecommerce.project2WesPSamvelA.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.Revature.ecommerce.project2WesPSamvelA.pojo.TransactionPojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="transaction_details")
public class TransactionEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="trans_id")
	private int transId;
	
	@Column(name="trans_user_id")
	private int transUserId;
	
	@Column(name="trans_date")
	private LocalDate transDate;
	
	@Column(name="trans_total_price")
	private double transTotalPrice;
	
	@ManyToMany
	@JoinTable
	(
		name="transaction_cards_details",
		joinColumns = @JoinColumn(name="trans_cards_trans_id"),
		inverseJoinColumns = @JoinColumn(name="trans_cards_card_id")
		
	)
	private List<CardEntity> allCards;
}

