package com.next;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import com.bo.Customer_info;
import com.dao.Account_Statement_DAO;
import com.dao.Account_Statement_DAO1;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Account_statement_panel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField customer_id_text1;
	private JTextField account_no_text1;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public Account_statement_panel() {
		setLayout(null);
		
		JLabel label = new JLabel("Customer ID :");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(369, 219, 119, 21);
		add(label);
		
		JLabel label_1 = new JLabel("Account Number :");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setBounds(369, 277, 121, 21);
		add(label_1);
		
		customer_id_text1 = new JTextField();
		customer_id_text1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		customer_id_text1.setColumns(10);
		customer_id_text1.setBounds(523, 219, 202, 20);
		add(customer_id_text1);
		
		account_no_text1 = new JTextField();
		account_no_text1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		account_no_text1.setColumns(10);
		account_no_text1.setBounds(523, 278, 202, 20);
		add(account_no_text1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\vishant thakur\\git\\corejava_swings_bank_mangement_project\\Surya_db\\src\\com\\images\\ICICI.jpg"));
		lblNewLabel.setBounds(397, 52, 288, 109);
		add(lblNewLabel);
		
		JButton get_statement_button = new JButton("Get Statement");
		get_statement_button.addActionListener(new ActionListener() {
			@SuppressWarnings("rawtypes")
			public void actionPerformed(ActionEvent arg0) {
				int account_number=Integer.parseInt(account_no_text1.getText());
				int customer_id=Integer.parseInt(customer_id_text1.getText());
				
				Customer_info customer1=new Customer_info();
				customer1.setAccount_number(account_number);
				customer1.setCustomer_id(customer_id);
				Account_Statement_DAO1 asd1=new Account_Statement_DAO1();
				Account_Statement_DAO asd=new Account_Statement_DAO();
				if(asd1.authenticate_statement(customer1)){
				Map<String,Vector> map1=asd.get_map(customer1);
				Vector header_Data = null;
				Vector final_DataSet = null;
				if(map1!=null){
					header_Data=(Vector) map1.get("header");
					final_DataSet=(Vector) map1.get("dataset");
					if(header_Data.size()>0 && final_DataSet.size()>0){
						table.setModel(new javax.swing.table.DefaultTableModel(final_DataSet, header_Data));	
					}
				}
					
				/*	try {
						account_no_text1.setText(""+Account_Statement_DAO.result1.getString(2));
						DataBaseManager.close_result(Account_Statement_DAO.result1);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
				}
				else{
					account_no_text1.setText("");
					customer_id_text1.setText("");
					JOptionPane.showMessageDialog(get_statement_button,"please enter valid customer Id and account no");
				}
			}
		});
		get_statement_button.setForeground(Color.BLUE);
		get_statement_button.setFont(new Font("Tahoma", Font.BOLD, 14));
		get_statement_button.setBounds(476, 331, 151, 31);
		add(get_statement_button);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//	User_account_window window = new User_account_window();
				User_account_window.splitPane.setRightComponent(new User_account_right());
			    
			}
		});
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnHome.setForeground(Color.RED);
		btnHome.setBounds(0, 0, 89, 23);
		add(btnHome);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(164, 470, 826, 87);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null,null },
						{ null, null, null, null }, { null, null, null, null },
						{ null, null, null, null } }, new String[] { "Title 1",
						"Title 2", "Title 3", "Title 4" }));
		scrollPane.setViewportView(table);

	}
}
