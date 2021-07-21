package com.example.dao;

import java.sql.SQLException;
import java.util.List;

import com.example.models.Transaction;

public interface TransactionDao {
	
	List<Transaction> getAllTransaction();
	void createTransaction(Transaction t) throws SQLException;
}
