package com.Revature.ecommerce.project2WesPSamvelA.pojo;

public class CardPojo 
{
	private int cardId;
	private String cardName;
	private String cardType;
	private String cardRarity;
	private String cardSet;
	private double cardValue;
	private int cardQuanity;
	
	public CardPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public CardPojo(String cardName, String cardType, String cardRarity, 
					String cardSet, double cardValue,int cardQuanity) 
	{
		super();
		this.cardName = cardName;
		this.cardType = cardType;
		this.cardRarity = cardRarity;
		this.cardSet = cardSet;
		this.cardValue = cardValue;
		this.cardQuanity = cardQuanity;
	}

	public CardPojo(int cardId, String cardName, String cardType, String cardRarity, 
					String cardSet, double cardValue, int cardQuanity) 
	{
		super();
		this.cardId = cardId;
		this.cardName = cardName;
		this.cardType = cardType;
		this.cardRarity = cardRarity;
		this.cardSet = cardSet;
		this.cardValue = cardValue;
		this.cardQuanity = cardQuanity;
	}

	public int getCardId() 
	{
		return cardId;
	}

	public void setCardId(int cardId) 
	{
		this.cardId = cardId;
	}

	public String getCardName() 
	{
		return cardName;
	}

	public void setCardName(String cardName) 
	{
		this.cardName = cardName;
	}

	public String getCardType() 
	{
		return cardType;
	}

	public void setCardType(String cardType) 
	{
		this.cardType = cardType;
	}

	public String getCardRarity() 
	{
		return cardRarity;
	}

	public void setCardRarity(String cardRarity) 
	{
		this.cardRarity = cardRarity;
	}

	public String getCardSet() 
	{
		return cardSet;
	}

	public void setCardSet(String cardSet) 
	{
		this.cardSet = cardSet;
	}

	public double getCardValue() 
	{
		return cardValue;
	}

	public void setCardValue(double cardValue) 
	{
		this.cardValue = cardValue;
	}

	public int getCardQuanity() 
	{
		return cardQuanity;
	}

	public void setCardQuanity(int cardQuanity) 
	{
		this.cardQuanity = cardQuanity;
	}

	@Override
	public String toString() {
		return "CardPojo [cardId=" + cardId + ", cardName=" + cardName + ", cardType=" + cardType + ", cardRarity="
				+ cardRarity + ", cardSet=" + cardSet + ", cardValue=" + cardValue + ", cardQuanity=" + cardQuanity
				+ "]";
	}
	
	
}
