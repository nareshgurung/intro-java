package com.bank.model;

import java.util.ArrayList;

import com.bank.dao.EmployeeDao;
import com.bank.dao.UserDao;

public class EmployeeService {
	private String name;
	private ArrayList<User> users;
	private ArrayList<Account> accounts;
	private ArrayList<Employee> employees;
	private EmployeeDao eDao;
	
	public EmployeeService(EmployeeDao eDao) {
		this.eDao = eDao;
	}	
	
	public Employee addEmployee(String efirstname, String elastname, String epassword) {
		Employee newUser = new Employee(efirstname, elastname, epassword);
		eDao.createEmployee(newUser);
		return newUser;
	}
	public Employee employeeLogin(String username, String password) {
				//check user ID is correct
		
		Employee e = eDao.getEmpByUsername(username);
			if(e.getUserName().equals(username)) {
				if(e.getPassword().equals(password)) {
					System.out.println("Welcome ");
				return e;
				}else {
					System.out.println("Invalid credentials");
				}
			System.out.println("you tried logging in that does not exist");
		}
		//if we havn't found the user or hava an incorect
		return null;
	}
	
}
