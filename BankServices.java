package com.bank.services;

import com.bank.dao.BankDAOImple;
import com.bank.exceptions.AccountNotFoundException;
import com.bank.exceptions.AmountNegativeException;
import com.bank.exceptions.InsufficientBalanceException;
import com.bank.exceptions.TargetAccountNotFoundException;
import com.bank.model.Transaction;

public interface BankServices {

	public double showBalance(int accountNumber, BankDAOImple dao) throws AccountNotFoundException;

	public double deposit(int accountNumber, double amount, BankDAOImple dao)
			throws AccountNotFoundException, AmountNegativeException;

	public double withdraw(int accountNumber, double amount, BankDAOImple dao)
			throws InsufficientBalanceException, AccountNotFoundException;

	public double fundTransfer(int sourceAccount, int targetAccount, double amount, BankDAOImple dao)
			throws InsufficientBalanceException, AccountNotFoundException, AmountNegativeException,
			TargetAccountNotFoundException;

	public Transaction[] getAllTransactionDetails(int accountNumber, BankDAOImple dao)throws AccountNotFoundException ;

	public boolean isValidAccountNumber(int accountNumber, BankDAOImple dao);
}
