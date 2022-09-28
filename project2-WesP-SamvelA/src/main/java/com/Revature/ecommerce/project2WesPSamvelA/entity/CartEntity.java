package com.Revature.ecommerce.project2WesPSamvelA.entity;

import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name="cart_details")
public class CartEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cart_id")
	private int cartId;
	
	@Column(name="cart_user_id")
	private int cartUserId;
	
	@Column(name="cart_value")
	private double cartValue;
	
	@ManyToMany
	@JoinTable
	(
			name="cart_cards_details",
			joinColumns = @JoinColumn(name="cart_cards_cart_id"),
			inverseJoinColumns = @JoinColumn(name="cart_cards_card_id")
	)
	private List<CardEntity> allCards;
}