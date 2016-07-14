package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bo.Transaction_info;
import com.database.DataBaseManager;

public class Credit_transaction_history_insertion_DAO {
public boolean get_transaction_insertion(Transaction_info info){
	 boolean isvalid=false;
	 try {
		Connection connection=DataBaseManager.getconnection();
	   PreparedStatement prepare=connection.prepareStatement("INSERT INTO `suryadb`.`credit_transaction_history` (`customer_id`, `account_no`, `credit_amount`, `date_time`) VALUES (?, ?, ?,?)");
	   prepare.setInt(1, info.getCustomer_id());
	   prepare.setInt(2, info.getAccount_no());
	   prepare.setInt(3, info.getCredit_amount());
	   prepare.setString(4, info.getTransaction_date());
	   int execute=prepare.executeUpdate();
	   if(execute>0){
		   isvalid=true;
	   }
	 } catch (SQLException e) {
		e.printStackTrace();
	}
	return isvalid;
}
}
