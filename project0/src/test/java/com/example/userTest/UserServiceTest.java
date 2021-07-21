package com.example.userTest;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.example.dao.AccountDao;
import com.example.dao.AccountDaoDB;
import com.example.dao.CustomerDao;
import com.example.dao.CustomerDaoDB;
import com.example.dao.EmployeeDao;
import com.example.dao.EmployeeDaoDB;
import com.example.dao.SendMoneyDao;
import com.example.dao.SendMoneyDaoDB;
import com.example.dao.UserDao;
import com.example.dao.UserDaoDB;
import com.example.models.Customer;
import com.example.models.SendMoney;
import com.example.models.User;
import com.example.services.UserService;

public class UserServiceTest {
	

	@InjectMocks
	public UserService uServ;
	
	@Mock
	public UserDao uDao;
	public CustomerDao cDao;
	public SendMoneyDao sDao;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testValidLogin() {
		User user1 = new User(1,"firstName", "lastName", "email", "username", "password", "role");
		User not = new User(0,"firstName", "lastName", "email","username", "password", "role");
		
		when(uDao.getUserByUsername(anyString())).thenReturn(user1);
		
		User loggedIn = uServ.signIn("username", "password");
		
		assertEquals(user1.getId(), loggedIn.getId());
	}
	
	@Test
	public void testEmptyGetAllUsers() {
		List<User> userList = uServ.getAllUsers();
		assertEquals("The list should have no users", 0, userList.size());
	}
	
	
	
	
}
