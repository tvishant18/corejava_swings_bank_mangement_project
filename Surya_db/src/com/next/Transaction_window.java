package com.next;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import com.bo.Transaction_info;
import com.dao.Credit_transaction_history_insertion_DAO;
import com.dao.Debit_transaction_history_insertion_DAO;
import com.dao.Deposit_money_DAO;
import com.dao.Reciever_getcredit_transfer_DAO;
import com.dao.Sender_Credit_Transfer_DAO;
import com.dao.Tansfer_Transaction_history_DAO;
import com.dao.Withdrawl_money_DAO;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Transaction_window extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField customer_id2_text;
	private JTextField account_no2_text;
	private JTextField amount1_text;
	private static JTextField Txn2_text;
	private JTextField customer_id3_text;
	private JTextField account_no3_text;
	private JTextField customer_id_text;
	private JTextField account_no_text;
	private static JTextField Txn_text;
	private JTextField customer_id1_text;
	private JTextField account_no1_text;
	private static JTextField Txn1_text;
	private JTextField amount_credit__text;
	private JTextField amount_debit_text;

	/**
	 * Create the panel.
	 */
	public Transaction_window() {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(25, 11, 1096, 631);
		add(tabbedPane);
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss" );
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		tabbedPane.addTab("Deposit Cash", null, panel, null);
		panel.setLayout(null);
		
		JLabel customer_id_lbl = new JLabel("Customer ID :");
		customer_id_lbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		customer_id_lbl.setBounds(370, 145, 115, 20);
		panel.add(customer_id_lbl);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\vishant thakur\\workspace\\Surya_db\\src\\com\\images\\ICICI.jpg"));
		lblNewLabel_1.setBounds(409, 11, 290, 109);
		panel.add(lblNewLabel_1);
		
		customer_id_text = new JTextField();
		customer_id_text.setFont(new Font("Dialog", Font.PLAIN, 13));
		customer_id_text.setColumns(10);
		customer_id_text.setBounds(495, 145, 225, 20);
		panel.add(customer_id_text);
		
		account_no_text = new JTextField();
		account_no_text.setFont(new Font("Dialog", Font.PLAIN, 13));
		account_no_text.setColumns(10);
		account_no_text.setBounds(495, 195, 225, 20);
		panel.add(account_no_text);
		
		Txn_text = new JTextField();
		Txn_text.setFont(new Font("Dialog", Font.PLAIN, 13));
		Txn_text.setColumns(10);
		Txn_text.setBounds(495, 247, 225, 20);
		panel.add(Txn_text);
		Txn_text.setText(sdf.format(date));
		
		JLabel account_no_lbl = new JLabel("Account No :");
		account_no_lbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		account_no_lbl.setBounds(370, 195, 115, 20);
		panel.add(account_no_lbl);
		
		amount_credit__text = new JTextField();
		amount_credit__text.setFont(new Font("Dialog", Font.PLAIN, 13));
		amount_credit__text.setForeground(Color.BLUE);
		amount_credit__text.setColumns(10);
		amount_credit__text.setBounds(495, 309, 225, 20);
		panel.add(amount_credit__text);
		
		JLabel Txn_lbl = new JLabel("Txn Date&Time :");
		Txn_lbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		Txn_lbl.setBounds(370, 247, 115, 20);
		panel.add(Txn_lbl);
		
		JLabel amount_credit_lbl = new JLabel(" Amount(in Rs) :");
		amount_credit_lbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		amount_credit_lbl.setBounds(370, 309, 115, 20);
		panel.add(amount_credit_lbl);
		
		JButton deposit_button = new JButton("Deposit");
		deposit_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			int customer_id=Integer.parseInt(customer_id_text.getText());
			int  account_no=Integer.parseInt(account_no_text.getText());
			int amount_credit=Integer.parseInt(amount_credit__text.getText());
			String txn_date=Txn_text.getText();
			Transaction_info info=new Transaction_info();
			info.setCustomer_id(customer_id);
			info.setAccount_no(account_no);
			info.setTransaction_date(txn_date);
			info.setCredit_amount(amount_credit);
			Deposit_money_DAO dmd=new Deposit_money_DAO();
			Credit_transaction_history_insertion_DAO cthi=new Credit_transaction_history_insertion_DAO();
			if(dmd.autheticate_deposit(info)){
				if(dmd.get_new_balance(info)){
					if(cthi.get_transaction_insertion(info)){
						customer_id_text.setText("");
						account_no_text.setText("");
						amount_credit__text.setText("");
						JOptionPane.showMessageDialog(deposit_button, "Amount is credited to your account succesfully");
						User_account_window.splitPane.setRightComponent(new User_account_right());
					}
				}
				else{
					customer_id_text.setText("");
					account_no_text.setText("");
					JOptionPane.showMessageDialog(deposit_button, "transaction not possible, Please try after some time");
					User_account_window.splitPane.setRightComponent(new User_account_right());
				}
			}
			else{
				customer_id_text.setText("");
				account_no_text.setText("");
				JOptionPane.showMessageDialog(deposit_button, "please enter valid credentials");
			}
			}
		});
		deposit_button.setFont(new Font("Tahoma", Font.BOLD, 13));
		deposit_button.setForeground(Color.BLUE);
		deposit_button.setBounds(475, 371, 154, 31);
		panel.add(deposit_button);
		
		JPanel cashwithdrawl_button = new JPanel();
		tabbedPane.addTab("Withdrawl Cash", null, cashwithdrawl_button, null);
		cashwithdrawl_button.setLayout(null);
		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon("C:\\Users\\vishant thakur\\workspace\\Surya_db\\src\\com\\images\\ICICI.jpg"));
		label.setBounds(462, 34, 283, 104);
		cashwithdrawl_button.add(label);
		
		customer_id1_text = new JTextField();
		customer_id1_text.setFont(new Font("Dialog", Font.PLAIN, 12));
		customer_id1_text.setColumns(10);
		customer_id1_text.setBounds(569, 168, 201, 20);
		cashwithdrawl_button.add(customer_id1_text);
		
		account_no1_text = new JTextField();
		account_no1_text.setFont(new Font("Dialog", Font.PLAIN, 12));
		account_no1_text.setColumns(10);
		account_no1_text.setBounds(569, 223, 201, 20);
		cashwithdrawl_button.add(account_no1_text);
		
		Txn1_text = new JTextField();
		Txn1_text.setForeground(Color.BLACK);
		Txn1_text.setFont(new Font("Dialog", Font.PLAIN, 12));
		Txn1_text.setColumns(10);
		Txn1_text.setBounds(569, 279, 201, 20);
		cashwithdrawl_button.add(Txn1_text);
		Txn1_text.setText(sdf.format(date));
		
		JLabel customer_id1_lbl = new JLabel("Customer ID :");
		customer_id1_lbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		customer_id1_lbl.setBounds(425, 168, 121, 20);
		cashwithdrawl_button.add(customer_id1_lbl);
		
		JLabel account_no1_lbl = new JLabel("Account No :");
		account_no1_lbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		account_no1_lbl.setBounds(425, 223, 121, 20);
		cashwithdrawl_button.add(account_no1_lbl);
		
		JLabel Txn1_lbl = new JLabel("Txn Date&Time :");
		Txn1_lbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		Txn1_lbl.setBounds(425, 279, 121, 20);
		cashwithdrawl_button.add(Txn1_lbl);
		
		amount_debit_text = new JTextField();
		amount_debit_text.setForeground(Color.BLUE);
		amount_debit_text.setFont(new Font("Dialog", Font.PLAIN, 12));
		amount_debit_text.setColumns(10);
		amount_debit_text.setBounds(569, 330, 201, 20);
		cashwithdrawl_button.add(amount_debit_text);
		
		JLabel amount_withdrawl_lbl = new JLabel(" Amount(in Rs) :");
		amount_withdrawl_lbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		amount_withdrawl_lbl.setBounds(425, 330, 121, 20);
		cashwithdrawl_button.add(amount_withdrawl_lbl);
		
		JButton withdrawl_button = new JButton("Withdrawl Cash");
		withdrawl_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int customer_id1=Integer.parseInt(customer_id1_text.getText());
				int  account_no1=Integer.parseInt(account_no1_text.getText());
				int amount_debit1=Integer.parseInt(amount_debit_text.getText());
				String txn_date1=Txn1_text.getText();
				Transaction_info info1=new Transaction_info();
				info1.setCustomer_id(customer_id1);
				info1.setAccount_no(account_no1);
				info1.setTransaction_date(txn_date1);
				info1.setDebit_amount(amount_debit1);
				Debit_transaction_history_insertion_DAO dthi=new Debit_transaction_history_insertion_DAO();
				Withdrawl_money_DAO wmd=new Withdrawl_money_DAO();
	           if(wmd.autheticate_debit(info1)){
	        	   if(wmd.get_new_balance1(info1)){
	        		   if(dthi.get_transaction_insertion(info1)){
	        		   customer_id1_text.setText("");
		        	   account_no1_text.setText("");
		        	   amount_debit_text.setText("");
		        	   Txn1_text.setText("");
		        	   JOptionPane.showMessageDialog(withdrawl_button, "Amount is debited from your account successfully");
		        	   User_account_window.splitPane.setRightComponent(new User_account_right());
	        	   }
	        	   }
	        	   else{
	        		   customer_id1_text.setText("");
		        	   account_no1_text.setText("");
		        	   amount_debit_text.setText("");
		        	   JOptionPane.showMessageDialog(withdrawl_button, "You don't have sufficient balance in your account to debit");
	        	   }
	           }
	           else{
	        	   customer_id1_text.setText("");
	        	   account_no1_text.setText("");
	        	   JOptionPane.showMessageDialog(withdrawl_button, "Please enter valid credentials");
	           }
			}
		});
		withdrawl_button.setForeground(Color.BLUE);
		withdrawl_button.setFont(new Font("Tahoma", Font.BOLD, 13));
		withdrawl_button.setBounds(518, 387, 176, 32);
		cashwithdrawl_button.add(withdrawl_button);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Transfer Money", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("From :");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(256, 209, 71, 22);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblTo = new JLabel("To :");
		lblTo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTo.setForeground(Color.RED);
		lblTo.setBounds(256, 392, 71, 22);
		panel_2.add(lblTo);
		
		JLabel customer_id2_lbl = new JLabel("Customer ID :");
		customer_id2_lbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		customer_id2_lbl.setBounds(397, 210, 120, 22);
		panel_2.add(customer_id2_lbl);
		
		JLabel account_no2_lbl = new JLabel("Account No :");
		account_no2_lbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		account_no2_lbl.setBounds(397, 252, 120, 22);
		panel_2.add(account_no2_lbl);
		
		JLabel amount1_lbl = new JLabel("Amount(in Rs):");
		amount1_lbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		amount1_lbl.setBounds(397, 297, 120, 22);
		panel_2.add(amount1_lbl);
		
		JLabel customer_id3_lbl = new JLabel("Customer ID :");
		customer_id3_lbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		customer_id3_lbl.setBounds(397, 394, 123, 22);
		panel_2.add(customer_id3_lbl);
		
		JLabel account_no4_lbl = new JLabel("Account No :");
		account_no4_lbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		account_no4_lbl.setBounds(399, 443, 121, 22);
		panel_2.add(account_no4_lbl);
		
		JLabel Txn2_lbl = new JLabel("Txn Date&Time :");
		Txn2_lbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		Txn2_lbl.setBounds(397, 342, 120, 22);
		panel_2.add(Txn2_lbl);
		
		JButton transfer_money_button = new JButton("Transfer Money");
		transfer_money_button.setForeground(new Color(0, 0, 139));
		transfer_money_button.setFont(new Font("Tahoma", Font.BOLD, 13));
		transfer_money_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int sender_customer_id2=Integer.parseInt(customer_id2_text.getText());
				int  sender_account_no2=Integer.parseInt(account_no2_text.getText());
				int amount_transfer=Integer.parseInt(amount1_text.getText());
				int rec_customer_id2=Integer.parseInt(customer_id3_text.getText());
				int  rec_account_no2=Integer.parseInt(account_no3_text.getText());
				String txn_date2=Txn2_text.getText();
				Transaction_info info3=new Transaction_info();
				info3.setAccount_no(sender_account_no2);
				info3.setCustomer_id(sender_customer_id2);
				info3.setTransaction_date(txn_date2);
				info3.setReceiver_Account_no(rec_account_no2);
				info3.setReceiver_Customer_id(rec_customer_id2);
				info3.setTransfer_amount(amount_transfer);
				Tansfer_Transaction_history_DAO tthd=new Tansfer_Transaction_history_DAO();
				Sender_Credit_Transfer_DAO sctd=new Sender_Credit_Transfer_DAO();
				Reciever_getcredit_transfer_DAO rgtd=new Reciever_getcredit_transfer_DAO();
		  if((sender_customer_id2!=rec_customer_id2)&&(sender_account_no2!=rec_account_no2)){
			  if(sctd.autheticate_debit(info3)&&(rgtd.autheticate_reciever_transfer(info3))){
				if(sctd.get_new_balance1(info3)&&(rgtd.get_new_balance(info3))){
				  if(tthd.get_transfer_transaction_insertion(info3)){
					  customer_id2_text.setText("");
					  account_no2_text.setText("");
					  customer_id3_text.setText("");
					  account_no3_text.setText("");
					  amount1_text.setText("");
					  Txn2_text.setText("");
					  JOptionPane.showMessageDialog(transfer_money_button, "Amount is transferred successfully");
					  User_account_window.splitPane.setRightComponent(new User_account_right());
				  }
				}
				else{
					amount1_text.setText("");
					JOptionPane.showMessageDialog(transfer_money_button, "You don't have sufficient balance in your account to Transfer");
				}
				  
				  
			  }
			  else{
				  customer_id2_text.setText("");
				  account_no2_text.setText("");
				  customer_id3_text.setText("");
				  account_no3_text.setText("");
				  JOptionPane.showMessageDialog(transfer_money_button, "Please check your credentials");
			  }
			  
			  
		  }
		  else{
			  customer_id2_text.setText("");
			  account_no2_text.setText("");
			  customer_id3_text.setText("");
			  account_no3_text.setText("");
			  JOptionPane.showMessageDialog(transfer_money_button,"Sender and receiever should not be same Please enter different credentials ");
		  }
			}
		});
		transfer_money_button.setBounds(487, 520, 210, 29);
		panel_2.add(transfer_money_button);
		
		customer_id2_text = new JTextField();
		customer_id2_text.setFont(new Font("Dialog", Font.PLAIN, 12));
		customer_id2_text.setBounds(561, 211, 193, 20);
		panel_2.add(customer_id2_text);
		customer_id2_text.setColumns(10);
		
		account_no2_text = new JTextField();
		account_no2_text.setFont(new Font("Dialog", Font.PLAIN, 12));
		account_no2_text.setColumns(10);
		account_no2_text.setBounds(561, 257, 193, 20);
		panel_2.add(account_no2_text);
		
		amount1_text = new JTextField();
		amount1_text.setForeground(Color.BLUE);
		amount1_text.setFont(new Font("Dialog", Font.PLAIN, 12));
		amount1_text.setColumns(10);
		amount1_text.setBounds(561, 299, 193, 20);
		panel_2.add(amount1_text);
		
		Txn2_text = new JTextField();
		Txn2_text.setFont(new Font("Dialog", Font.PLAIN, 12));
		Txn2_text.setColumns(10);
		Txn2_text.setBounds(561, 344, 193, 20);
		panel_2.add(Txn2_text);
		
		
		Txn2_text.setText(sdf.format(date));
		
		customer_id3_text = new JTextField();
		customer_id3_text.setFont(new Font("Dialog", Font.PLAIN, 12));
		customer_id3_text.setColumns(10);
		customer_id3_text.setBounds(561, 395, 193, 20);
		panel_2.add(customer_id3_text);
		
		account_no3_text = new JTextField();
		account_no3_text.setFont(new Font("Dialog", Font.PLAIN, 12));
		account_no3_text.setColumns(10);
		account_no3_text.setBounds(561, 444, 193, 20);
		panel_2.add(account_no3_text);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setIcon(new ImageIcon("C:\\Users\\vishant thakur\\workspace\\Surya_db\\src\\com\\images\\ICICI.jpg"));
		label_1.setBounds(430, 54, 281, 105);
		panel_2.add(label_1);

	}
}
