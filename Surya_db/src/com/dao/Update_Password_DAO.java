package com.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bo.User_info;

import com.database.DataBaseManager;

public class Update_Password_DAO {
	boolean isvalid=false;
	public boolean authenticate_password(User_info user2){
		
		
		try {
			Connection connection = DataBaseManager.getconnection();
			PreparedStatement prepare=connection.prepareStatement("update suryadb.user_details set user_password =? where user_name=?  ");
	        prepare.setString(1,user2.getUser_password());
	        prepare.setString(2, user2.getUser_name());
			int execute=prepare.executeUpdate();
	        if(execute > 0){
	        	isvalid=true;
	        }
	    
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isvalid;
 }
}
