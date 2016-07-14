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

public class Credit_Transaction_History_DAO {
@SuppressWarnings("rawtypes")
public  Map<String,Vector> get_credit_history_table(){
	Map<String,Vector> map1=null;
	try {
		Connection connection=DataBaseManager.getconnection();
        PreparedStatement prepare=connection.prepareStatement("SELECT * FROM suryadb.credit_transaction_history");
        ResultSet result1=prepare.executeQuery();
        Vector<String> column_name1=new Vector<String>();
        Vector<String> current_row1=null;
        Vector<Vector<String>> data_set1=new Vector<Vector<String>>();
        boolean header_set=true;
        while(result1.next()){
        	current_row1=new Vector<String>();
        	ResultSetMetaData rsmd1=result1.getMetaData();
        	for(int i=1;i<=rsmd1.getColumnCount();i++){
        		if(header_set){
        			column_name1.addElement(rsmd1.getColumnName(i));	
        		}
        		current_row1.addElement(result1.getString(i));
        	}
        	data_set1.add(current_row1);
        	header_set=false;
        }	
        map1=new HashMap<String,Vector>();
        map1.put("header_set1", column_name1);
        map1.put("dataset1",data_set1);
        
	} catch (SQLException e) {
	e.printStackTrace();
	}
	return map1;
}
}
