package com.bank.dao;

import java.util.List;

import com.bank.model.Account;
import com.bank.model.User;

public interface AccountDao {

	
	public List<Account> getAllAccount();
	public User getUserAccount();

	void addAccount(Account acct);
	
	
}
