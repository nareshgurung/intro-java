package com.bank.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import com.bank.dao.AccountDao;
import com.bank.dao.AccountDaoDB;
import com.bank.dao.EmployeeDao;
import com.bank.dao.UserDao;

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
	
	public void AddAccount(Account anAcct) {
		this.accounts.add(anAcct);
	}
	
	public User addUser(String firstName, String lastName, String password) {
		//create a new User object and add it to our list
		User newUser = new User(firstName, lastName, password);
		uDao.createUser(newUser);	
		
		return newUser;
	}
	public User removeUser(String userName) {
		Iterator itr = users.iterator();
		while(itr.hasNext()) {
			if(itr.equals(userName)) {
				itr.remove();
			}
		}
		return null;
	}
	public User userLogin(String userID, String password) {
		
		User u = uDao.getUserByUsername(userID);
			//check user ID is correct
			if(u.getUserName().equals(userID)) {
				if(u.getPassword().equals(password)) {
						System.out.println("you are logged in ");
				}
			}else {
				System.out.println("invalid Credentials");
			}
			return u;
	}
	public String getName() {
		return name;
	}


	@Override
	public String toString() {
		return "Bank of Shine";
	}


	
	// delete user is not working 
	public User deleteUser(String name, String last, String username) {	
		User u = new User(name, last, username);
		uDao.deleteUser(u);
	
			System.out.println("Your Account has been deleted");
		return u;
	}
	//update the fund
	
}


