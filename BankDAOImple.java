package com.bank.dao;

import com.bank.dao.BankDAO;



import com.bank.model.Account;
import com.bank.model.Customer;
import com.bank.model.Transaction;

public class BankDAOImple implements BankDAO {

	int counter = 0;
	
	public Account[] accounts = new Account[10];

	public Transaction[] getTransactions(int accNo) {
		Transaction[] transactions = getAccountById(accNo).getTransactions();
		return transactions;
	}

	public void addtrans(int accNo, Transaction transaction) {
		Account accountToAdd = null;
		for (Account account : accounts) {
			if (account == null)
				break;
			if (account.getAccountNumber() == accNo)
				accountToAdd = account;
		}

		Transaction[] transactions = accountToAdd.getTransactions();

		int target = -1;
		for (int i = 0; i < transactions.length; i++) {
			if (transactions[i] == null) {
				target = i;
				break;
			}
	}
		
		transactions[target] = transaction;
	}

	@Override
	public boolean save(Account account) {
		if (counter >= accounts.length)
			return false;
		accounts[counter++] = account;
		return true;
	}

	@Override
	public Account getAccountById(int accountId) {

		Account accountToAdd = null;
		for (Account account : accounts) {
			if (account == null) {
				break;
			}
			if (account.getAccountNumber() == accountId)
				accountToAdd = account;
		}
		return accountToAdd;
	}
}