package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.database.DataBaseManager;

public class Account_no_DAO {
	
public static  ResultSet result;
public boolean get_account(){
	boolean isvalid=false;
	try {
		Connection connection=DataBaseManager.getconnection();
		PreparedStatement prepare=connection.prepareStatement("select max(account_no+1),max(customer_id+1) from suryadb.customer_details ");
	    result=prepare.executeQuery();
	    
	    if(result.next()){
	    	   
	    	 isvalid=true;
	    	 
	    }
	  
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return isvalid;
	
	
}
}
