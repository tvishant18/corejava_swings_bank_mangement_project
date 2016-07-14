package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bo.Update_password_info;
import com.database.DataBaseManager;

public class Update_Password1_DAO {
	public boolean authenticate_old_password(Update_password_info user){
	 boolean isvalid=false;
	 try {
		Connection connection=DataBaseManager.getconnection();
	    PreparedStatement prepare=connection.prepareStatement("select * from suryadb.user_details where user_name=?");
	    prepare.setString(1, user.getUsername());
	    ResultSet result=prepare.executeQuery();
	    if(result.next()){
	    	isvalid=true;
	    }
	   
	 } catch (SQLException e) {
		
		e.printStackTrace();
	}
	return isvalid;
		
	}
public boolean authenticate_password(Update_password_info user2){
	boolean isvalid=false;
	if(user2.getNew_password().equals(user2.getRetype_password())&& !(user2.getNew_password().equals(user2.getOld_password()))){
		try {
			Connection connection = DataBaseManager.getconnection();
			PreparedStatement prepare=connection.prepareStatement("update suryadb.user_details set user_password =? where user_name=?  ");
	        prepare.setString(1,user2.getNew_password());
	        prepare.setString(2, user2.getUsername());
			int execute=prepare.executeUpdate();
	        if(execute > 0){
	        	isvalid=true;
	        }
	    
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return isvalid;
}
}
