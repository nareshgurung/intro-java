package com.bank.model;

import java.util.ArrayList;
import java.util.Random;

public class Account{
	private int id;
	private int accountID;
	private int balance;
	private ArrayList<User>users;
	private ArrayList<Account> accounts;
	private ArrayList<Employee> employees;
	public Account() {
		users = new ArrayList<User>();
		employees = new ArrayList<Employee>();
		accounts = new ArrayList<Account>();
	}
	//initialization
	public Account(int accountId) {
		////.id = id;
		this.accountID = accountId;
		this.balance = balance;
		this.accounts = new ArrayList<Account>();
	}
	//push to base
	public Account(int balance, int accountID) {
		this.balance = balance;
		this.accountID = accountID;
		this.accounts = new ArrayList<Account>();
	}
	public Account(int id, int accountID, int balance) {
		this.id = id;
		this.accountID = accountID;
		this.balance = balance;
		this.accounts = new ArrayList<Account>();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAccountID() {
		return accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public ArrayList<User> getUsers() {
		return users;
	}
	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	public ArrayList<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}
	public ArrayList<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}
	
	
}

















