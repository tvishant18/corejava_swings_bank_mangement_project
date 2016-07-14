package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bo.User_info;
import com.database.DataBaseManager;

public class Change_Password_DAO {
  public boolean authenticate_change_password(User_info user1){
	  boolean isvalid=false;
	  try {
	  Connection connnection=DataBaseManager.getconnection();
	  PreparedStatement prepare=connnection.prepareStatement("select * from suryadb.user_details where user_name=? and secret_ques=? and secret_answer=?");
	  prepare.setString(1,user1.getUser_name() );
	  prepare.setString(2, user1.getSecret_ques());
	  prepare.setString(3, user1.getSecret_answer());
	  ResultSet result=prepare.executeQuery();
	  while(result.next()){
		  isvalid=true;
	  }
	  DataBaseManager.close_all_connection(connnection, prepare, result);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return isvalid;
	  
  }
  
}
