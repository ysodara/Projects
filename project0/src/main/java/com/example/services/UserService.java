package com.example.services;

import java.io.FileNotFoundException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.example.dao.AccountDao;
import com.example.dao.CustomerDao;
import com.example.dao.EmployeeDao;
import com.example.dao.SendMoneyDao;
import com.example.dao.SendMoneyDaoDB;
import com.example.dao.UserDao;
import com.example.dao.TransactionDao;
import com.example.dao.TransactionDaoDB;
import com.example.exceptions.InvalidCredentialsException;
import com.example.exceptions.UserDoesNotExistException;
import com.example.exceptions.UserNameAlreadyExistsException;
import com.example.logging.Logging;
import com.example.models.Account;
import com.example.models.Customer;
import com.example.models.Employee;
import com.example.models.SendMoney;
import com.example.models.Transaction;
import com.example.models.User;

public class UserService {
	private UserDao uDao;
	private CustomerDao cDao;
	private AccountDao aDao;
	private EmployeeDao eDao;
	
	public UserService(UserDao u, CustomerDao c, AccountDao a,EmployeeDao e) {
		this.uDao = u;
		this.cDao = c;
		this.aDao = a;
		this.eDao = e;
	}	
	public Customer signUp(String first, String last, String email, String password) throws UserNameAlreadyExistsException{		
		User u = new User(first, last, email, password, "Customer");
		//System.out.println(u.getUsername());
		Customer nullCustomer = null;
		User temp = uDao.getUserByUsername(u.getUsername());
		System.out.println(temp.getEmail());		
			try {
			uDao.createUser(u);
			User createdUser = uDao.getUserByUsername(u.getUsername());			
			
			Customer c = new Customer(createdUser.getId());
			cDao.createCustomer(c);
			c = cDao.getCustomersByUsername(u.getUsername());
			Logging.logger.info("New user has registered");
			return c;
			
			} catch(SQLException e) {
			Logging.logger.warn("Username created that already exists in the database");
			System.out.println("Email created that already exists in the database");
			System.out.println("Please choose a different Email.");
			return nullCustomer;
			}		
	}
	
	public User getUserbyCustomerId (int cutomerId) {
		User u = cDao.getCustomersByCustomerId(cutomerId);
		
		return u;
	}
	public User signIn(String username, String password) throws UserDoesNotExistException, InvalidCredentialsException{
		User u = uDao.getUserByUsername(username);		
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
			return u;
		}
	}	
	public List<SendMoney> acceptMoney(int customerID) {
		SendMoneyDao sDao = new SendMoneyDaoDB();
		
		List<SendMoney> list = sDao.getAllIncomingMoneyByCustomerID(customerID);
		
		List<SendMoney> validList = new ArrayList<>();
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).isStatus()) {
				
			} else {
				validList.add(list.get(i));
			}
		}

		
		return validList;
		
	}
	public void acceptMoney(Customer c, int accountID, double amount) {
		SendMoneyDao sDao = new SendMoneyDaoDB();
		
		

		
		
		
	}
	public Customer sendMoney (Customer c, double currentBalance, String recieverUsername, double amountToSend, int choice) {
		//Check customer
		//check username
		//check amount
		
		Customer recieverCustomer = cDao.getCustomersByUsername(recieverUsername);
		SendMoneyDao sDao = new SendMoneyDaoDB();
		SendMoney moneyToSend =  new SendMoney("None", false, amountToSend, c.getCustomer_id(), recieverCustomer.getCustomer_id());
		
		double updateBalance = currentBalance  - amountToSend;
		Account accountToUpdate = c.getAccounts().get(choice);
		accountToUpdate.setCurrent_balance(updateBalance);
		
		try {
			sDao.createSendMoney(moneyToSend);
			uploadTransaction(amountToSend, "Send Out", c, c.getAccounts().get(choice).getAccount_id());
			boolean succeed = aDao.updateAccount(accountToUpdate);
			Logging.logger.info("New SendMoney has registered");
		} catch(SQLException e) {
			Logging.logger.warn("SendMoney already exists in the database");
			throw new UserNameAlreadyExistsException();
		}
		
		return null;
	}
	public void uploadTransaction(double amount, String typeOfTransaction , Customer c, int account_id) {
		TransactionDao tDao = new TransactionDaoDB();
		Transaction t = new Transaction("No description", typeOfTransaction, amount, c.getCustomer_id() , account_id);
		try {
			tDao.createTransaction(t);			
			Logging.logger.info("New Transaction has registered");
		} catch(SQLException e) {
			Logging.logger.warn("Transaction already exists in the database");
			throw new UserNameAlreadyExistsException();
		}
		
	}
	public Customer bankAccoutRegistration(Customer user, String accountName, double startBalance) {		
		Customer newCustomer = user;
		User getUserName = getUserbyCustomerId(user.getCustomer_id());
		user.setAccounts(aDao.getAccountByUsername(getUserName.getUsername()));
		boolean check = true;
		for (int i = 0; i < user.getAccounts().size(); i++ ) {
			if (user.getAccounts().get(i).getName().equals(accountName) | user.getAccounts().get(i).getName()==accountName) {
				check = false;
			} 
		}
		if (user.getCustomer_id() == 0) {
			check = false;
			System.out.println("Customer is not in the database");
		}
		if (check) {
		Account a = new Account (accountName, false, startBalance, user.getCustomer_id());
		
			try {
				aDao.createAccount(a);			
				Logging.logger.info("New account has registered");
			} catch(SQLException e) {
				Logging.logger.warn("Username created that already exists in the database");
				throw new UserNameAlreadyExistsException();
			}
		}else {
			System.out.println("Account name is already exists in your account."
					+ "\nPlease choose different name."); 
			return newCustomer;	 
			}
		return newCustomer;	
		
	}
	
	public Customer customerSignIn(String username) throws UserDoesNotExistException, InvalidCredentialsException{
		Customer customer = cDao.getCustomersByUsername(username);
		return customer;
		
	}
	
	public Employee employeeSignIn(String username, String code) throws UserDoesNotExistException, InvalidCredentialsException{	
		Employee employee = eDao.getEmployeeByUsername(username);
		return employee;
	}
	
	
//	public Employee signUp(String first, String last, String email, String password, String code) throws UserNameAlreadyExistsException{
//	
//	User u = new User(first, last, email, password, "Employee"); 
//	if (code.equals("RevaturePro")) {
//		try {
//		uDao.createUser(u);
//		User createdUser = uDao.getUserByUsername(u.getUsername());			
//		Employee e = new Employee("Employee", createdUser.getId());
//		eDao.createEmployee(e);
//		e = eDao.getEmployeeByUsername(u.getUsername());
//		Logging.logger.info("New user has registered");
//		return e;
//		} catch(SQLException e) {
//		Logging.logger.warn("Username created that already exists in the database");
//		throw new UserNameAlreadyExistsException();
//		}
//	}else {
//		System.out.println("Sorry, wrong code.");
//		return null;
//	}
//}
	
}
