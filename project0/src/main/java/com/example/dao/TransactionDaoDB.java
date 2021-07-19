package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.example.models.Transaction;
import com.example.utils.ConnectionUtil;

public class TransactionDaoDB implements TransactionDao {
	ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();
	
	@Override
	public void createTransaction(Transaction t) throws SQLException {
		Connection con = conUtil.getConnection();
		String sql = "INSERT INTO transactions(description, type_of_transaction, amount,customer_id, account_id) values"
				+ "(?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		
		
		ps.setString(1, t.getDescription());
		ps.setString(2, t.getType_of_transaction());
		ps.setDouble(3, t.getAmount());
		ps.setInt(4, t.getCustomer_id());
		ps.setInt(5, t.getAccount_id());
		
		
		ps.execute();
		
		
	}
}
