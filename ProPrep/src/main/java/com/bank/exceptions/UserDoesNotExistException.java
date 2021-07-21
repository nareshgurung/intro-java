package com.bank.exceptions;

public class UserDoesNotExistException extends RuntimeException {

private static final long serialVersionUID = 1L;
	
	public UserDoesNotExistException() {
		super("user tried logging in with credentials that don't exist");
	}
}
