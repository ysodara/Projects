package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.example.models.Employee;
import com.example.utils.ConnectionUtil;

public class EmployeeDaoDB implements EmployeeDao {
	ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployeeByUsername(String username) {
		Employee empyloyee = new Employee();
		try {
			Connection con = conUtil.getConnection();
			
			String sql = "select e.employee_id, e.user_id from users u inner join employees e on u.id = e.user_id where u.username ='" + username + "'";
			
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				empyloyee.setEmployee_id(rs.getInt(1));
				empyloyee.setUser_id(rs.getInt(2));
			}
			return empyloyee;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void createEmployee(Employee e) throws SQLException {
		Connection con = conUtil.getConnection();
		String sql = "INSERT INTO employees(user_id) values"
				+ "(?)";
		PreparedStatement ps = con.prepareStatement(sql);
		
		
		ps.setInt(1, e.getUser_id());
		
		ps.execute();
	}

	@Override
	public void updateEmployee(Employee e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployee(Employee e) {
		// TODO Auto-generated method stub
		
	}

	

}
