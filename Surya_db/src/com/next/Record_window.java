


package com.next;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import com.bo.Customer_info;
import com.dao2.Credit_Transaction_History_DAO;
import com.dao2.Customer_record_DAO;
import com.dao2.Debit_Transaction_history_DAO;
import com.dao2.Transfer_Transaction_history_DAO;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Record_window extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField customer_id_text;
	private JTextField account_no_text;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings("rawtypes")
	public Record_window() {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(49, 21, 881, 607);
		add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Customer Record", null, panel, null);
		panel.setLayout(null);
		
		JButton HOME = new JButton("Home");
		HOME.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				User_account_window.splitPane.setRightComponent(new User_account_right());
			}
		});
		HOME.setForeground(Color.RED);
		HOME.setFont(new Font("Tahoma", Font.BOLD, 11));
		HOME.setBounds(0, 0, 70, 23);
		panel.add(HOME);
		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon("C:\\Users\\vishant thakur\\workspace\\Surya_db\\src\\com\\images\\ICICI.jpg"));
		label.setBounds(274, 48, 288, 110);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Customer ID :");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setBounds(252, 197, 119, 23);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Account Number :");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_2.setBounds(252, 270, 119, 21);
		panel.add(label_2);
		
		customer_id_text = new JTextField();
		customer_id_text.setColumns(10);
		customer_id_text.setBounds(381, 199, 201, 20);
		panel.add(customer_id_text);
		
		account_no_text = new JTextField();
		account_no_text.setColumns(10);
		account_no_text.setBounds(381, 271, 201, 20);
		panel.add(account_no_text);
		
		JButton btnShowRecord = new JButton("Show  Record");
		btnShowRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int account_no5=Integer.parseInt(account_no_text.getText());
				int customer_id5=Integer.parseInt(customer_id_text.getText());
			Customer_info info3=new Customer_info();
			info3.setAccount_number(account_no5);
			info3.setCustomer_id(customer_id5);
			Customer_record_DAO crd=new Customer_record_DAO();
			Map<String,Vector> map5=crd.authenticate_account(info3);
			Vector header_info3=null;
			Vector set_data4=null;
			if(map5 !=null){
				header_info3=(Vector)map5.get("header_set4");
				set_data4=(Vector)map5.get("dataset4");
				if(header_info3.size()>0 && set_data4.size() >0){
				
					table.setModel(new javax.swing.table.DefaultTableModel(set_data4,header_info3));
				
				}
			}
			}
		});
		btnShowRecord.setForeground(Color.BLUE);
		btnShowRecord.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnShowRecord.setBounds(333, 323, 162, 25);
		panel.add(btnShowRecord);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 468, 786, 57);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][]{{null,null,null,null,null},{null,null,null,null,null}},new String[]{"Acc no","Name","DOB","Account Type","Balance"}));
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Credit History", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 858, 545);
		panel_1.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		Credit_Transaction_History_DAO cthd=new Credit_Transaction_History_DAO();
		Map<String,Vector> map1=cthd.get_credit_history_table();
		Vector header_info=null;
		Vector set_data1=null;
		if(map1 !=null){
			header_info=(Vector)map1.get("header_set1");
			set_data1=(Vector)map1.get("dataset1");
			if(header_info.size()>0 && set_data1.size() >0){
			
				table_1.setModel(new javax.swing.table.DefaultTableModel(set_data1,header_info));
		
			}
		}
		

		
	/*	table.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null,null },
						{ null, null, null, null }, { null, null, null, null },
						{ null, null, null, null } }, new String[] { "Title 1",
						"Title 2", "Title 3", "Title 4" }));
		*/
		scrollPane_1.setViewportView(table_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Debit History", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 11, 858, 545);
		panel_2.add(scrollPane_2);
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		 
		Debit_Transaction_history_DAO dthd=new Debit_Transaction_history_DAO();
		Map<String,Vector> smap2=dthd.get_debit_history_table();
		Vector header_info2=null;
		Vector set_data2=null;
		if(smap2 !=null){
			header_info2=(Vector)smap2.get("header_set2");
			set_data2=(Vector)smap2.get("dataset2");
			if(header_info2.size()>0 && set_data2.size() >0){
			
				table_2.setModel(new javax.swing.table.DefaultTableModel(set_data2,header_info2));
		
			}
		}
		
		
		
	/*	table_2.setModel(new DefaultTableModel(new Object[][]{ 
			{null,null,null,null},{null,null,null,null},{null,null,null,null} },new String[]{"text1","text2","text3","text4"}));
		*/
		
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Transfer History ", null, panel_3, null);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 11, 858, 545);
		panel_3.add(scrollPane_3);
		
		table_3 = new JTable();
	//	table_3.setModel(new DefaultTableModel(new Object[][]{{null,null,null,null},{null,null,null,null}},new String[]{"text1","text2","text3","text4"}));
		scrollPane_3.setViewportView(table_3);
	    
		Transfer_Transaction_history_DAO tthd=new Transfer_Transaction_history_DAO();
		Map<String,Vector> tmap3=tthd.get_transfer_history_table();
		Vector header_info3=null;
		Vector set_data3=null;
		if(tmap3 !=null){
			header_info3=(Vector)tmap3.get("header_set3");
			set_data3=(Vector)tmap3.get("dataset3");
			if(header_info3.size()>0 && set_data3.size()>0){
				table_3.setModel(new javax.swing.table.DefaultTableModel(set_data3,header_info3));
		        
			}
		}
		
	}
}
