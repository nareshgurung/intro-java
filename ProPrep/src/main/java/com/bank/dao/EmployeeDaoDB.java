package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.bank.model.Employee;
import com.bank.model.User;
import com.bank.util.ConnectionUtil;

public class EmployeeDaoDB implements EmployeeDao {

	ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();
	@Override
	public List<Employee> getAllemployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmpByUsername(String username) {
			Employee emp = new Employee();
		
		try {
			Connection con = conUtil.getConnection();
			
			String sql = "SELECT * FROM employee WHERE employee.username = '" + username + "'";
			
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				emp.setId(rs.getInt(1));
				emp.setFirstName(rs.getString(2));
				emp.setLastName(rs.getString(3));
				emp.setUserName(rs.getString(4));
				emp.setPassword(rs.getString(5));
			}
			return emp;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void transferFund(Employee u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserAccount(Employee u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createEmployee(Employee e) {
		try {
			Connection con = conUtil.getConnection();
			String sql = "INSERT INTO employee(first_name, last_name, username, password) values"
					+ "(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, e.getFirstName());
			ps.setString(2, e.getLastName());
			ps.setString(3, e.getUserName());
			ps.setString(4, e.getPassword());
			
			ps.execute();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
			
		
	}

}
