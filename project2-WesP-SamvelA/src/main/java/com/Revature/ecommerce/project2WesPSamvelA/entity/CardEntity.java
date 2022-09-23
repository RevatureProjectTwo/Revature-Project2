package com.Revature.ecommerce.project2WesPSamvelA.entity;

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
import javax.persistence.Table;

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
@Table(name="cards_details")
public class CardEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="card_id")
	private int cardId;
	
	@Column(name="card_name")
	private String cardName;
	
	@Column(name="card_type")
	private String cardType;
	
	@Column(name="card_rarity")
	private String cardRarity;
	
	@Column(name="card_set")
	private String cardSet;
	
	@Column(name="card_value")
	private double cardValue;
	
	@Column(name="card_quantity")
	private int cardQuantity;
	
	@Column(name="card_url")
	private String cardUrl;
	
	@ManyToMany
	@JoinTable
	(
		name="transaction_cards_details",
		joinColumns = @JoinColumn(name="trans_cards_card_id"),
		inverseJoinColumns = @JoinColumn(name="trans_cards_trans_id")
		
	)
	private List<TransactionEntity> allTrans;
	
	@ManyToMany
	@JoinTable
	(
			name="cart_cards_details",
			joinColumns = @JoinColumn(name="cart_cards_card_id"),
			inverseJoinColumns = @JoinColumn(name="cart_cards_cart_id")
	)
	private List<CartEntity> allCarts;
	

	
}
