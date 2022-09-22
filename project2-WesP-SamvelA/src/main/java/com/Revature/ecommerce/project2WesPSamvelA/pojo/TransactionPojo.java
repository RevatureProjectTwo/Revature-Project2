package com.Revature.ecommerce.project2WesPSamvelA.pojo;

import java.sql.Date;
import java.util.Objects;

public class TransactionPojo 
{
	private int transId;
	private int transUserId;
	private Date transDate;
	private double transTotalPrice;
	
	public TransactionPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransactionPojo(int transId, int transUserId, Date transDate, double transTotalPrice) {
		super();
		this.transId = transId;
		this.transUserId = transUserId;
		this.transDate = transDate;
		this.transTotalPrice = transTotalPrice;
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

	public Date getTransDate() {
		return transDate;
	}

	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}

	public double getTransTotalPrice() {
		return transTotalPrice;
	}

	public void setTransTotalPrice(double transTotalPrice) {
		this.transTotalPrice = transTotalPrice;
	}

	@Override
	public String toString() {
		return "TransactionPojo [transId=" + transId + ", transUserId=" + transUserId + ", transDate=" + transDate
				+ ", transTotalPrice=" + transTotalPrice + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(transDate, transId, transTotalPrice, transUserId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransactionPojo other = (TransactionPojo) obj;
		return Objects.equals(transDate, other.transDate) && transId == other.transId
				&& Double.doubleToLongBits(transTotalPrice) == Double.doubleToLongBits(other.transTotalPrice)
				&& transUserId == other.transUserId;
	}
	
	
	
}
