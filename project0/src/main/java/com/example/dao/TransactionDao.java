package com.example.dao;

import java.sql.SQLException;

import com.example.models.Transaction;

public interface TransactionDao {
	void createTransaction(Transaction t) throws SQLException;
}
