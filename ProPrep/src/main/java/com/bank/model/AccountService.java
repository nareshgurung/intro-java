package com.bank.model;

import java.util.ArrayList;

import com.bank.dao.AccountDao;
import com.bank.dao.EmployeeDao;
import com.bank.exceptions.InvalidAmountException;
import com.bank.exceptions.InvalidCredentialsException;
import com.bank.exceptions.UserDoesNotExistException;
import com.bank.exceptions.UserNameAlreadyExistsException;
import com.bank.exceptions.AccountDoesNotExistException;
import com.bank.logging.LoggingBankAct;

public class AccountService {
	private String name;
	private ArrayList<User> users;
	private ArrayList<Account> accounts;
	private ArrayList<Employee> employees;
	private AccountDao aDao;
	
	public AccountService(AccountDao aDao) {
		this.aDao = aDao;
	}
	
	public Account addDeposit(int accountID, int balance) throws InvalidCredentialsException  {
		Account add = new Account(accountID, balance);
		if(balance>=0) {
			aDao.depostUserAmount(add);
			System.out.println( "Your amount $" + balance + " has been deposit");
			LoggingBankAct.logger.info("User deposit the amount");
			return add;
		}else {
			System.out.println("Invallid deposit");
			throw new InvalidAmountException();
		}
	}
	
	public Account withdrawAmount(int account_id, int amount) throws InvalidAmountException, AccountDoesNotExistException{
		if( amount> 0){
			Account withdraw = new Account(account_id, amount);
			aDao.withdrawUserAmount(withdraw);
			System.out.println("your balance has been deducted $ "+ amount);
			return withdraw;
		}else {
			System.out.println("you are not able to withdraw. ");
			LoggingBankAct.logger.warn("Invalid withdrawl");
			throw new InvalidAmountException();
		}
	}
	public Account transferAmount(int accountIdA, int accountIdB, int amount) throws AccountDoesNotExistException{
		try {
			Account sub = new Account(accountIdA, amount);
			aDao.withdrawUserAmount(sub);
			Account add = new Account (accountIdB, amount);
			aDao.depostUserAmount(add);
			System.out.println("Your $"+ amount +" seccefully transfered to account no."+ accountIdB);	
		}catch(Exception e) {
			LoggingBankAct.logger.warn("User provided invalid credentials");
			System.out.println();
			throw new AccountDoesNotExistException();
		}
		
		return null;
	}
	public Account viewAccount(int account_id)throws AccountDoesNotExistException {
		Account a = aDao.vewAccount(account_id);
		return a;
	}

	public Account deletAccount(int unumber)throws InvalidCredentialsException {
		Account num = new Account(unumber);
		return null;
	}
	
}
