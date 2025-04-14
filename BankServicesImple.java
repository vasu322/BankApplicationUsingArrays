package com.bank.services;

import com.bank.dao.BankDAOImple;
import com.bank.exceptions.AccountNotFoundException;

import com.bank.exceptions.AmountNegativeException;
import com.bank.exceptions.InsufficientBalanceException;
import com.bank.exceptions.TargetAccountNotFoundException;
import com.bank.model.Account;
import com.bank.model.Transaction;
import com.bank.services.BankServices;

public class BankServicesImple implements BankServices {
	boolean is2ndTime = false;
	static int id = 1001;

	@Override
	public double showBalance(int accountNumber, BankDAOImple dao) throws AccountNotFoundException {
		if (!isValidAccountNumber(accountNumber, dao))
			throw new AccountNotFoundException("AccountNotFound");

		return dao.getAccountById(accountNumber).getBalance();

	}
	
	@Override
	public boolean isValidAccountNumber(int accountNumber, BankDAOImple dao) {
		if (dao.getAccountById(accountNumber) == null)
			return false;
		else
		return true;
	}

	@Override
	public double deposit(int accountNumber, double amount, BankDAOImple dao)
			throws AccountNotFoundException, AmountNegativeException {

		if (!isValidAccountNumber(accountNumber, dao))
			throw new AccountNotFoundException("AccountNotFound");
		if (amount < 0)
			throw new AmountNegativeException("Deposit Amount Should Be Greater Than Zero");

		Account targetAccount = dao.getAccountById(accountNumber);
		targetAccount.setBalance(targetAccount.getBalance() + amount);
		if (is2ndTime)
			id++;
		Transaction transaction = new Transaction("deposit", id, "Self", accountNumber + "", amount,
				showBalance(accountNumber, dao));

		if (!is2ndTime) {
			dao.addtrans(accountNumber, transaction);
			id++;
		}
		return targetAccount.getBalance();

	}

	@Override
	public double withdraw(int accountNumber, double amount, BankDAOImple dao)
			throws InsufficientBalanceException, AccountNotFoundException {
		

		if (!isValidAccountNumber(accountNumber, dao))
			throw new AccountNotFoundException("AccountNotFound");

		if (dao.getAccountById(accountNumber).getBalance() < amount)
			throw new InsufficientBalanceException("InsufficientBalance");

		Account targetAccount = dao.getAccountById(accountNumber);
		targetAccount.setBalance(targetAccount.getBalance() - amount);
		if (is2ndTime)
			id++;
		Transaction transaction = new Transaction("withdraw", id, accountNumber + "", "Self", amount,
				showBalance(accountNumber, dao));
		if (!is2ndTime) {
			dao.addtrans(accountNumber, transaction);
			id++;
		}
		return targetAccount.getBalance();
	}

	@Override
	public double fundTransfer(int sourceAccount, int targetAccount, double amount, BankDAOImple dao)
			throws InsufficientBalanceException, AccountNotFoundException, AmountNegativeException,
			TargetAccountNotFoundException {

		if (sourceAccount == targetAccount)
			throw new TargetAccountNotFoundException("Source Account and Target Account Must be Different");
		if (!isValidAccountNumber(sourceAccount, dao))
			throw new AccountNotFoundException("SourceAccountNotFound");
		if (!isValidAccountNumber(targetAccount, dao))
			throw new TargetAccountNotFoundException("TargetAccountNotFound");

		if (dao.getAccountById(sourceAccount).getBalance() < amount)
			throw new InsufficientBalanceException(
					"InsufficientBalance from " + dao.getAccountById(sourceAccount).getAccountNumber());

		if (amount < 0)
			throw new AmountNegativeException("Amount Should Be Greater Than Zero");

		is2ndTime = true;
		withdraw(sourceAccount, amount, dao);
		deposit(targetAccount, amount, dao);

		is2ndTime = false;

		Transaction sourceTransaction = new Transaction("Transfer", id, sourceAccount + "", targetAccount + "", amount,
				showBalance(sourceAccount, dao));
		dao.addtrans(sourceAccount, sourceTransaction);

		Transaction targetTransaction = new Transaction("Credited", id++, sourceAccount + "", targetAccount + "",
				amount, showBalance(targetAccount, dao));
		dao.addtrans(targetAccount, targetTransaction);
		return showBalance(sourceAccount, dao);
	}

	@Override
	public Transaction[] getAllTransactionDetails(int accountNo, BankDAOImple dao) throws AccountNotFoundException {

		if (!isValidAccountNumber(accountNo, dao))
			throw new AccountNotFoundException("AccountNotFound");
		
		return dao.getTransactions(accountNo);
	}

}
