package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bo.Customer_info;
import com.database.DataBaseManager;

public class Account_Statement_DAO1 {
	public boolean authenticate_statement(Customer_info customer1){
		boolean isvalid=false;
		
		try {
			Connection connection=DataBaseManager.getconnection();
			PreparedStatement prepare=connection.prepareStatement("select  customer_id,balance from suryadb.account_statement where customer_id=? and account_no=?");
			prepare.setInt(1, customer1.getCustomer_id());
			prepare.setInt(2,customer1.getAccount_number());
			 ResultSet result1=prepare.executeQuery();
			
			while(result1.next()){
				isvalid=true;
			
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return isvalid;
		
	}

}
