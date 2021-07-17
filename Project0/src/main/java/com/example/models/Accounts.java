package com.example.models;

import java.io.Serializable;
import java.util.Random;

public class Accounts implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int balance;
	private String accountNumber;
	private String holder;
	public Accounts(String holder, int balance) {
		super();
		this.holder = holder;
		this.accountNumber = "ACCT" + (new Random().nextInt(9000)+1000);
//		this.deposit = deposit;
		this.balance = balance;
	}


	public int getBalance() {
		return balance;
	}



	public void setBalance(int balance) {
		this.balance +=balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getHolder() {
		return holder;
	}
	public void setHolder(String holder) {
		this.holder = holder;
	}
	
	@Override
	public String toString() {
		return "Accounts [balance=" + balance + ", accountNumber= " + accountNumber
				+ holder +"]";
	}
	
}
