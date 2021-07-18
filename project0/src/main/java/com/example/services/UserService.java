package com.example.services;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.example.dao.AccountDao;
import com.example.dao.CustomerDao;
import com.example.dao.UserDao;

import com.example.exceptions.InvalidCredentialsException;
import com.example.exceptions.UserDoesNotExistException;
import com.example.exceptions.UserNameAlreadyExistsException;
import com.example.logging.Logging;
import com.example.models.Account;
import com.example.models.Customer;
import com.example.models.User;

public class UserService {
	private UserDao uDao;
	private CustomerDao cDao;
	private AccountDao aDao;
	
	public UserService(UserDao u, CustomerDao c, AccountDao a) {
		this.uDao = u;
		this.cDao = c;
		this.aDao = a;
	}
	
	public Customer signUp(String first, String last, String email, String password) throws UserNameAlreadyExistsException{
		User u = new User(first, last, email, password); 
		try {
			uDao.createUser(u);
			User createdUser = uDao.getUserByUsername(u.getUsername());			
			Customer c = new Customer("Customer", createdUser.getId());
			cDao.createCustomer(c);
			c = cDao.getCustomersByUsername(u.getUsername());
			Logging.logger.info("New user has registered");
			return c;
		} catch(SQLException e) {
			Logging.logger.warn("Username created that already exists in the database");
			throw new UserNameAlreadyExistsException();
		}
		//return null;
	}
	
	public Customer bankAccoutRegistration(Customer newUser, String accountName, double startBalance) {		
		Customer newCustomer = newUser;
		System.out.println(newUser.getCustomer_id());
		Account a = new Account (accountName, false, startBalance, newUser.getCustomer_id());
		System.out.println(a);
		try {
			aDao.createAccount(a);			
			Logging.logger.info("New account has registered");
		} catch(SQLException e) {
			Logging.logger.warn("Username created that already exists in the database");
			throw new UserNameAlreadyExistsException();
		}
		return newCustomer;		
	}
	
	public Customer signIn(String username, String password) throws UserDoesNotExistException, InvalidCredentialsException{
		
		User u = uDao.getUserByUsername(username);
		Customer customer = cDao.getCustomersByUsername(username);
		if(u.getId() == 0) {
			Logging.logger.warn("User tried loggging in that does not exist");
			throw new UserDoesNotExistException();
		}
		else if(!u.getPassword().equals(password)) {
			Logging.logger.warn("User tried to login with invalid credentials");
			throw new InvalidCredentialsException();
		}
		else {
			Logging.logger.info("User was logged in");
			return customer;
		}
	}
	
	
}
