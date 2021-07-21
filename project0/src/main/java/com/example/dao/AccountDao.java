package com.example.dao;

import java.sql.SQLException;
import java.util.List;

import com.example.models.Account;
import com.example.models.AllUserAccount;

public interface AccountDao {
	List<Account> getAllAccounts();
	
	List<Account> getAccountByUsername(String username);
	
	public List<AllUserAccount> getAllUserAccounts();
	
	void createAccount(Account a) throws SQLException;
	
	boolean updateAccount(Account a);
	
	void deleteAccount(Account a);
	
	public boolean ModifyStatus(boolean status, int id);
}
