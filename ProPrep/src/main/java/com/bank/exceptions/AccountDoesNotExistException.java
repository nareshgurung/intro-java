package com.bank.exceptions;

public class AccountDoesNotExistException extends RuntimeException {

private static final long serialVersionUID = 1L;
	
	public AccountDoesNotExistException() {
		super("User provided invalid account");
	}
}
