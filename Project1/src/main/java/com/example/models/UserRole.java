package com.example.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_roles")
public class UserRole {
	@Id
	@Column(name="user_role_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userRoleId;
	
	@Column(name="user_role", unique=true, nullable=false)
	private String userRole;
	
	public UserRole () {		
	}

	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}	
}
