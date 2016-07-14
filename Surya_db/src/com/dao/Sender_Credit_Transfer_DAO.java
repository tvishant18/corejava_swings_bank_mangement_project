package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bo.Transaction_info;
import com.database.DataBaseManager;

public class Sender_Credit_Transfer_DAO {
	public static int initial_balance2;
    public static int final_balance2;

	public boolean autheticate_debit(Transaction_info info3){
		boolean isvalid=false;
		try {
			Connection connection=DataBaseManager.getconnection();
			PreparedStatement prepare=connection.prepareStatement("SELECT * FROM suryadb.account_statement where customer_id=? and account_no=? ");
		    prepare.setInt(1, info3.getCustomer_id());
		    prepare.setInt(2, info3.getAccount_no());
		    ResultSet result2=prepare.executeQuery();
		    while(result2.next()){
		    	isvalid=true;
		    	initial_balance2=result2.getInt(3);
		    }
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return isvalid;
		
	}
	public boolean get_new_balance1(Transaction_info info3){
		boolean isvalid=false;
		final_balance2=initial_balance2-info3.getTransfer_amount();
		if(final_balance2>0){
		try {
			Connection connection=DataBaseManager.getconnection();
			PreparedStatement prepare=connection.prepareStatement("UPDATE `suryadb`.`account_statement` SET `balance`=?, `last_debit_transaction`= ?, `last_debit_transaction_date`=? WHERE `customer_id`=?");
		    prepare.setInt(1,final_balance2);
		    prepare.setInt(2, info3.getTransfer_amount());
		    prepare.setString(3, info3.getTransaction_date());
		    prepare.setInt(4, info3.getCustomer_id());
		    int execute=prepare.executeUpdate();
		    if(execute>0){
		    	isvalid=true;
		    	
		    }
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		}
		else{
			isvalid=false;
		}
		return isvalid;
	}
		   
		   



}