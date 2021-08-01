package com.example.db.repository;


	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;

	import com.example.db.connection.*;
	import com.example.db.entity.*;

	public class TransferRepositoryImpl implements TransferRepository {

		public void save(Transfer transfer) {
			Connection con = null;
			try {
				con = ConnectionFactory.getConnection();
				String sql = "insert into transfer values (?,?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(sql);

				ps.setInt(1, transfer.getTransactionId());
				ps.setInt(2, transfer.getAccount());
				ps.setTimestamp(3, transfer.getDateAndTime());
				ps.setInt(4, transfer.getAmount());
				ps.setString(5, transfer.getCreditOrDebit());

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

		public List<Transfer> getTransfers() {
			Connection con = null;

			List<Transfer> transferList = new ArrayList<Transfer>();

			try {
				con = ConnectionFactory.getConnection();

				String sql = "select * from transfer";

				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);

				while (rs.next()) {
					Transfer transfer = new Transfer();
					transfer.setTransactionId(rs.getInt(1));
					transfer.setAccount(rs.getInt(2));
					transfer.setDateAndTime(rs.getTimestamp(3));
					transfer.setAmount(rs.getInt(4));
					transfer.setCreditOrDebit(rs.getString(5));
					transferList.add(transfer);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			return transferList;
		}

		public List<Transfer> getTransfers(int limit) {
			Connection con = null;

			List<Transfer> transferList = new ArrayList<Transfer>();

			try {
				con = ConnectionFactory.getConnection();

				String sql = "select * from transfer order by trans_id desc limit "+limit;

				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);

				while (rs.next()) {
					Transfer transfer = new Transfer();
					transfer.setTransactionId(rs.getInt(1));
					transfer.setAccount(rs.getInt(2));
					transfer.setDateAndTime(rs.getTimestamp(3));
					transfer.setAmount(rs.getInt(4));
					transfer.setCreditOrDebit(rs.getString(5));
					transferList.add(transfer);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			return transferList;
		}
		
		public List<Transfer> getTransfers(String fromDate, String toDate) {
			Connection con = null;

			List<Transfer> transferList = new ArrayList<Transfer>();

			try {
				con = ConnectionFactory.getConnection();

				String sql = "select * from transfer where date_n_time >= \'"+fromDate+"\' and date_n_time <= \'"+toDate+"\'";

				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);

				while (rs.next()) {
					Transfer transfer = new Transfer();
					transfer.setTransactionId(rs.getInt(1));
					transfer.setAccount(rs.getInt(2));
					transfer.setDateAndTime(rs.getTimestamp(3));
					transfer.setAmount(rs.getInt(4));
					transfer.setCreditOrDebit(rs.getString(5));
					transferList.add(transfer);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			return transferList;
		}

	}

