package com.example.dao;

import java.sql.SQLException;
import java.util.List;

import com.example.models.Account;

public interface AccountDao {
	List<Account> getAllAccounts();
	
	Account getAccountByUsername(String username);
	
	void createAccount(Account a) throws SQLException;
	
	void updateAccount(Account a);
	
	void deleteAccount(Account a);
}
