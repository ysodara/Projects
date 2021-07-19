package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.models.Account;
import com.example.models.Customer;
import com.example.utils.ConnectionUtil;

public class AccountDaoDB implements AccountDao {
	ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();
	@Override
	public List<Account> getAllAccounts() {
		List<Account> accountList = new ArrayList<Account>();
		
		try {
			Connection con = conUtil.getConnection();
			//To create a simple statment we write our query as a string
			String sql = "SELECT * FROM accounts";
			
			//We need to create a statement with this sql string
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				accountList.add(new Account(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getDouble(4), rs.getInt(5)));
			}
			
			return accountList;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Account> getAccountByUsername(String username) {
		Account account = new Account();
		List<Account> accountList = new ArrayList<Account>();
		try {
			Connection con = conUtil.getConnection();			
			Statement s = con.createStatement();			
			String sql = "select a.account_id, a.\"name\", a.approval_status, a.current_balance, a.customer_id from users u "
					+ "inner join customers c on  u.id=c.user_id inner join accounts a  on a.customer_id = c.customer_id where u.username ='" + username + "'";
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				accountList.add(new Account(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getDouble(4), rs.getInt(5)));
			}
			return accountList;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void createAccount(Account a) throws SQLException {
		Connection con = conUtil.getConnection();
		String sql = "INSERT INTO accounts(name, approval_status, current_balance, customer_id) values"
				+ "(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, a.getName());
		ps.setBoolean(2, a.isApproval_status());
		ps.setDouble(3, a.getCurrent_balance());
		ps.setInt(4, a.getCustomer_id());
		
		ps.execute();
		
	}

	@Override
	public void updateAccount(Account a) {
		try {
			Connection con = conUtil.getConnection();
			String sql = "UPDATE accounts SET name = ? , approval_status = ?, current_balance = ?, customer_id = ?"
					+ " WHERE account_id = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, a.getName());
			ps.setBoolean(2, a.isApproval_status());
			ps.setDouble(3, a.getCurrent_balance());
			ps.setInt(4, a.getCustomer_id());
			ps.setInt(5, a.getAccount_id());

			
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteAccount(Account a) {
		try {
			
			Connection con = conUtil.getConnection();
			String sql = "DELETE FROM accounts WHERE account_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, a.getAccount_id());
			
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
