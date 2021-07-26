package com.example.models;

enum Role
{
    EMPLOYEE, MANAGER;
}

public class UserRole {
	
	private Role userRole;
	
	public UserRole () {
		
	}
	
	public UserRole (Role role) {
		this.userRole = role;
	}
	
	public Role getUserRole() {
		return userRole;
	}
	
	public void setUserRole(int roleID) {
		switch(roleID) {
		case 1:
			this.userRole = Role.EMPLOYEE;
			break;
		case 2:
			this.userRole = Role.MANAGER;
			break;
		}
		
	}
	
	public void roleIsWho() {
		if (userRole!=null) {
			switch (userRole) {
				case EMPLOYEE: {
					System.out.println("They are an Employee");
					break;
				}
				case MANAGER: {
					System.out.println("They are a Manager");
					break;
				}
			}
		}
		else {
			System.out.println("This user role is NULL.");
		}
		
	}
	
	
	
}
