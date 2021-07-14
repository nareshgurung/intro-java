package com.example.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Account implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer accountNumber;
	private double deposit;
//	private double withdrawal;
	private double currentBalance;
	private String balance;
//	private ArrayList<User> users;
	
	public Account(double deposit, int accountNumber) {
		this.deposit = deposit;
//		this.withdrawal = withdrawal;
//		this.currentBalance = balance;
		this.accountNumber = new Random().nextInt(9000);
	}
	public Account (String inAmount) {
		super();
		this.balance =inAmount;
	}
	public Integer getAccountNumber() {
		return accountNumber;
	}
	
	public double getDeposit() {
		return deposit;
	}
	public void setDeposit(double deposit) {
		this.currentBalance = deposit + currentBalance;
	}
//	public double getWithdrawal() {
//		return withdrawal;
//	}
//	public void setWithdrawal(double withdrawal) {
//		this.currentBalance = currentBalance - withdrawal;
//	}
	public double getBalance() {
		return currentBalance;
	}
	public void setBalance(double balance) {
		this.currentBalance = balance;
	}
	@Override
	public String toString() {
		return "AccountService: accountNumber=" + accountNumber + "\n, currentBalance=" + currentBalance;
	}
}
