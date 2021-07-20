package com.bank.model;

import java.util.ArrayList;

import com.bank.dao.AccountDao;
import com.bank.dao.EmployeeDao;

public class AccountService {
	private String name;
	private ArrayList<User> users;
	private ArrayList<Account> accounts;
	private ArrayList<Employee> employees;
	private AccountDao aDao;
	
	public AccountService(AccountDao aDao) {
		this.aDao = aDao;
	}
	
	public Account addDeposit(int accountID, int balance) {
		if(balance>=0) {
			Account add = new Account(accountID, balance);
			aDao.addAmount(add);
			System.out.println( "Your amount $" + balance + " has been deposit");
			return add;
		}else {
			System.out.println("Invallid deposit");
		}
		return null;
	}
	
	public Account withdrawAmount(int account_id, int amount) {
		if( amount> 0){
			Account withdraw = new Account(account_id, amount);
			aDao.withdrawUserAmount(withdraw);
			System.out.println("your balance has been deducted $ "+ amount);
			return withdraw;
		}else {
			System.out.println("you are not able to withdraw. ");
		}
		return null;
	}
	public Account transferAmount(int accountIdA, int accountIdB, int amount) {
		try {
			Account sub = new Account(accountIdA, amount);
			aDao.withdrawUserAmount(sub);
			Account add = new Account (accountIdB, amount);
			aDao.depostUserAmount(add);
			System.out.println("Your $"+ amount +"seccefully transfered to account no."+ accountIdB);	
		}catch(Exception e) {
			System.out.println();
		}
		
		return null;
	}
	public Account viewAccount(int account_id) {
		Account a =new  Account(account_id);
		aDao.viewAccount(a);
		return a;
	}
	
}
