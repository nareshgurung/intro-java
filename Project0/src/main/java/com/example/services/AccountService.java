package com.example.services;
import com.example.models.Accounts;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import com.example.dao.FileIO;
import com.example.exceptions.InvalidCredentialsException;
import com.example.exceptions.UserDoesNotExistException;


public class AccountService {

	private String file;
	private FileIO<Accounts> io;

public AccountService(String file) {
	this.file = file;
	this.io = new FileIO<Accounts>(file);
}
public List<Accounts> getAllBalance() {
	List<Accounts> acct;
	try {
		acct = io.readObject();
	}catch(FileNotFoundException e) {
		acct = new ArrayList<Accounts>();
	}catch(Exception e) {
		acct = null;
		e.printStackTrace();
	}
	return acct;
}
public void addBalance(Accounts amount) {
	ArrayList<Accounts> acct;
	try {
		acct= io.readObject();
	}catch(FileNotFoundException e) {
		acct = new ArrayList<Accounts>();
	}catch(Exception e) {
		e.printStackTrace();
		return;
	}

	acct.add(amount);
	io.writeObject(acct);
	}	
}

