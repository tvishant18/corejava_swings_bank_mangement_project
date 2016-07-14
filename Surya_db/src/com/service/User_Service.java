package com.service;

import java.sql.SQLException;

import com.bo.User_info;
import com.dao.User_DAO;
import com.exception.Business_Exception;

public class User_Service {
	public boolean authenticate_user(User_info user)throws Business_Exception{
 User_DAO dao=new User_DAO();
 boolean isvalid=false;
 try {
	isvalid=dao.authenticate_user(user);
	
} catch (SQLException e) {

    System.out.println("Exception occured:"+e);
    
	throw new Business_Exception(Business_Exception.error);
}
return isvalid;
 
}
}