package com.next;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.bo.User_info;
import com.dao.Change_Password_DAO;
import com.dao.Secret_question_DAO;
import com.dao.Update_Password_DAO;
import com.main.Login;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Forgot_password {

	private JFrame frmForgotPassword;
	private static JTextField Secret_Ques_text;
	private JTextField Secret_Answer_text;
	private static JTextField unt2;
	public static Forgot_password window; 
	/**
	 * Launch the application.
	 */
	
			public void Forgot_password_invoke0() {
				try {
					 window = new Forgot_password();
					window.frmForgotPassword.setVisible(true);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		
   public static void Secret_Question_invoke() {
	   unt2.setText(Login.username1);
	   
         User_info user=new User_info();
         user.setUser_name(unt2.getText());
         Secret_question_DAO sqd=new Secret_question_DAO();
	     if(sqd.authenticate_secret_question(user)){
			//unt2.setText(Login.username);
			 Secret_Ques_text.setText(Secret_question_DAO.Question);
		}    
    	 
	 }
	

	/**
	 * Create the application.
	 */
	public Forgot_password() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmForgotPassword = new JFrame();
		frmForgotPassword.setTitle(" Forgot Password");
		frmForgotPassword.setBounds(100, 100, 450, 341);
		frmForgotPassword.getContentPane().setBackground(new Color(240, 255, 255));;
		frmForgotPassword.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmForgotPassword.getContentPane().setLayout(null);
		
		JLabel Secret_Ques = new JLabel("Your Secret Question :");
		Secret_Ques.setBounds(27, 79, 133, 20);
		frmForgotPassword.getContentPane().add(Secret_Ques);
		
		JLabel Secret_Answer = new JLabel("Your Secret Answer :");
		Secret_Answer.setBounds(27, 137, 133, 20);
		frmForgotPassword.getContentPane().add(Secret_Answer);
		
		Secret_Ques_text = new JTextField();
		Secret_Ques_text.setForeground(Color.BLUE);
		Secret_Ques_text.setBounds(182, 79, 242, 20);
		frmForgotPassword.getContentPane().add(Secret_Ques_text);
		Secret_Ques_text.setColumns(10);
		
		Secret_Answer_text = new JTextField();
		Secret_Answer_text.setForeground(Color.BLUE);
		Secret_Answer_text.setColumns(10);
		Secret_Answer_text.setBounds(182, 137, 242, 20);
		frmForgotPassword.getContentPane().add(Secret_Answer_text);
		
		JLabel lblWarning = new JLabel("Please enter correct Question and Answer");
		lblWarning.setForeground(Color.RED);
		lblWarning.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarning.setBounds(96, 228, 250, 14);
		frmForgotPassword.getContentPane().add(lblWarning);
		lblWarning.setVisible(false);
		
		JButton btnNewButton_1 = new JButton("Change Password & Sign In");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username=unt2.getText();
				String new_password=Secret_Ques_text.getText();
				User_info user2=new User_info();
				user2.setUser_name(username);
				user2.setUser_password(new_password);
				Update_Password_DAO upd=new Update_Password_DAO();
				if(upd.authenticate_password(user2)){
					User_account_window window1 = new User_account_window();
					  window1.invoke_user_account();
				     // frmForgotPassword.getContentPane().setVisible(false);
						window.frmForgotPassword.setVisible(false);
						
				}
			    }
		});
		btnNewButton_1.setBounds(123, 110, 199, 23);
		frmForgotPassword.getContentPane().add(btnNewButton_1);
		btnNewButton_1.setVisible(false);
		
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Secret_question=Secret_Ques_text.getText();
				String Secret_answer=Secret_Answer_text.getText();
				String username=unt2.getText();
				User_info user1=new User_info();
				user1.setSecret_ques(Secret_question);
				user1.setUser_name(username);
				user1.setSecret_answer(Secret_answer);
				Change_Password_DAO cpd=new Change_Password_DAO();
				if(cpd.authenticate_change_password(user1)){
					Secret_Ques.setText("New Password :");
					Secret_Answer.setVisible(false);
					Secret_Answer_text.setVisible(false);
					btnNewButton.setVisible(false);
					btnNewButton_1.setVisible(true);
				    lblWarning.setVisible(false);
				    Secret_Ques_text.setText("");
				}
				else{
					Secret_Ques_text.setText("");
					Secret_Answer_text.setText("");
					lblWarning.setVisible(true);
				}			
			
				}
			});
		btnNewButton.setBounds(167, 184, 89, 23);
		frmForgotPassword.getContentPane().add(btnNewButton);
        		
		
		
		JLabel lblUsername = new JLabel("Username  :");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsername.setBounds(27, 40, 115, 14);
		frmForgotPassword.getContentPane().add(lblUsername);
		
		unt2 = new JTextField();
		unt2.setBounds(182, 38, 242, 20);
		frmForgotPassword.getContentPane().add(unt2);
		unt2.setColumns(10);
		
		
	}
}
