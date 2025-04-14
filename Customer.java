
package com.bank.model;

public class Customer {
	String customerName;
	int custId;

	public Customer(String customerName, int custId) {
		super();
		this.customerName = customerName;
		this.custId = custId;
	}

	public String getCustomerName() {
		return customerName;
	}



	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}



}
