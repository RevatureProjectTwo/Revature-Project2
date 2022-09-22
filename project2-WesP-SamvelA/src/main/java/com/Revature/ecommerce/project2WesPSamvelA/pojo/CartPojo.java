package com.Revature.ecommerce.project2WesPSamvelA.pojo;

import java.util.List;
import java.util.Objects;

public class CartPojo 
{
	private int cartId;
	private List<CardPojo> cartItems;
	private int cartUserId;
	private double cartValue;
	
	public CartPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartPojo(int cartId, List<CardPojo> cartItems, int cartUserId, double cartValue) {
		super();
		this.cartId = cartId;
		this.cartItems = cartItems;
		this.cartUserId = cartUserId;
		this.cartValue = cartValue;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public List<CardPojo> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CardPojo> cartItems) {
		this.cartItems = cartItems;
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

	@Override
	public String toString() {
		return "CartPojo [cartId=" + cartId + ", cartItems=" + cartItems + ", cartUserId=" + cartUserId + ", cartValue="
				+ cartValue + "]";
	}

	
	
}
