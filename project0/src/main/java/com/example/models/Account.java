package com.example.models;

public class Account {
	private int account_id;
	private String name;
	private int customer_id;
	private boolean approval_status;
	private double current_balance;
	
	public Account () {
		
	}
	public Account(int account_id, String name, boolean approval_status, double current_balance, int customer_id) {
		this.account_id = account_id;
		this.name = name;
		this.approval_status = approval_status;
		this.customer_id = customer_id;
		this.current_balance = current_balance;
	}
	
	public Account(String name, boolean approval_status, double current_balance, int customer_id) {
		this.name = name;
		this.approval_status = approval_status;
		this.customer_id = customer_id;
		this.current_balance = current_balance;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public double getCurrent_balance() {
		return current_balance;
	}

	public void setCurrent_balance(double current_balance) {
		this.current_balance = current_balance;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isApproval_status() {
		return approval_status;
	}
	public void setApproval_status(boolean approval_status) {
		this.approval_status = approval_status;
	}
	@Override
	public String toString() {
		return "Account [account_id=" + account_id + ", name=" + name + ", customer_id=" + customer_id
				+ ", approval_status=" + approval_status + ", current_balance=" + current_balance + "]";
	}
	

	
	
	
	
}
