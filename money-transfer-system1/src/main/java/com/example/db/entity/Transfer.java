package com.example.db.entity;

import java.sql.Timestamp;

public class Transfer {
	private int transactionId;
	private int account;
	private Timestamp dateAndTime;
	private int amount;
	private String creditOrDebit;
	
	public Transfer(int account, Timestamp time, int amount, String creditOrDebit) {
		super();
//		this.transactionId = transactionId;
		this.account = account;
		this.dateAndTime = time;
		this.amount = amount;
		this.creditOrDebit = creditOrDebit;
	}
	
	public Transfer() {

	}

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}
	
	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public Timestamp getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(Timestamp time) {
		this.dateAndTime = time;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getCreditOrDebit() {
		return creditOrDebit;
	}

	public void setCreditOrDebit(String creditOrDebit) {
		this.creditOrDebit = creditOrDebit;
	}

	@Override
	public String toString() {
		return "TransactionId = " + transactionId + ", Account Number = " + account+ ", dateAndTime = " + dateAndTime + ", amount = " + amount
				+ ", creditOrDebit = " + creditOrDebit;
	}
	
}

