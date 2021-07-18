package com.bank.dao;

import java.util.List;

import com.bank.model.Employee;
import com.bank.model.User;

public interface EmployeeDao {
	
	public List<Employee> getAllemployees();
	
	public List<User> getAllUsers();
	
	 public Employee getEmpByUsername(String username);
	
	public void transferFund(Employee u);
	
	void deleteUserAccount(Employee u);

	public void createEmployee(Employee u);
}
