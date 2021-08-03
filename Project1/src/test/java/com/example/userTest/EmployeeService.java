package com.example.userTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.example.dao.ReimburstmentDao;
import com.example.dao.UserDao;
import com.example.exceptions.InvalidCredentialsException;
import com.example.exceptions.UserDoesNotExistException;
import com.example.exceptions.UserNameAlreadyExistsException;
import com.example.models.User;
import com.example.models.UserRole;
import com.example.services.UserService;


public class EmployeeService {

	@InjectMocks
	public EmployeeService eServ;
	
	@Mock
	public UserDao uDao;
	@Mock
	private ReimburstmentDao rDao;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testValidSubmit() {
//		UserRole role = new UserRole(1,"EMPLOYEE");
//		User newUser = new User(1,"firstName", "lastName", "email", "username", "password", role);
//		User not = new User(0,"firstName", "lastName", "emails","username", "password", role);
//		
//		Mockito.doNothing().when(uDao).insert((not));
//		
//		when(uDao.selectUserByEmail(anyString())).thenReturn(null);
//		
//		when(uDao.selectUserByUsername(anyString())).thenReturn(newUser);
		
		
		//User loggedIn = uServ.signUp("firstName", "lastName", "email", "password");
		
		//assertEquals(newUser.getId(), loggedIn.getId());
	}
	
//	@Test
//	public void testValidSignup() throws UserDoesNotExistException, InvalidCredentialsException, UserNameAlreadyExistsException, SQLException {
//		UserRole role = new UserRole(1,"EMPLOYEE");
//		User newUser = new User(1,"firstName", "lastName", "email", "username", "password", role);
//		User not = new User(0,"firstName", "lastName", "emails","username", "password", role);
//		
//		Mockito.doNothing().when(uDao).insert((not));
//		
//		when(uDao.selectUserByEmail(anyString())).thenReturn(null);
//		
//		when(uDao.selectUserByUsername(anyString())).thenReturn(newUser);
//		
//		
//		User loggedIn = uServ.signUp("firstName", "lastName", "email", "password");
//		
//		assertEquals(newUser.getId(), loggedIn.getId());
//	}
}
