package com.example.models;

public class AllUserAccount {
	private String firstName;
	private String lastName;
	private String username;
	private int account_id;
	private String accountName;
	private boolean status;
	
	public AllUserAccount () {
		
	}
	public AllUserAccount (String firstName, String lastName, String username, int account_id, String accountName, boolean status) {
		this.firstName = firstName;
		this.lastName =lastName;
		this.username = username;
		this.account_id = account_id;
		this.accountName = accountName;
		this.status = status;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "AllUserAccount [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", account_id=" + account_id + ", accountName=" + accountName + ", status=" + status + "]";
	}
	
	
}
