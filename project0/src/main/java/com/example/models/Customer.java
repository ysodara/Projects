package com.example.models;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private int customer_id;
	private int user_id;
	private List<Account> accounts;
	
	public Customer() {
		accounts = new ArrayList<Account>();
	}
	
	public Customer(int customer_id, int user_id) {
		this.customer_id = customer_id;
		this.user_id = user_id;
		accounts = new ArrayList<Account>();
	}
	
	public Customer(int user_id) {
		this.user_id = user_id;
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


	public List<Account> getAccounts() {
		return accounts;
	}
	
	public List<Account> getActiveAccounts() {
		List<Account> temp = new ArrayList<Account>();
		for (int i = 0 ; i < accounts.size() ; i++) {
			if (accounts.get(i).isApproval_status()) {
				temp.add(accounts.get(i));
			}
		}
		return temp;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	public void printUserAllAccount() {
		int check = 0;
		for (int i = 0; i < this.accounts.size(); i++) {
			if (accounts.get(i).isApproval_status()) {
			System.out.println((i+1)+ ": "+accounts.get(i));
			check++;
			}
		} 
		if (check < 1) {
			check++;
			System.out.println("All of your accounts are under reviewing");
		}
	}
	
	public boolean checkActiveAccounts() {
		boolean check = false;
		
		for (int i = 0 ; i < accounts.size() ; i++) {
			if (accounts.get(i).isApproval_status()) {
				check = true;
			}
		}
		return check;
	}
	
	@Override
	public String toString() {
		return ""+accounts;
	}
	
	
	
}
