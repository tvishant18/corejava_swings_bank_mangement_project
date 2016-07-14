package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.bo.User_info;
import com.database.DataBaseManager;

public class User_DAO {
	ResultSet result2;
	public boolean authenticate_user(User_info user) throws SQLException{
	boolean isvalid=false;
	try {
		Connection connection=DataBaseManager.getconnection();
		PreparedStatement prepare=connection.prepareStatement("select * from suryadb.user_details where user_name=? and user_password=?");
		prepare.setString(1,user.getUser_name());
		prepare.setString(2, user.getUser_password());
	    result2=prepare.executeQuery();
		while(result2.next()){
			isvalid=true;
		}
		DataBaseManager.close_all_connection(connection, prepare, result2);
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	
	return isvalid;
	
		
	}
}
