package com.Revature.ecommerce.project2WesPSamvelA.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private int bookId;
	
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
}
