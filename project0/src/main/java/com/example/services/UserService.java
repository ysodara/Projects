package com.example.services;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.example.dao.CustomerDao;
import com.example.dao.UserDao;

import com.example.exceptions.InvalidCredentialsException;
import com.example.exceptions.UserDoesNotExistException;
import com.example.exceptions.UserNameAlreadyExistsException;
import com.example.logging.Logging;
import com.example.models.Customer;
import com.example.models.User;

public class UserService {
	private UserDao uDao;
	private CustomerDao cDao;
	
	public UserService(UserDao u, CustomerDao c) {
		this.uDao = u;
		this.cDao = c;
	}
	
	public User signUp(String first, String last, String email, String password) throws UserNameAlreadyExistsException{
		User u = new User(first, last, email, password);
		
		
		 
		try {
			uDao.createUser(u);
			User createdUser = uDao.getUserByUsername(u.getUsername());
			
			Customer c = new Customer("Customer", createdUser.getId());
			
			System.out.println(createdUser.getId());
			cDao.createCustomer(c);
			Logging.logger.info("New user has registered");
		} catch(SQLException e) {
			Logging.logger.warn("Username created that already exists in the database");
			throw new UserNameAlreadyExistsException();
		}
		
		return u;
	}
}
