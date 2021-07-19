package com.example.models;

public class Employee {
	private int employee_id;
	private int user_id;
	
	public Employee () {
		
	}
	
	public Employee (int employee_id, String role, int user_id) {
		this.employee_id = employee_id;
		this.user_id = user_id;
		
	}
	
	public Employee ( String role, int user_id) {
		this.user_id = user_id;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	

	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", user_id=" + user_id + "]";
	}
	
	
	
	
}
