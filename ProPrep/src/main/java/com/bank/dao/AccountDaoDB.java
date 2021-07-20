package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bank.model.Account;
import com.bank.model.Employee;
import com.bank.util.ConnectionUtil;

public class AccountDaoDB implements AccountDao {

	ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();

	@Override
	public List<Account> getAllAccount() {
		List<Account> aList = new ArrayList<Account>();
		
		try {
			Connection con = conUtil.getConnection();
			String sql = "SELECT * FROM accounts";
			
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				aList.add(new Account(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
			}
			return aList;
			}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Account getAccountbyUserName(int account_id) {
		
		Account acct = new Account();
		try {
		Connection con = conUtil.getConnection();
		String sql = "SELECT * FROM accounts WHERE accounts.account_number = '" +account_id+"'";
		
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(sql);
		
		while(rs.next()) {
			acct.setId(rs.getInt(1));
			acct.setAccountID(rs.getInt(2));
			acct.setBalance(rs.getInt(3));
		}
		return acct;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public void addAmount(Account e) {
		try {
			Connection con = conUtil.getConnection();
			String sql = "INSERT INTO accounts(balance, account_number) values"
					+ "(?,?)";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, e.getAccountID());
			ps.setInt(2,  e.getBalance());
			ps.execute();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	@Override
	public void depostUserAmount(Account e) {
		
		try {
		Connection con = conUtil.getConnection();
		String sql = "UPDATE accounts SET balance =balance+? WHERE account_number= ?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, e.getAccountID());
		ps.setInt(2,  e.getBalance());
		ps.execute();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		
	}
	@Override
	public void withdrawUserAmount(Account u) {
		
		try {
			Connection con = conUtil.getConnection();
			String sql = "UPDATE accounts SET balance =balance-? WHERE account_number= ?";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, u.getAccountID());
			ps.setInt(2,  u.getBalance());
			ps.execute();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public void viewAccount(Account a) {
		
		try {
			Connection con = conUtil.getConnection();
			String sql = "SELECT * FROM accounts WHERE account_number = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, a.getAccountID());
			ps.setInt(2,  a.getBalance());
			ps.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUserAccount(Employee u) {
		// TODO Auto-generated method stub
		
	}


}

//	@Override
//	public void createEmployee(Employee u) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void transerAmount(Account e) {
//		Connection con = conUtil.getConnection();
//		String sql = "UPDATE accounts SET balance=balance-"+amt+" where acid +"+ 
//		



