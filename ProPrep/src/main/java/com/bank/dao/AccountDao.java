package com.bank.dao;

import java.util.List;

import com.bank.model.Account;
import com.bank.model.Employee;
import com.bank.model.User;

public interface AccountDao {
	
	public List<Account> getAllAccount();
	
	
//	public Account getAccountbyUserName(int account_id);
	
	public void depostUserAmount(Account e);
	
//	void deleteUserAccount(Employee u);

	public void withdrawUserAmount(Account u);
	
//	public void viewAccount(Account a);


	public void addAmount(Account add);


	Account vewAccount(int account_id);


//	Account deleteUserAccount(int amount);


	void deleteUserAccount(Account a);

}
