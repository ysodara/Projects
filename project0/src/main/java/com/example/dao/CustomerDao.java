package com.example.dao;

import java.sql.SQLException;
import java.util.List;

import com.example.models.Customer;

public interface CustomerDao {
	List<Customer> getAllCustomers();
	
	Customer getCustomersByUsername(String username);
	
	void createCustomer(Customer c) throws SQLException;
	
	void updateCustomer(Customer c);
	
	void deleteCustomer(Customer c);
}
