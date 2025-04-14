package com.bank.dao;

import com.bank.model.Account;

public interface BankDAO {

	public boolean save(Account account);

	public Account getAccountById(int accountId);
}
