package com.example.exceptions;

public class UserNameAlreadyExists extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	public UserNameAlreadyExists() {
		super("A username was aready exists in the database");
	}
}
