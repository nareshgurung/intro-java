package com.bank.exceptions;

public class UserNameAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public UserNameAlreadyExistsException() {
		super("A username was aready exists in the database");
	}
}
