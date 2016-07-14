package com.next;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;

import com.bo.Customer_info;
import com.dao.Account_no_DAO;
import com.dao.New_Account_DAO;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class New_Account_Panel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JTextField account_no_text;
	private JTextField name_text;
	private JTextField father_text;
	private JTextField mother_text;
	private JTextField age_text;
	private static JTextField customer_id_text;
	private JTextField occupation_text;
	private JTextField mobile_text;
	private JTextField first_nom_text;
	private JTextField second_nom_text;
	private JComboBox<Integer> day_combo ;
    private JComboBox<Integer> momth_combo;
	private JComboBox<Integer> year_combo;
	private JComboBox<String> sms_combo;
	private JComboBox<String> atm_combo;
	private JComboBox<String> cheque_combo;
	private JComboBox<String> sex_combo;
	private JComboBox<String> account_type_combo;
	/**
	 * Create the panel.
	 */
	public void new_account_display() {
		Account_no_DAO and=new Account_no_DAO();
		if(and.get_account()){
		try {
			
			account_no_text.setText(""+Account_no_DAO.result.getInt(1));
			customer_id_text.setText(""+Account_no_DAO.result.getInt(2));
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	}
	
	
	
	public New_Account_Panel() {
		setLayout(null);
		
		
		JLabel label_1 = new JLabel("Account Number*");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setBounds(126, 121, 115, 20);
		add(label_1);
		
		JLabel label_2 = new JLabel("Name*");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_2.setBounds(126, 166, 90, 20);
		add(label_2);
		
		JLabel label_3 = new JLabel("Father's Name*");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_3.setBounds(126, 210, 115, 20);
		add(label_3);
		
		JLabel label_4 = new JLabel("Mother's Name*");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_4.setBounds(126, 251, 115, 20);
		add(label_4);
		
		JLabel label_5 = new JLabel("DOB*");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_5.setBounds(126, 295, 115, 20);
		add(label_5);
		
		JLabel label_6 = new JLabel("Age*");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_6.setBounds(126, 339, 115, 20);
		add(label_6);
		
		JLabel label_7 = new JLabel("Sex*");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_7.setBounds(126, 379, 115, 20);
		add(label_7);
		
		JLabel label_8 = new JLabel("Address*");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_8.setBounds(126, 422, 115, 20);
		add(label_8);
		
		account_no_text = new JTextField();
		account_no_text.setColumns(10);
		account_no_text.setBounds(287, 122, 209, 20);
		add(account_no_text);
		
	
		name_text = new JTextField();
		name_text.setColumns(10);
		name_text.setBounds(287, 165, 209, 20);
		add(name_text);
		
		father_text = new JTextField();
		father_text.setColumns(10);
		father_text.setBounds(287, 209, 209, 20);
		add(father_text);
		
		mother_text = new JTextField();
		mother_text.setColumns(10);
		mother_text.setBounds(287, 250, 209, 20);
		add(mother_text);
		
		age_text = new JTextField();
		age_text.setColumns(10);
		age_text.setBounds(287, 342, 209, 20);
		add(age_text);
		
		sex_combo = new JComboBox<String>();
		sex_combo.setBounds(287, 382, 209, 20);
		add(sex_combo);
		String c[]={"MALE","FEMALE"};
		sex_combo.setModel(new javax.swing.DefaultComboBoxModel<String>(c));
		
		JTextArea address_text = new JTextArea();
		address_text.setBounds(287, 423, 209, 104);
		add(address_text);
		
		day_combo = new JComboBox<Integer>();
		day_combo.setBounds(287, 298, 49, 20);
		add(day_combo);
		ArrayList<Integer> mylist=new ArrayList<Integer>();
		for(Integer i=1;i<=31;i++){
			mylist.add(i);
		}
		Integer d[]=mylist.toArray(new Integer[mylist.size()]);
        day_combo.setModel(new javax.swing.DefaultComboBoxModel<Integer>(d));
	
		momth_combo = new JComboBox<Integer>();
		momth_combo.setBounds(356, 298, 49, 20);
		add(momth_combo);
		ArrayList<Integer> mylist1=new ArrayList<Integer>();
		for( Integer i=1;i<=12;i++){
			mylist1.add(i);
		}
		Integer e[]=mylist1.toArray(new Integer[mylist1.size()]);
		momth_combo.setModel(new javax.swing.DefaultComboBoxModel<Integer>(e));

		 year_combo = new JComboBox<Integer>();
		year_combo.setBounds(424, 298, 72, 20);
		add(year_combo);
		ArrayList<Integer> mylist2=new ArrayList<Integer>();
		for(Integer i=1871;i<=2016;i++){
			mylist2.add(i);
		}
		Integer f[]=mylist2.toArray(new Integer[mylist2.size()]);
		year_combo.setModel(new javax.swing.DefaultComboBoxModel<Integer>(f));
	
		JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int customer_id=Integer.parseInt(customer_id_text.getText());
				int account_number=Integer.parseInt(account_no_text.getText());
				String name=name_text.getText();
				//String account_type=account_type_text.getText();
				String account_type=(String)account_type_combo.getSelectedItem();
				String father_Name=father_text.getText();
				String mother_Name=mother_text.getText();
				//String dob=day_text.getText()+"/"+month_text.getText()+"/"+year_text.getText();
				String dob=(Integer)day_combo.getSelectedItem()+"/"+(Integer)momth_combo.getSelectedItem()+"/"+(Integer)year_combo.getSelectedItem();
				String occupation=occupation_text.getText();
				//String sex=sex_text.getText();
				String sex=(String)sex_combo.getSelectedItem();
				int age=Integer.parseInt(age_text.getText());
				String address=address_text.getText();
				String mobile=mobile_text.getText();
				String First_Nominee_name=first_nom_text.getText();
				String Second_Nominee_name=second_nom_text.getText();
				//String SMS_service=sms_text.getText();
				//String ATM=atm_text.getText();
				//String Cheque_Book=cheque_text.getText();
				String SMS_service=(String)sms_combo.getSelectedItem();
				String ATM=(String)atm_combo.getSelectedItem();
			    String Cheque_Book=(String)cheque_combo.getSelectedItem();
				Customer_info customer= new Customer_info();
				customer.setAccount_number(account_number);
				customer.setCustomer_id(customer_id);
				customer.setAccount_type(account_type);
				customer.setAddress(address);
				customer.setAge(age);
				customer.setATM(ATM);
				customer.setCheque_Book(Cheque_Book);
				customer.setDOB(dob);
				customer.setFather_Name(father_Name);
				customer.setFirst_Nominee_name(First_Nominee_name);
				customer.setMobile(mobile);
				customer.setMother_Name(mother_Name);
				customer.setSecond_Nominee_name(Second_Nominee_name);
				customer.setName(name);
				customer.setOccupation(occupation);
				customer.setSex(sex);
				customer.setSMS_service(SMS_service);
				New_Account_DAO nad=new New_Account_DAO();
				
				
				if(  !(dob.isEmpty()) && !(sex.isEmpty())&& !(name.isEmpty())&& !(mother_Name.isEmpty()) && !(father_Name.isEmpty()) && !(address.isEmpty()) && !(occupation.isEmpty())&& !(mobile.isEmpty()) ){
				if(mobile.length()==10){
					
				if(nad.authenticate_new(customer)&& nad.authenticate_balance_account(customer)){
			    JOptionPane.showMessageDialog(submit, "new account is created with customer id ="+customer.getCustomer_id());
			    User_account_window.splitPane.setRightComponent(new User_account_right());
			    
			  
				}
				else{
					JOptionPane.showMessageDialog(submit, "Duplicate entry for customer id="+customer.getCustomer_id());
					 
				}
				}
				else{
					mobile_text.setText("");
					JOptionPane.showMessageDialog(submit, "Please enter a valid 10 digit mobile number");
				}
		}
			else{
					JOptionPane.showMessageDialog(submit, "Marked Field Should not be empty");
				}
				
			}
		});
		submit.setForeground(Color.BLUE);
		submit.setFont(new Font("Tahoma", Font.BOLD, 11));
		submit.setBounds(479, 575, 167, 23);
		add(submit);
		
		JLabel label = new JLabel("Customer ID*");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(605, 119, 115, 20);
		add(label);
		
		JLabel label_9 = new JLabel("Account Type*");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_9.setBounds(605, 166, 115, 20);
		add(label_9);
		
		JLabel label_10 = new JLabel("Occupation*");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_10.setBounds(605, 210, 115, 20);
		add(label_10);
		
		JLabel label_11 = new JLabel("Mobile*");
		label_11.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_11.setBounds(605, 251, 115, 20);
		add(label_11);
		
		JLabel label_12 = new JLabel("First Nominee");
		label_12.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_12.setBounds(605, 297, 115, 20);
		add(label_12);
		
		JLabel label_13 = new JLabel("Second Nominee");
		label_13.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_13.setBounds(602, 341, 90, 20);
		add(label_13);
		
		JLabel label_14 = new JLabel("SMS Service");
		label_14.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_14.setBounds(605, 379, 90, 20);
		add(label_14);
		
		JLabel label_15 = new JLabel("ATM Card");
		label_15.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_15.setBounds(602, 422, 90, 20);
		add(label_15);
		
		JLabel label_16 = new JLabel("Cheque Book");
		label_16.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_16.setBounds(602, 462, 90, 20);
		add(label_16);
		
		customer_id_text = new JTextField();
		customer_id_text.setColumns(10);
		customer_id_text.setBounds(741, 119, 209, 20);
		add(customer_id_text);
		
		occupation_text = new JTextField();
		occupation_text.setColumns(10);
		occupation_text.setBounds(741, 211, 209, 20);
		add(occupation_text);
		
		mobile_text = new JTextField();
		mobile_text.setColumns(10);
		mobile_text.setBounds(741, 252, 209, 20);
		add(mobile_text);
		
		first_nom_text = new JTextField();
		first_nom_text.setColumns(10);
		first_nom_text.setBounds(741, 296, 209, 20);
		add(first_nom_text);
		
		second_nom_text = new JTextField();
		second_nom_text.setColumns(10);
		second_nom_text.setBounds(741, 340, 209, 20);
		add(second_nom_text);
		
		account_type_combo = new JComboBox<String>();
		account_type_combo.setBounds(741, 167, 209, 20);
		add(account_type_combo);
		String a[]={"SAVINGS","CURRENT"};
		account_type_combo.setModel(new javax.swing.DefaultComboBoxModel<String>(a));

		sms_combo = new JComboBox<String>();
		sms_combo.setBounds(741, 382, 209, 20);
		add(sms_combo);
		String b[]={"YES","NO"};
		sms_combo.setModel(new javax.swing.DefaultComboBoxModel<String>(b));
		
		atm_combo = new JComboBox<String>();
		atm_combo.setBounds(741, 423, 209, 20);
		add(atm_combo);
		atm_combo.setModel(new javax.swing.DefaultComboBoxModel<String>(b));
		 
		cheque_combo = new JComboBox<String>();
		cheque_combo.setBounds(741, 463, 209, 20);
		add(cheque_combo);
		cheque_combo.setModel(new javax.swing.DefaultComboBoxModel<String>(b));
		
		JButton button_1 = new JButton("Home");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			User_account_window.splitPane.setRightComponent(new User_account_right());
			}
		});
		button_1.setForeground(Color.BLACK);
		button_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_1.setBounds(0, 0, 70, 23);
		add(button_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\vishant thakur\\workspace\\Surya_db\\src\\com\\images\\ICICI.jpg"));
		lblNewLabel.setBounds(435, 0, 290, 86);
		add(lblNewLabel);

	}
}
