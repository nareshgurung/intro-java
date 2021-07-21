package com.bank.exceptions;

public class InvalidAmountException extends RuntimeException {

private static final long serialVersionUID = 1L;
	
	public InvalidAmountException() {
		super("User provided invalid amount");
	}
}
