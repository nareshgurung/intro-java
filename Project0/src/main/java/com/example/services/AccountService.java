package com.example.services;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.dao.FileIO;
import com.example.exceptions.InvalidCredentialsException;
import com.example.exceptions.UserDoesNotExistException;
import com.example.models.Account;
import com.example.models.User;
public class AccountService {

	private String file;
	private FileIO<Account> io;

public AccountService(String file) {
	this.file = file;
	this.io = new FileIO<Account>(file);
}
public List<Account> getAllBalance() {
	List<Account> acct;
	try {
		acct = io.readObject();
	}catch(FileNotFoundException e) {
		acct = new ArrayList<Account>();
	}catch(Exception e) {
		acct = null;
		e.printStackTrace();
	}
	return acct;
}
public void addBalance(Account a) {
	ArrayList<Account> acct;
	try {
		acct= io.readObject();
	}catch(FileNotFoundException e) {
		acct = new ArrayList<Account>();
	}catch(Exception e) {
		e.printStackTrace();
		return;
	}

	acct.add(a);
	io.writeObject(acct);
	}	
}

//public User login(String username, String password) {
//	ArrayList<Account> users;
//	try {
//		users = io.readObject();
//	}catch(FileNotFoundException e) {
//		users = new ArrayList<User>();
//	}catch(Exception e) {
//		e.printStackTrace();
//		return null;
//	}
	
	// we first want to loop through our users list to see if we can mathc a username
//	for(int i=0; i<users.size(); i++) {
//		//if the username exits in the file , we then want to check the password
//		if(users.get(i).getUserName().equals(username)) {
//			if(users.get(i).getPassword().equals(password)){
//				System.out.println("You are signed in");
//				return users.get(i);
//			}else{
//				throw new InvalidCredentialsException();
//				}
//			}
//	}
//	throw new UserDoesNotExistException();
//}
//public List<User> getAllUsers(){
//	ArrayList<User> users;
//	try {
//		users = io.readObject();
//	}catch(Exception e) {
//		users = new ArrayList<User>();
//	}
//	return users;
//}
//
//}

