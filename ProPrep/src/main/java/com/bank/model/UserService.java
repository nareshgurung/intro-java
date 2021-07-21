package com.bank.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import com.bank.dao.AccountDao;
import com.bank.dao.AccountDaoDB;
import com.bank.dao.EmployeeDao;
import com.bank.dao.UserDao;
import com.bank.exceptions.InvalidCredentialsException;
import com.bank.exceptions.UserDoesNotExistException;
import com.bank.exceptions.UserNameAlreadyExistsException;
import com.bank.logging.LoggingBankAct;

public class UserService {
	
	private String name;
	private ArrayList<User> users;
	private ArrayList<Account> accounts;
	private ArrayList<Employee> employees;
	private UserDao uDao;
	
	public UserService(UserDao usr) {
		this.uDao = usr;
	}
	public UserService(String name) {
		this.name = name;
		this.users = new ArrayList<User>();
		this.accounts = new ArrayList<Account>();
		this.employees = new ArrayList<Employee>();
	}

	
	// account uuid
	
//	public void AddAccount(Account anAcct) {
//		this.accounts.add(anAcct);
//	}
	
	public User addUser(String firstName, String lastName, String password) throws UserNameAlreadyExistsException {
		//create a new User object and add it to our list
		User newUser = new User(firstName, lastName, password);
		uDao.createUser(newUser);	
		
		return newUser;
	}
	
	public User userLogin(String userID, String password) throws UserDoesNotExistException, InvalidCredentialsException{
		
		User u = uDao.getUserByUsername(userID);
			//check user ID is correct
			if(u.getUserName().equals(userID)) {
				if(u.getPassword().equals(password)) {
					LoggingBankAct.logger.info("user was logged in");						
			}else {
				LoggingBankAct.logger.warn("User tried to login with invalid credentials");
				throw new InvalidCredentialsException();
		}
			}
			return u;
	}

	// delete user is not working 
	public User deleteUser(String name, String last, String username) throws InvalidCredentialsException {	
		User u = new User(name, last, username);
	try {
		uDao.deleteUser(u);
		LoggingBankAct.logger.info("Your Account has been deleted");
		System.out.println("-user-Your Account has been deleted");
		
	}catch(Exception e) {
		e.printStackTrace();
		LoggingBankAct.logger.warn("invalid credentials.");
	}
	//update the fund
	return u;
}
}


