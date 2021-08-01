package com.example.db.repository;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	import com.example.db.connection.ConnectionFactory;

	public class AccountRepositoryDbimpl implements AccountRepositoryDb{

		public boolean check(int account) {
			boolean flag = false;
			Connection con = null;
			try {
				con = ConnectionFactory.getConnection();
				
				String sql = "select count(*) from Account where accountNumber= "+account;
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				rs.next();
				int count = rs.getInt(1);
				if(count == 1)
				{
					flag = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return flag;
		}

		public void update(int accountNumber,int balance) {
			Connection con = null;
			try {
				con = ConnectionFactory.getConnection();
				
				String sql = "update Account set  accountBalance = ? where accountNumber = ?";
				PreparedStatement ps = con.prepareStatement(sql);
				
				ps.setInt(1, balance);
				ps.setInt(2, accountNumber);
				
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		public int balance(int account) {
			int amount = 0;
			Connection con = null;
			try {
				con = ConnectionFactory.getConnection();
				
				String sql = "select  accountBalance from Account where accountNumber = "+account;
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				rs.next();
				amount = rs.getInt(1);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return amount;
		}

	}

