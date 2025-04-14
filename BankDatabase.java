package com.bank.util;

import com.bank.model.Account;
import com.bank.model.Customer;
import com.bank.model.Transaction;
import com.bank.dao.BankDAOImple;
import com.bank.dao.BankDAO;

public class BankDatabase {
	
	
	
	BankDAOImple dao=new BankDAOImple();
	
	public BankDAOImple getDatabaseReference() {
		return dao;
	}
	
	Customer c1=new Customer("Koti",4035);
	Customer c2=new Customer("Ramu",4044);
	Customer c3=new Customer("Abhi",4160);
	Customer c4=new Customer("Ashif",4048);
	Customer c5=new Customer("Shiva",4049);
	Customer c6=new Customer("Yeftha",4050);
	Customer c7=new Customer("Sai",4051);
	Customer c8=new Customer("Mohan",4052);
	Customer c9=new Customer("Harish",4053);
	Customer c10=new Customer("Bob",4054);
	
	
	Transaction[] transactionforc1=new Transaction[10];
	
	Transaction[] transactionforc2=new Transaction[10];
	Transaction[] transactionforc3=new Transaction[10];
	Transaction[] transactionforc4=new Transaction[10];
	Transaction[] transactionforc5=new Transaction[10];
	Transaction[] transactionforc6=new Transaction[10];
	Transaction[] transactionforc7=new Transaction[10];
	Transaction[] transactionforc8=new Transaction[10];
	Transaction[] transactionforc9=new Transaction[10];
	Transaction[] transactionforc10=new Transaction[10];
	
	
	Account account1=new Account(10000,1111,c1,transactionforc1);
	Account account2=new Account(10000,2222,c2,transactionforc2);
	Account account3=new Account(10000,3333,c3,transactionforc3);
	Account account4=new Account(10000,4444,c4,transactionforc4);
	Account account5=new Account(10000,5555,c5,transactionforc5);
	Account account6=new Account(10000,6666,c6,transactionforc6);
	Account account7=new Account(10000,7777,c7,transactionforc7);
	Account account8=new Account(10000,8888,c8,transactionforc8);
	Account account9=new Account(10000,9999,c9,transactionforc9);
	Account account10=new Account(10000,1010,c10,transactionforc10);
	
	
	
	
	
	boolean b1=dao.save(account1);
	boolean b2=dao.save(account2);
	boolean b3=dao.save(account3);
	boolean b4=dao.save(account4);
	boolean b5=dao.save(account5);
	boolean b6=dao.save(account6);
	boolean b7=dao.save(account7);
	boolean b8=dao.save(account8);
	boolean b9=dao.save(account9);
	boolean b10=dao.save(account10);
}
