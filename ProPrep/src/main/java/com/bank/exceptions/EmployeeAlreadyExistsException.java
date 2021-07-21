package com.bank.exceptions;

public class EmployeeAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public EmployeeAlreadyExistsException() {
		super("A Employee was aready exists in the database");
	}
}
