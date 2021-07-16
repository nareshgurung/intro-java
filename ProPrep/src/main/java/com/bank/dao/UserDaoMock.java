package com.bank.dao;

import java.util.ArrayList;
import java.util.List;

import com.bank.model.User;

public class UserDaoMock implements UserDao {
	
	private List<User> users = new ArrayList<User>();
	
	public UserDaoMock() {
		
	}
	

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByUsername(String username) {
		for(int i = 0; i<users.size(); i++) {
			User u = users.get(i);
			if(u.getUserName().equals(username)) {
				return u;
			}
		}
		return null;
	}

	@Override
	public void createUser(User u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(User u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(User u) {
		// TODO Auto-generated method stub
		
	}

}
