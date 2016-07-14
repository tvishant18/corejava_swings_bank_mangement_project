package com.dao2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import com.database.DataBaseManager;

public class Debit_Transaction_history_DAO {
	@SuppressWarnings("rawtypes")
	public  Map<String,Vector> get_debit_history_table(){
		Map<String,Vector> map2=null;
		try {
			Connection connection=DataBaseManager.getconnection();
	        PreparedStatement prepare=connection.prepareStatement("SELECT * FROM suryadb.debit_transaction_history");
	        ResultSet result2=prepare.executeQuery();
	        Vector<String> column_name2=new Vector<String>();
	        Vector<String> current_row2=null;
	        Vector<Vector> data_set2=new Vector<Vector>();
	        boolean header_set=true;
	        while(result2.next()){
	        	current_row2=new Vector<String>();
	        	ResultSetMetaData rsmd2=result2.getMetaData();
	        	for(int i=1;i<=rsmd2.getColumnCount();i++){
	        		if(header_set){
	        			column_name2.addElement(rsmd2.getColumnName(i));	
	        		}
	        		current_row2.addElement(result2.getString(i));
	        	}
	        	data_set2.add(current_row2);
	        	header_set=false;
	        }	
	        map2=new HashMap<String,Vector>();
	        map2.put("header_set2", column_name2);
	        map2.put("dataset2",data_set2);
	        
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return map2;
	}
}
