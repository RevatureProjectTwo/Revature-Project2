package com.Revature.ecommerce.project2WesPSamvelA.pojo;

import java.util.List;
import java.util.Objects;

public class CartPojo 
{
	private int cartId;
	private int cartUserId;
	private double cartValue;
	private List<CardPojo> allCards;
	public CartPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartPojo(int cartId, int cartUserId, double cartValue, List<CardPojo> allCards) {
		super();
		this.cartId = cartId;
		this.cartUserId = cartUserId;
		this.cartValue = cartValue;
		this.allCards = allCards;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getCartUserId() {
		return cartUserId;
	}
	public void setCartUserId(int cartUserId) {
		this.cartUserId = cartUserId;
	}
	public double getCartValue() {
		return cartValue;
	}
	public void setCartValue(double cartValue) {
		this.cartValue = cartValue;
	}
	public List<CardPojo> getAllCards() {
		return allCards;
	}
	public void setAllCards(List<CardPojo> allCards) {
		this.allCards = allCards;
	}
	@Override
	public String toString() {
		return "CartPojo [cartId=" + cartId + ", cartUserId=" + cartUserId + ", cartValue=" + cartValue + ", allCards="
				+ allCards + "]";
	}
	
}
