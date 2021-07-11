package com.example.services;
import com.example.dao.UserDaoMock;
import com.example.exceptions.InvalidCredentialsException;
import com.example.exceptions.UserDoesNotExistException;
import com.example.exceptions.UserNameAlreadyExists;
import com.example.logging.Logging;

import java.util.List;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.example.dao.FileIO;
import com.example.dao.UserDao;
import com.example.models.Account;
import com.example.models.User;



import com.example.models.User;
public class UserService {
	
	private String file;
	private FileIO<User> io;
	
	public UserService(String file) {
		this.file = file;
		this.io = new FileIO<User>(file);
	}
	public User signUp(String first, String last, String password) {
		ArrayList<User> users;
		try {
			users = io.readObject();
		}catch(FileNotFoundException e) {
			System.out.println("Creating a blank users array");
			users = new ArrayList<User>();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		User u = new User(first, last, password);
		
		//check to see if the users username is already stored somewhere
		for(int i=0; i<users.size(); i++) {
			if(users.get(i).getUserName().equals(u.getUserName())) {
				Logging.logger.warn("Username created that already exists in the database");
				throw new UserNameAlreadyExists();
			}
		}
		users.add(u);
		io.writeObject(users);
		return u;
		
}
	public User login(String username, String password) {
		ArrayList<User> users;
		try {
			users = io.readObject();
		}catch(FileNotFoundException e) {
			users = new ArrayList<User>();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		// we first want to loop through our users list to see if we can mathc a username
		for(int i=0; i<users.size(); i++) {
			//if the username exits in the file , we then want to check the password
			if(users.get(i).getUserName().equals(username)) {
				if(users.get(i).getPassword().equals(password)){
					System.out.println("You are signed in");
					return users.get(i);
				}else{
					Logging.logger.warn("User tried logging in with invalid credentials");
					throw new InvalidCredentialsException();
					}
				}
		}
		Logging.logger.warn("User tried logging in that does not exist");
		throw new UserDoesNotExistException();
	}
	public List<User> getAllUsers(){
		ArrayList<User> users;
		try {
			users = io.readObject();
		}catch(Exception e) {
			users = new ArrayList<User>();
		}
		return users;
	}
}
