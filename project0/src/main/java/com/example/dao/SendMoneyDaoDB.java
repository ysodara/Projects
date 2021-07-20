package com.example.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.example.models.SendMoney;
import com.example.models.Transaction;
import com.example.utils.ConnectionUtil;

public class SendMoneyDaoDB implements SendMoneyDao {
	ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();
	@Override
	public void createSendMoney(SendMoney s) throws SQLException {
		Connection con = conUtil.getConnection();
		String sql = "INSERT INTO sendMoney( description, status, amount, sender_customer_id, reciever_customer_id) values"
				+ "(?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		
		
		ps.setString(1, s.getDescription());
		ps.setBoolean(2, s.isStatus());
		ps.setDouble(3, s.getAmount());
		ps.setInt(4, s.getSender_customer_id());
		ps.setInt(5, s.getReviever_customer_id());
		
		
		ps.execute();
		
	}

	@Override
	public void updateSendMoney(SendMoney s) {
		try {
			Connection con = conUtil.getConnection();
			String sql = "UPDATE sendMoney SET status = ?"
					+ " WHERE sendMoney_id = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			
			ps.setBoolean(1, s.isStatus());
			ps.setInt(2, s.getSendMoney_id());

			
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<SendMoney> getAllIncomingMoneyByCustomerID(int recieverID) {
		List<SendMoney> sendMoney = new ArrayList<SendMoney>();
		
		try {
			Connection con = conUtil.getConnection();
			con.setAutoCommit(false);
			String sql = "{?=call get_customer_incoming_money(?)}";
			
			CallableStatement cs = con.prepareCall(sql);
			
			cs.registerOutParameter(1, Types.OTHER);
			cs.setInt(2, recieverID);
			
			cs.execute();
			
			ResultSet rs = (ResultSet) cs.getObject(1);
			
			while(rs.next()) {
				SendMoney sm = new SendMoney(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getDouble(4), rs.getInt(5), rs.getInt(6));
				sendMoney.add(sm);
			}
			
			
			
			con.setAutoCommit(true);
			return sendMoney;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
