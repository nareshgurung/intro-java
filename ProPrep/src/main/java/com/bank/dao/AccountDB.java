package com.bank.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.bank.model.Account;
import com.bank.model.User;
import com.bank.util.ConnectionUtil;

public class AccountDB implements AccountDao {

		ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();
		
		@Override
		public void addAccount(Account name) {
			List<User> users = new ArrayList<User>();
			try {
				Connection con = conUtil.getConnection();
				String sql = "INSERT INTO users(String user_name, checking_balance, String saving_balance) values"
						+ "(?,?, ?) WHERE users.username = '"+ name + "'";
				PreparedStatement ps = con.prepareStatement(sql);
				
				ps.setString(1, name.getHolderUserName());
				ps.setDouble(2, name.getCheckingBalance());
				ps.setDouble(3, name.getSavingBalance());

				ps.execute();
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
		}

		@Override
		public List<Account> getAllAccount(String username) {
			Account act = new Account();
			
			try {
				Connection con = conUtil.getConnection();
				
				String sql = "SELECT * FROM users WHERE users.username = '" + username + "'";
				
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);
				
				while(rs.next()) {
					act.setId(rs.getInt(1));
					act.setCheckingBalance(rs.getString(2));
					act.setSavingBalance(rs.getString(3));
					
				}
				return null;
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			return null;
		}

		@Override
		public User getUserAccount() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Account> getAllAccount() {
			// TODO Auto-generated method stub
			return null;
		}

}
