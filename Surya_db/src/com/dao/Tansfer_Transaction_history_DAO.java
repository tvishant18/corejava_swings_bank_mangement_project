package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bo.Transaction_info;
import com.database.DataBaseManager;

public class Tansfer_Transaction_history_DAO {
	public boolean get_transfer_transaction_insertion(Transaction_info info3){
		 boolean isvalid=false;
		 try {
			Connection connection=DataBaseManager.getconnection();
		   PreparedStatement prepare=connection.prepareStatement("INSERT INTO `suryadb`.`transfer_transaction_history` (`sender_cust_id`, `sender_acc_no`, `rec_cust_id`, `rec_acc_no`, `transfer_amount`, `date_time`) VALUES (?, ?, ?, ?, ?, ?)");
		   prepare.setInt(1, info3.getCustomer_id());
		   prepare.setInt(2, info3.getAccount_no());
		   prepare.setInt(3, info3.getReceiver_Customer_id());
		   prepare.setInt(4, info3.getReceiver_Account_no());
		   prepare.setInt(5, info3.getTransfer_amount());
		   prepare.setString(6, info3.getTransaction_date());
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
