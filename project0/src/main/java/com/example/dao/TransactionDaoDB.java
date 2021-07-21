package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.models.Transaction;
import com.example.models.User;
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

	@Override
	public List<Transaction> getAllTransaction() {
		List<Transaction> lists = new ArrayList<>();
		try {
			Connection con = conUtil.getConnection();
			
			String sql = "SELECT * FROM transactions";
			
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while (rs.next()) {
				lists.add(new Transaction(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getInt(6)));
			}
			return lists;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
