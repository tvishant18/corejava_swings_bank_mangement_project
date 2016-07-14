
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

public class Transfer_Transaction_history_DAO {
	@SuppressWarnings("rawtypes")
	public  Map<String,Vector> get_transfer_history_table(){
		Map<String,Vector> map3=null;
		try {
			Connection connection=DataBaseManager.getconnection();
	        PreparedStatement prepare=connection.prepareStatement("SELECT * FROM suryadb.transfer_transaction_history");
	        ResultSet result3=prepare.executeQuery();
	        Vector<String> column_name3=new Vector<String>();
	        Vector<String> current_row3=null;
	        Vector<Vector> data_set3=new Vector<Vector>();
	        boolean header_set=true;
	        while(result3.next()){
	        	current_row3=new Vector<String>();
	        	ResultSetMetaData rsmd3=result3.getMetaData();
	        	for(int i=1;i<=rsmd3.getColumnCount();i++){
	        		if(header_set){
	        			column_name3.addElement(rsmd3.getColumnName(i));	
	        		}
	        		current_row3.addElement(result3.getString(i));
	        	}
	        	data_set3.add(current_row3);
	        	header_set=false;
	        }	
	        map3=new HashMap<String,Vector>();
	        map3.put("header_set3", column_name3);
	        map3.put("dataset3",data_set3);
	        
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return map3;
	}

}
