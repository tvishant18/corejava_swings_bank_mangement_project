package com.dao;

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

public class Account_Statement_DAO {
	public static ResultSet result1;
@SuppressWarnings("rawtypes")
public Map<String, Vector> get_map(Customer_info customer1){
	
	Map<String, Vector> map = null;
	try {
		Connection connection=DataBaseManager.getconnection();
		PreparedStatement prepare=connection.prepareStatement("select * from suryadb.account_statement where customer_id=? and account_no=?");
		prepare.setInt(1, customer1.getCustomer_id());
		prepare.setInt(2,customer1.getAccount_number());
		result1=prepare.executeQuery();
		Vector<String> column_name=new Vector<String>();
		Vector<String> current_row=null;
		Vector<Vector> final_data_set=new Vector<Vector>();
		boolean header_set=true;
		while(result1.next()){
			
			ResultSetMetaData rsmd=result1.getMetaData();
			current_row=new Vector<String>(); 
			for(int i=1;i<=rsmd.getColumnCount();i++){
			if(header_set){
			column_name.addElement(rsmd.getColumnName(i));	
			}
			current_row.addElement(result1.getString(i));
			}
			final_data_set.add(current_row);
			header_set=false;
		}
		 map=new HashMap<String, Vector>();
		map.put("header", column_name);
		map.put("dataset", final_data_set);
	
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	
	return map;
}
}
