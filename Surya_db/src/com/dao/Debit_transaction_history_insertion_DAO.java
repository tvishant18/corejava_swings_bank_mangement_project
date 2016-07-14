package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bo.Transaction_info;
import com.database.DataBaseManager;

public class Debit_transaction_history_insertion_DAO {
	public boolean get_transaction_insertion(Transaction_info info1){
		 boolean isvalid=false;
		 try {
			Connection connection=DataBaseManager.getconnection();
		   PreparedStatement prepare=connection.prepareStatement("INSERT INTO `suryadb`.`debit_transaction_history` (`customer_id`, `account_no`, `debit_amount`, `date_time`) VALUES (?, ?, ?, ?)");
           prepare.setInt(1,info1.getCustomer_id());
           prepare.setInt(2, info1.getAccount_no());
           prepare.setInt(3, info1.getDebit_amount());
           prepare.setString(4, info1.getTransaction_date());
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
