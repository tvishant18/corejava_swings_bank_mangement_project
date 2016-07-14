package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bo.User_info;
import com.database.DataBaseManager;

public class Secret_question_DAO {
	public  static String Question;
   public  boolean authenticate_secret_question(User_info user){
	   boolean isvalid=false;
	   try {
		Connection connection=DataBaseManager.getconnection();
		PreparedStatement prepare=connection.prepareStatement("select * from suryadb.user_details where user_name=?");
        prepare.setString(1, user.getUser_name());
        ResultSet result1=prepare.executeQuery();
        while(result1.next()){
        	
        	isvalid=true;
        	Question=result1.getString(5);
        	
        }
        DataBaseManager.close_all_connection(connection, prepare, result1);
	   } catch (SQLException e) {
		e.printStackTrace();
	}
	return isvalid;
	
   }
}
