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
		public void addAccount(Account acct) {
			try {
				Connection con = conUtil.getConnection();
				String sql = "INSERT INTO users(String holder_username, Strimg checking_account_id, String saving_account_id) values"
						+ "(?,?)";
				PreparedStatement ps = con.prepareStatement(sql);
				
				ps.setString(1, acct.getHolderUserName());
				ps.setString(2, acct.getCheckingAccount());
				ps.setString(3, acct.getSavingAccount());

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
					act.setCheckingAccount(rs.getString(2));
					act.setSavingAccount(rs.getString(3));
					
				}
				return act;
				
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

}
