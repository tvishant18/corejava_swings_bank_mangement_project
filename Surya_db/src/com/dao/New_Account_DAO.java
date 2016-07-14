package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bo.Customer_info;
import com.database.DataBaseManager;

public class New_Account_DAO {
	
 public boolean authenticate_new(Customer_info customer){
	 boolean isvalid=false;
	 try {
	   Connection connection=DataBaseManager.getconnection();
	   PreparedStatement prepare=connection.prepareStatement("INSERT INTO `suryadb`.`customer_details` (`account_no`,`customer_id`, `acc_type`, `name`, `father's_name`, `mother's_name`, `date_of_birth`, `age`, `sex`, `occupation`, `adress`, `mobile`, `first_nominee_name`, `second_nominee_name`, `sms_service`, `ATM`, `Cheque BOOK`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
	   prepare.setInt(1,customer.getAccount_number());
	   prepare.setInt(2, customer.getCustomer_id());
	   prepare.setString(3,customer.getAccount_type() );
	   prepare.setString(4,customer.getName() );
	   prepare.setString(5,customer.getFather_Name() );
	   prepare.setString(6,customer.getMother_Name() );
	   prepare.setString(7,customer.getDOB() );
	   prepare.setInt(8,customer.getAge());
	   prepare.setString(9, customer.getSex());
	   prepare.setString(10,customer.getOccupation() );
	   prepare.setString(11,customer.getAddress() );
	   prepare.setString(12, customer.getMobile());
	   prepare.setString(13,customer.getFirst_Nominee_name() );
	   prepare.setString(14, customer.getSecond_Nominee_name());
	   prepare.setString(15, customer.getSMS_service());
	   prepare.setString(16,customer.getATM() );
	   prepare.setString(17,customer.getCheque_Book() );
	   int execute=prepare.executeUpdate();
	   if(execute>0){
		   isvalid=true;
		   
	   }
	   DataBaseManager.close_prepare(prepare);
	   DataBaseManager.close_connection(connection);
	 } catch (SQLException e) {
		
		e.printStackTrace();
	}
	return isvalid;
 }
	
public boolean authenticate_balance_account(Customer_info customer){
	 boolean isvalid=false;
	 try {
	   Connection connection=DataBaseManager.getconnection();
	   PreparedStatement prepare=connection.prepareStatement("INSERT INTO `suryadb`.`account_statement` (`customer_id`, `account_no`, `balance`) VALUES (?, ?, '0')");

	   prepare.setInt(1,customer.getCustomer_id());
	   prepare.setInt(2, customer.getAccount_number());
	   int execute=prepare.executeUpdate();
	   if(execute>0){
		   isvalid=true;
		   
	   }
	   DataBaseManager.close_prepare(prepare);
	   DataBaseManager.close_connection(connection);
	 } catch (SQLException e) {
		
		e.printStackTrace();
	}
	return isvalid;
 }
}
