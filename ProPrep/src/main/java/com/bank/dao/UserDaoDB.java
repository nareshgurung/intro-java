package com.bank.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.bank.model.User;

import com.bank.util.ConnectionUtil;

public class UserDaoDB implements UserDao {

	ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();
	
	public List<User> getAllUsers(){
		List<User> userList = new ArrayList<User>();
		
		try {
			Connection con = conUtil.getConnection();
			String sql = "SELECT * FROM users";
			
			//We need to create a statement with this sql
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				userList.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
			return userList;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getUserByUsername(String username) {
		User user = new User();
		
		try {
			Connection con = conUtil.getConnection();
			
			String sql = "SELECT * FROM users WHERE  users.username = '" + username + "'";
			
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				user.setId(rs.getInt(1));
				user.setFirstName(rs.getString(2));
				user.setLastName(rs.getString(3));
				user.setUserName(rs.getString(4));
				user.setPassword(rs.getString(5));
				user.setCheckingAccount(rs.getInt(6));
				user.setSavingAccount(rs.getInt(7));
			}
			return user;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void createUser(User u) {
		
		//callable statement
		try {
			Connection con = conUtil.getConnection();
			//To use our functions/procedure we need to turn off autocommit
			con.setAutoCommit(false);
			String sql = "call create_post(?,?,?,?,?,?)";
			CallableStatement cp = con.prepareCall(sql);
			
			cp.setString(1, u.getFirstName());
			cp.setString(2, u.getLastName());
			cp.setString(3, u.getUserName());
			cp.setString(4,  u.getPassword());
			cp.setInt(5, u.getCheckingAccount());
			cp.setInt(6, u.getSavingAccount());
			cp.execute();
			
			con.setAutoCommit(true);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		//Prepared Statements
//		try {
//			Connection con = conUtil.getConnection();
//			String sql = "INSERT INTO users(first_name, last_name, username, password, ch_account_id, sv_account_id) values"
//					+ "(?,?,?,?,?,?)";
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setString(1, u.getFirstName());
//			ps.setString(2, u.getLastName());
//			ps.setString(3, u.getUserName());
//			ps.setString(4,  u.getPassword());
//			ps.setInt(5, u.getCheckingAccount());
//			ps.setInt(6, u.getSavingAccount());
//			
//			ps.execute();
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//		
	}

	@Override
	public void updateUser(User u) {
	try {
		Connection con = conUtil.getConnection();
		String sql = "UPDATE users SET first_name =?, last_name =?, password=?, ch_account_id =?, sv_account_id=?"
				+ " WHERE users.id =?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, u.getFirstName());
		ps.setString(2, u.getLastName());
		ps.setString(3, u.getUserName());
		ps.setString(4, u.getPassword());
		ps.setInt(4, u.getCheckingAccount());
		ps.setInt(4, u.getSavingAccount());
		
		ps.execute();
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
		
	}

	@Override
	public void deleteUser(User u) {
		try {
			
			Connection con = conUtil.getConnection();
			String sql = "DELETE FROM users WHERE users.first_name = ? AND users.last_name = ? AND users.username = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, u.getId());
			ps.setString(2, u.getFirstName());
			ps.setString(3, u.getLastName());
			ps.setString(4, u.getUserName());
			
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
