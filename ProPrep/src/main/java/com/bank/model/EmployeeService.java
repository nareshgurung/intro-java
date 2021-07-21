package com.bank.model;

import java.sql.SQLException;
import java.util.ArrayList;

import com.bank.dao.EmployeeDao;
import com.bank.dao.UserDao;
import com.bank.exceptions.EmployeeAlreadyExistsException;
import com.bank.exceptions.InvalidCredentialsException;
import com.bank.logging.LoggingBankAct;

public class EmployeeService {
	private String name;
	private ArrayList<User> users;
	private ArrayList<Account> accounts;
	private ArrayList<Employee> employees;
	private EmployeeDao eDao;
	
	public EmployeeService(EmployeeDao eDao) {
		this.eDao = eDao;
	}	
	
	public Employee addEmployee(String efirstname, String elastname, String epassword)throws InvalidCredentialsException {
		Employee newUser = new Employee(efirstname, elastname, epassword);
		try {
			eDao.createEmployee(newUser);
			LoggingBankAct.logger.info("New employee has registered");
		}catch(Exception e) {
			LoggingBankAct.logger.warn("Invalid Username");
			throw new InvalidCredentialsException();
		}
		return newUser;
	}
	public Employee employeeLogin(String username, String password)throws EmployeeAlreadyExistsException, InvalidCredentialsException {
				//check user ID is correct
		
		Employee e = eDao.getEmpByUsername(username);
			if(e.getUserName().equals(username)) {
				if(e.getPassword().equals(password)) {
					System.out.println("Welcome "+ e.getFirstName());
					LoggingBankAct.logger.info("Employee has been logged in");
				return e;
				}else {
					LoggingBankAct.logger.warn("invalid input.");
					System.out.println("Invalid credentials");
				}
			System.out.println("you tried logging in that does not exist");
			throw new EmployeeAlreadyExistsException();
		}
		//if we havn't found the user or hava an incorect
		return null;
	}
	public Employee vieUserAccount(String username) throws InvalidCredentialsException {
		
		Employee user =eDao.viewUserAccount(username);
		return user;
	}
	
}
