
package com.bank.model;

public class Transaction {
	String transactionType;
	int transactionId;
	String transactionFrom;
	String transactionTo;
	double amount;
	double balance;

	public Transaction(String transactionType, int transactionId, String transactionFrom, String transactionTo,
			double amount, double balance) {
		super();
		this.transactionType = transactionType;
		this.transactionId = transactionId;
		this.transactionFrom = transactionFrom;
		this.transactionTo = transactionTo;
		this.amount = amount;
		this.balance = balance;
	}

	public String getTransactionType() {
		return transactionType;
	}


	public int getTransactionId() {
		return transactionId;
	}



	public String getTransactionFrom() {
		return transactionFrom;
	}



	public String getTransactionTo() {
		return transactionTo;
	}



	public double getAmount() {
		return amount;
	}



	public double getBalance() {
		return balance;
	}




}
