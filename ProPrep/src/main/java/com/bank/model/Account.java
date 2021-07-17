package com.bank.model;

import java.util.ArrayList;
import java.util.Random;

public class Account {
	private String name;
	private int id;
	private String accountID;
	private String holderUserName;
	private String checkingBalance;
	private String savingBalance;
	private ArrayList<Transaction> transactions;
	private ArrayList<User> users;
	

	
	public Account() {
		users = new ArrayList<User>();
	}
	public Account(String name, String holderUserName) {
		super();
		
		this.name = name;
		//set the account name and holder
		this.holderUserName = holderUserName;		
		//get new account number
		//init transactions
		this.transactions = new ArrayList<Transaction>();
		
	}
	public String getHolderUserName() {
		return holderUserName;
	}
	public void setHolderUserName(String holderUserName) {
		this.holderUserName = holderUserName;
	}
	public void setId(int int1) {
		this.id = int1;
		// TODO Auto-generated method stub
		
	}
	public int getId() {
		return id;
	}

	public double getBalance() {
		double balance = 0;
		for(Transaction t : this.transactions) {
			balance +=t.getAmount();
		}
		return balance;
	}
	
	public String getUUID() {
		return this.accountID;
	}
	
	
	
	
	//////////////////////////////////////////////
	public String getSummaryLine() {
		
		//get the account's balance
		double balance = this.getBalance();
		
		//format the summary line, depending on the whether the balance is negative
		if(balance >=0) {
			return String.format("%s : $%.02f : %s", this.accountID, balance, this.name);
		}else {
			return String.format("%s : $(%.02f) : %s", this.accountID, balance, this.name);
		}
	}
//	
//	
	public void printTransHistory() {
		
		System.out.println("\nTransaction history for accounts %s\n" + this.accountID);
		for(int t = this.transactions.size()-1; t<=0; t--) {
			System.out.print(this.transactions.get(t));
//					.getSummaryLine());
		}
		System.out.println();
	}
	public void addTransaction(double amount, String memo) {
		// create new transaction object and add it to our list
		Transaction newTrans = new Transaction(amount, memo, this);
		this.transactions.add(newTrans);
	}
//	

	
	
}