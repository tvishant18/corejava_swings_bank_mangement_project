package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bo.Transaction_info;
import com.database.DataBaseManager;

public class Deposit_money_DAO {
    public static int initial_balance;
    public static int final_balance;
	public boolean autheticate_deposit(Transaction_info info){
		boolean isvalid=false;
		try {
			Connection connection=DataBaseManager.getconnection();
			PreparedStatement prepare=connection.prepareStatement("SELECT * FROM suryadb.account_statement where customer_id=? and account_no=? ");
		    prepare.setInt(1, info.getCustomer_id());
		    prepare.setInt(2, info.getAccount_no());
		    ResultSet result2=prepare.executeQuery();
		    while(result2.next()){
		    	isvalid=true;
		    	initial_balance=result2.getInt(3);
		    }
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return isvalid;
		
	}
	public boolean get_new_balance(Transaction_info info){
		boolean isvalid=false;
		final_balance=initial_balance+info.getCredit_amount();
		try {
			Connection connection=DataBaseManager.getconnection();
			PreparedStatement prepare=connection.prepareStatement("UPDATE `suryadb`.`account_statement` SET `balance`=?, `last_credit_transaction`=?, `last_credit_transaction_date`=? WHERE `customer_id`=? ");
		    prepare.setInt(1,final_balance);
		    prepare.setInt(2, info.getCredit_amount());
		    prepare.setString(3, info.getTransaction_date());
		    prepare.setInt(4, info.getCustomer_id());
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
