package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bo.Transaction_info;
import com.database.DataBaseManager;

public class Reciever_getcredit_transfer_DAO {
	  public static int initial_balance3;
	    public static int final_balance3;
		public boolean autheticate_reciever_transfer(Transaction_info info3){
			boolean isvalid=false;
			try {
				Connection connection=DataBaseManager.getconnection();
				PreparedStatement prepare=connection.prepareStatement("SELECT * FROM suryadb.account_statement where customer_id=? and account_no=? ");
			    prepare.setInt(1, info3.getReceiver_Customer_id());
			    prepare.setInt(2, info3.getReceiver_Account_no());
			    ResultSet result3=prepare.executeQuery();
			    while(result3.next()){
			    	isvalid=true;
			    	initial_balance3=result3.getInt(3);
			    }
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return isvalid;
			
		}
		public boolean get_new_balance(Transaction_info info3){
			boolean isvalid=false;
			final_balance3=initial_balance3+info3.getTransfer_amount();
			try {
				Connection connection=DataBaseManager.getconnection();
				PreparedStatement prepare=connection.prepareStatement("UPDATE `suryadb`.`account_statement` SET `balance`=?, `last_credit_transaction`=?, `last_credit_transaction_date`=? WHERE `customer_id`=? ");
			    prepare.setInt(1,final_balance3);
			    prepare.setInt(2, info3.getTransfer_amount());
			    prepare.setString(3, info3.getTransaction_date());
			    prepare.setInt(4, info3.getReceiver_Customer_id());
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
