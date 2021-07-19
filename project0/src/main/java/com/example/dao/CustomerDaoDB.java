package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.models.Customer;
import com.example.models.User;
import com.example.utils.ConnectionUtil;

public class CustomerDaoDB implements CustomerDao{
	ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();
	@Override
	public List<Customer> getAllCustomers() {
		
		List<Customer> customerList = new ArrayList<Customer>();
		
		try {
			Connection con = conUtil.getConnection();
			//To create a simple statment we write our query as a string
			String sql = "SELECT * FROM customers";
			
			//We need to create a statement with this sql string
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				customerList.add(new Customer(rs.getInt(1), rs.getInt(2)));
			}
			
			return customerList;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public User getCustomersByCustomerId (int customerId) {
		User u = new User();
		
		try {
			Connection con = conUtil.getConnection();
			
			String sql = "select * from users u inner join customers c on u.id = c.user_id where c.customer_id  ='" + customerId + "'";
			
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				u.setId(rs.getInt(1));
				u.setFirstName(rs.getString(2));
				u.setLastName(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setUsername(rs.getString(5));
				u.setPassword(rs.getString(6));
				u.setRole(rs.getString(7));
			}
			return u;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public Customer getCustomersByUsername(String username) {
		Customer customer = new Customer();
		
		try {
			Connection con = conUtil.getConnection();
			
			String sql = "select c.customer_id, c.user_id from users u inner join customers c on u.id=c.user_id where u.username ='" + username + "'";
			
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				customer.setCustomer_id(rs.getInt(1));
				customer.setUser_id(rs.getInt(2));
			}
			return customer;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void createCustomer(Customer c) throws SQLException {
		Connection con = conUtil.getConnection();
		String sql = "INSERT INTO customers(user_id) values"
				+ "(?)";
		PreparedStatement ps = con.prepareStatement(sql);
		
		
		ps.setInt(1, c.getUser_id());
		
		ps.execute();
		
		
	}

	@Override
	public void updateCustomer(Customer c) {
		try {
			Connection con = conUtil.getConnection();
			String sql = "UPDATE customers SET user_id = ?"
					+ " WHERE customer_id = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			
			ps.setInt(1, c.getUser_id());
			ps.setInt(2, c.getCustomer_id());

			
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteCustomer(Customer c) {
		try {
			
			Connection con = conUtil.getConnection();
			String sql = "DELETE FROM customers WHERE customer_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, c.getCustomer_id());
			
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
