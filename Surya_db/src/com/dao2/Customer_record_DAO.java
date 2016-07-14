package com.dao2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import com.bo.Customer_info;
import com.database.DataBaseManager;

public class Customer_record_DAO {
	ResultSetMetaData rsmd4=null;
	@SuppressWarnings({ "rawtypes" })
	public Map<String,Vector>  authenticate_account(Customer_info info3){
	 
	Map<String,Vector> map4=null;
	try {
		Connection connection=DataBaseManager.getconnection();
		PreparedStatement prepare=connection.prepareStatement("SELECT customer_id,account_no ,name,date_of_birth,acc_type  FROM suryadb.customer_details where customer_id=?");
		prepare.setInt(1, info3.getCustomer_id());
        ResultSet result3=prepare.executeQuery();
        Vector<String> column_name4=new Vector<String>();
        Vector<String> current_row4=null;
        Vector<Vector<String>> data_set4=new Vector<Vector<String>>();
        boolean header_set=true;
        while(result3.next()){
        	current_row4=new Vector<String>();
        	rsmd4=result3.getMetaData();
        	for(int i=1;i<=rsmd4.getColumnCount();i++){
        		if(header_set){
        			column_name4.addElement(rsmd4.getColumnName(i));	
        		}
        		current_row4.addElement(result3.getString(i));
        	}
        	
        	//data_set4.add(current_row4);
        	
        	header_set=false;
        }
       
         header_set=true; 
        Connection connection1=DataBaseManager.getconnection();
         PreparedStatement prepare1=connection1.prepareStatement("SELECT balance FROM suryadb.account_statement where customer_id=?");
         prepare1.setInt(1, info3.getCustomer_id());
         ResultSet result1=prepare1.executeQuery();
         header_set=true;
         while(result1.next()){
        //	 current_row4=new Vector<String>();
        	 ResultSetMetaData rsmd5=result1.getMetaData();
        	 
     for(int j=1;j<=rsmd5.getColumnCount();j++){
        	 if(header_set){
        			column_name4.addElement(rsmd5.getColumnName(j));
        		}
        		current_row4.addElement(result1.getString(j));
        	 }
        	 data_set4.add(current_row4);
        	 header_set=false;
         }
        map4=new HashMap<String,Vector>();
        map4.put("header_set4", column_name4);
        map4.put("dataset4",data_set4);
        
	} catch (SQLException e) {
	e.printStackTrace();
	}
	return map4;
	} 
}
