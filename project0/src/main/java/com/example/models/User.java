package com.example.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class User {
	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	private String password;
	private String role;
	//private List<Account> accounts;
	
	public User() {
		//accounts = new ArrayList<Account>();
	}
	
//	public User(int id, String firstName, String lastName, String email, String password, String role) {
//		this.id = id;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.username = firstName + lastName + (new Random().nextInt(9000) + 1000);
//		this.email = email;
//		this.password = password;
//		this.role = role;
//		//this.accounts = new ArrayList<Account>();
//	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	//For sending to database, no need ID
	public User(String firstName, String lastName, String email, String password, String role) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = firstName + lastName + (new Random().nextInt(9000) + 1000);
		this.email = email;
		this.password = password;
		this.role = role;
		//this.accounts = new ArrayList<Account>();
	}
	
	//User to get user info from the database
	public User(int id, String firstName, String lastName, String email, String username, String password, String role) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
		//this.accounts = new ArrayList<Account>();
		}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		String printUserInfo = "Full name: " + firstName + " " + lastName+ "\nUsername: " + username+ "\nEmail: " + email +"\nRole; " +role;
		return printUserInfo;
	}



	
	

}
