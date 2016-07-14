package com.next;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.bo.Update_password_info;
import com.dao.Update_Password1_DAO;
import com.main.Login;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Update_User_Password_window1 extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JTextField unt4_text;
	private JPasswordField old_passwordField;
	private JPasswordField new_passwordField;
	private JPasswordField new1_passwordField;

	/**
	 * Create the panel.
	 */
	public Update_User_Password_window1() {
		setLayout(null);
		
		JLabel username4_lbl = new JLabel("Username :");
		username4_lbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		username4_lbl.setBounds(413, 147, 107, 20);
		add(username4_lbl);
		
		JLabel lblOldPassword = new JLabel("Old Password :");
		lblOldPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOldPassword.setBounds(413, 221, 107, 20);
		add(lblOldPassword);
		
		JLabel lblNewPassword = new JLabel("New Password :");
		lblNewPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewPassword.setBounds(413, 297, 107, 20);
		add(lblNewPassword);
		
		JLabel lblRetypePassword = new JLabel("Re-Type  Password :");
		lblRetypePassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRetypePassword.setBounds(413, 372, 107, 20);
		add(lblRetypePassword);
		
		unt4_text = new JTextField();
		unt4_text.setBounds(530, 147, 227, 20);
		add(unt4_text);
		unt4_text.setColumns(10);
		unt4_text.setText(Login.username1);
		
		old_passwordField = new JPasswordField();
		old_passwordField.setBounds(530, 221, 227, 20);
		add(old_passwordField);
		
		new_passwordField = new JPasswordField();
		new_passwordField.setBounds(530, 297, 227, 20);
		add(new_passwordField);
		
		new1_passwordField = new JPasswordField();
		new1_passwordField.setBounds(530, 372, 227, 20);
		add(new1_passwordField);
		
		JButton update_password = new JButton("Update New Password");
		update_password.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username4=unt4_text.getText();
				String old_password=new String(old_passwordField.getPassword());
				String new_password=new String(new_passwordField.getPassword());
				String retype_password=new String(new1_passwordField.getPassword());
				Update_password_info user2=new Update_password_info();
				user2.setUsername(username4);
				user2.setOld_password(old_password);
				user2.setNew_password(new_password);
				user2.setRetype_password(retype_password);
				Update_Password1_DAO upd=new Update_Password1_DAO ();
                if(upd.authenticate_old_password(user2)){
                	if(upd.authenticate_password(user2)){
                		unt4_text.setText("");
                		old_passwordField.setText("");
                		new_passwordField.setText("");
                		new1_passwordField.setText("");
                		//User_account_window window = new User_account_window();	
                       // window.invoke_user_account();
                		JOptionPane.showMessageDialog(update_password, "Your password is updated Successfully");
                		User_account_window.splitPane.setRightComponent(new User_account_right()); 
                	
                	}
                	else{
                		new_passwordField.setText("");
                		new1_passwordField.setText("");
                	JOptionPane.showMessageDialog(update_password, "please enter a different password and match both new password fields");	
                	}
                }
                else{
                	old_passwordField.setText("");
                	JOptionPane.showMessageDialog(update_password,"please enter correct old password");
                }
              //  User_account_window.splitPane.setRightComponent(new Transaction_window());
			}
		});
		update_password.setFont(new Font("Tahoma", Font.BOLD, 11));
		update_password.setForeground(Color.BLUE);
		update_password.setBounds(488, 432, 227, 23);
		add(update_password);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\vishant thakur\\git\\corejava_swings_bank_mangement_project\\Surya_db\\src\\com\\images\\ICICI.jpg"));
		label.setBounds(447, 11, 288, 110);
		add(label);
		//setVisible( false);
		
	}

}
