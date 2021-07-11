package com.example.dao;

import com.example.models.User;

public interface UserDao {
	
	User getUserByUserName(String username);
	User addUser(User u);
	
}
