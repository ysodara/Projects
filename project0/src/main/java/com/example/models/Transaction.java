package com.example.models;

public class Transaction {
	private int transaction_id;
	private String description;
	private String type_of_transaction;
	private double amount;
	private int customer_id;
	private int account_id;
	
	
	public Transaction() {
		
	}
	public Transaction(String description, String type_of_transaction, double amount,int customer_id, int account_id) {
	this.description = 	description;
	this.type_of_transaction = type_of_transaction;
	this.amount = amount;
	this.customer_id = customer_id;
	this.account_id = account_id;
	}
	
	public Transaction(int transaction_id, String description, String type_of_transaction, double amount,int customer_id, int account_id) {
		this.transaction_id = transaction_id;
		this.description = 	description;
		this.type_of_transaction = type_of_transaction;
		this.amount = amount;
		this.customer_id = customer_id;
		this.account_id = account_id;
	}
	public int getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType_of_transaction() {
		return type_of_transaction;
	}
	public void setType_of_transaction(String type_of_transaction) {
		this.type_of_transaction = type_of_transaction;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	
	
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	@Override
	public String toString() {
		String s = "*Transaction_id= " + transaction_id + "   *Description= " + description
				+ "   *Type_of_transaction= " + type_of_transaction + "   *Amount= " + amount + "   *Customer_id= " + customer_id +"\n";
		return s;
	}
	
	
	
	
	
}
