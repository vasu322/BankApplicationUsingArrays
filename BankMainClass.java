package com.bank.controller; 

import java.util.Scanner;


import com.bank.dao.BankDAO;
import com.bank.dao.BankDAOImple;
import com.bank.exceptions.AccountNotFoundException;
import com.bank.exceptions.AmountNegativeException;
import com.bank.exceptions.InsufficientBalanceException;
import com.bank.exceptions.TargetAccountNotFoundException;
import com.bank.model.Transaction;
import com.bank.services.BankServices;
import com.bank.services.BankServicesImple;
import com.bank.util.BankDatabase;

public class BankMainClass {

	public void execute() throws AccountNotFoundException, AmountNegativeException, InsufficientBalanceException,
			TargetAccountNotFoundException {
		BankDatabase database = new BankDatabase();
		BankDAOImple dao = database.getDatabaseReference();
		BankServices services = new BankServicesImple();

		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("1.Continue");
			System.out.println("2.Exit");
			System.out.println("Enter Your Option");
			int input = scanner.nextInt();
			if (input == 2)
				break;
			System.out.println("Enter Account Number : ");
			int accNo = scanner.nextInt();
			if (!services.isValidAccountNumber(accNo, dao))
				throw new AccountNotFoundException("Account Not Found");
			while (true) {
				System.out.println("1.Show Balance");
				System.out.println("2.Deposit");
				System.out.println("3.Withdraw");
				System.out.println("4.Fund Transfer");
				System.out.println("5.List Of Transactions");
				System.out.println("6.Exit");
				System.out.println("Enter Your Option");
				int operation = scanner.nextInt();
				if (operation == 6)
					break;
				double amount = 0;
				switch (operation) {
				case 1:
					System.out.println("Balance : " + services.showBalance(accNo, dao));
					break;

				case 2:
					System.out.println("Enter Amount : ");
					amount = scanner.nextDouble();
					services.deposit(accNo, amount, dao);
					break;

				case 3:
					System.out.println("Enter Amount To WithDraw : ");
					amount = scanner.nextDouble();
					services.withdraw(accNo, amount, dao);
					break;

				case 4:
					System.out.println("Enter Target Account Number : ");
					int targetAccountNumber = scanner.nextInt();
					System.out.println("Enter amount to transfer : ");
					amount = scanner.nextDouble();
					services.fundTransfer(accNo, targetAccountNumber, amount, dao);
					break;

				case 5:
					Transaction[] allTransactionDetails = services.getAllTransactionDetails(accNo, dao);
					System.out.println("TransactionType TransactionId TransactionFrom TransactionTo Amount  Balance");
					for (Transaction transaction : allTransactionDetails) {
						if (transaction == null)
							break;
						System.out.println(transaction.getTransactionType() + "               "
								+ transaction.getTransactionId() + "             " + transaction.getTransactionFrom()
								+ "            " + transaction.getTransactionTo() + "     " + transaction.getAmount()
								+ "    " + transaction.getBalance());
					}
					break;
				default :
					System.out.println("Please choose Valid Option");
				}
				
				
					
			}
		}

	}

}