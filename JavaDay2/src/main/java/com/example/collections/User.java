package com.example.collections;

import java.util.Random;

public class User implements Comparable<User> {
	private String name;
	private String lastName;
	private String userName;
	private String password;
	
	public User(String name, String lastName, String password) {
		this.name = name;
		this.lastName = lastName;
		this.userName = name + lastName + (new Random().nextInt(9000)+1000);
		this.password = password;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "fullname: " + name +" " + lastName + " username: "+ userName + " password: "+ password; 
	}
	
	@Override 
	public int compareTo(User o) {
		if(this.userName.compareTo(o.userName)> 0) {
			return 1;
		}else if(this.userName.compareTo(o.userName)<0) {
			return -1;
		}else {
			return 0;
		}
	}
}
