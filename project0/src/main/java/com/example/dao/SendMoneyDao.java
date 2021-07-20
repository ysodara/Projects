package com.example.dao;

import java.sql.SQLException;
import java.util.List;

import com.example.models.SendMoney;



public interface SendMoneyDao {
	void createSendMoney(SendMoney s) throws SQLException;
	
	void updateSendMoney(SendMoney s);
	
	List<SendMoney> getAllIncomingMoneyByCustomerID(int recieverID);
}
