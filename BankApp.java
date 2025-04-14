package com.bank.controller;

import com.bank.controller.BankMainClass;

import com.bank.exceptions.AccountNotFoundException;
import com.bank.exceptions.AmountNegativeException;
import com.bank.exceptions.InsufficientBalanceException;
import com.bank.exceptions.TargetAccountNotFoundException;

public class BankApp {
	public static void main(String[] args) throws AccountNotFoundException, AmountNegativeException,
			InsufficientBalanceException, TargetAccountNotFoundException {
		BankMainClass app = new BankMainClass();
		app.execute();
	}

}