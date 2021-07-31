package com.example.services;

import com.example.dao.UserDao;
import com.example.exceptions.InvalidCredentialsException;
import com.example.exceptions.UserDoesNotExistException;
import com.example.logging.Logging;
import com.example.models.User;

public class UserService {
	private UserDao uDao;
	
	
	public UserService(UserDao udao) {
		this.uDao = udao;
	}
	
	public User signIn(String username, String password) throws UserDoesNotExistException, InvalidCredentialsException{
		User u = uDao.selectUserByUsername(username);
		if(u.getId() == 0) {
			Logging.logger.warn("User tried logging in that does not exist");
			throw new UserDoesNotExistException();
		}
		if(!u.getPassword().equals(password)) {
			Logging.logger.warn("User tried to login with invalid credentials");
			throw new InvalidCredentialsException();
		}
		else {
			Logging.logger.info("User was logged in");
			return u;
		}
	}
}
