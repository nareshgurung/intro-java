package com.bank.model;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class User {
	private int id;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private int checkingAccount;
	private int savingAccount;
	private ArrayList<Account> accounts;
	private ArrayList<User> users;
	private ArrayList <Employee> emp;
	
	public User() {
		accounts = new ArrayList<Account>();
		users = new ArrayList<User>();
		emp = new ArrayList<Employee>();
	}
	
	public User(int id, String firstName, String lastName, String password) {
		this.id =id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password =password;
		this.userName = firstName + (new Random().nextInt(900)+ 1000);
		this.checkingAccount = (new Random().nextInt(900)+ 1000);
		this.savingAccount= (new Random().nextInt(900)+ 1000);
		//create empty list of accounts
		this.accounts = new ArrayList<Account>();
		}
	//send user info
	public User(String firstName, String lastName, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.password =password;
		this.userName = firstName + (new Random().nextInt(900)+ 1000);
		this.checkingAccount = (new Random().nextInt(900)+ 1000);
		this.savingAccount = (new Random().nextInt(900)+ 1000);
		//create empty list of accounts
		this.accounts = new ArrayList<Account>();
		}
	//user to get user info
	public User(int id, String firstName, String lastName, String username, String password, int cId, int sId) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password =password;
		this.userName = username;
		this.checkingAccount = cId;
		this.savingAccount = sId;
			
		//create empty list of accounts
		this.accounts = new ArrayList<Account>();
		}
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setPassword(String password) {
		this.password =password;
	}
	public String getPassword() {
		return this.password;
	}
	public void setCheckingAccount(int account) {
		this.checkingAccount = account;
	}
	public int getCheckingAccount() {
		// TODO Auto-generated method stub
		return checkingAccount;
	}
	public void setSavingAccount(int account) {
		this.savingAccount = account;
	}
	public int getSavingAccount() {
		// TODO Auto-generated method stub
		return savingAccount;
	}
	
	@Override
	public String toString() {
		return "User Name: " + firstName + ", " + lastName + " with ID- " + userName;
	}
	
}