package com.example.userTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.dao.FileIO;
import com.example.dao.UserDao;
import com.example.exceptions.UserDoesNotExistException;
import com.example.models.User;
import com.example.services.UserService;


import com.example.models.User;
public class UserServiceTest {
	
	@InjectMocks
	public UserService uServ;
	
	@Mock 
	public UserDao uDao;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testValidLogin() {
		User u1 = new User("test", "user", "testuser", "test@email.com", "testpass");
		User not = new User(1, "test", "user", "testuser", "test@email.com", "testpass");
	}
	
	when(uDao.getUserByUsername(anyString())).thenReturn(u1);
	
	User loggedIn = uServ.signIn("testuser", "testpass");
	
	assertEquals(u1.getId(), loggedIn.getId());
	
}
@Test(expected = UserDoesNotExistException).class

public void testInvalidUsername() {
	User u1 = new User("test", "user", "testuser", "test@email.com", "testpass");
	User not = new User(1, "test", "user", "testuser", "test@email.com", "testpass");
	
	when(uDao.getUserByUsername(anyString())).thenReturn(not);
	
	User loggedIn = uServ.signIn("testuser", "testpass");
}

}

