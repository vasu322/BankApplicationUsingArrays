

package com.bank.model;

import java.util.Arrays;

public class Account {
	private double balance;
	private long accountNumber;
	private Customer customer;
	Transaction[] transactions;

	public Account(double balance, long accountNumber, Customer customer, Transaction[] transactions) {
		super();
		this.balance = balance;
		this.accountNumber = accountNumber;
		this.customer = customer;
		this.transactions = transactions;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public long getAccountNumber() {
		return accountNumber;
	}



	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Transaction[] getTransactions() {
		return transactions;
	}

	public void setTransactions(Transaction[] transactions) {
		this.transactions = transactions;
	}



}