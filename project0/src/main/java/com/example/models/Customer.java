package com.example.models;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private int customer_id;
	private int user_id;
	private String role;
	private List<Account> accounts;
	
	public Customer() {
		accounts = new ArrayList<Account>();
	}
	
	public Customer(int customer_id, String role, int user_id) {
		this.customer_id = customer_id;
		this.user_id = user_id;
		this.role = role;
		accounts = new ArrayList<Account>();
	}
	
	public Customer(String role, int user_id) {
		this.user_id = user_id;
		this.role = role;
		accounts = new ArrayList<Account>();
	}
	
	


	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	
	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", user_id=" + user_id + ", role=" + role + ", accounts="
				+ accounts + "]";
	}
	
	
	
}
