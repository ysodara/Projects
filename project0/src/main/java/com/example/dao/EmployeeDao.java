package com.example.dao;

import java.sql.SQLException;
import java.util.List;

import com.example.models.Employee;

public interface EmployeeDao {
	List<Employee> getAllEmployees();
	
	Employee getEmployeeByUsername(String username);
	
	void createEmployee(Employee e) throws SQLException;
	
	void updateEmployee(Employee e);
	
	void deleteEmployee(Employee e);
}
