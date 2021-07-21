package com.bank.model;
import java.util.ArrayList;
import java.util.Random;

public class Employee {
	private int id;
	private String firstName;
	private String LastName;
	private String userName;
	private String ePassword;
	private ArrayList<User> users;
	private ArrayList<Account> accounts;
	
	public Employee() {
		users = new ArrayList<User>();
	}
	public Employee(String userName) {
		this.userName = userName;
	}

	public Employee(int id, String eName, String eLastName, String epassword ) {
		super();
		this.id = id;
		this.firstName = eName;
		this.LastName = eLastName;
		this.ePassword = epassword;
		this.userName = eLastName + (new Random().nextInt(900)+100);
		this.users = new ArrayList<User>();
		this.accounts = new ArrayList<Account>();

	}
	//to database
	public Employee(String eName, String eLastName, String epassword ) {
		super();
		this.firstName = eName;
		this.LastName = eLastName;
		this.ePassword = epassword;
		this.userName = eLastName + (new Random().nextInt(900)+100);
		this.users = new ArrayList<User>();
		this.accounts = new ArrayList<Account>();

	}
	public Employee(int id, String eName, String eLastName, String userName, String epassword ) {
		super();
		this.id = id;
		this.firstName = eName;
		this.LastName = eLastName;
		this.ePassword = epassword;
		this.userName = userName;
		this.users = new ArrayList<User>();
		this.accounts = new ArrayList<Account>();

	}
	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String eFirstName) {
		this.firstName = eFirstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String eLastName) {
		this.LastName = eLastName;
	}
	
	public String getPassword() {
		return ePassword;
	}
	public void setPassword(String ePassword) {
		this.ePassword = ePassword;
	}
	public void setUserName(String username) {
		this.userName = username;
	}
	public String getUserName() {
		return userName;
	}

	@Override
	public String toString() {
		return "Hello " + this.firstName + " your idNumber=" + userName;
	}
	
	
}
