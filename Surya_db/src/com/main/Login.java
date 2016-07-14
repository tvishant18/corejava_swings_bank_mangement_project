package com.main;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.exception.Business_Exception;
import com.next.Forgot_password;
import com.next.User_account_window;
import com.service.User_Service;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import com.bo.User_info;
import java.awt.SystemColor;

public class Login {
    
	private JFrame frame;
	private static JTextField unt1;
	private JPasswordField pt1;
    public static String username1;
    public static Login window;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 window = new Login();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		frame.setForeground(new Color(0, 128, 128));
		frame.setBounds(100, 100, 342, 430);
	    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    JFrame.setDefaultLookAndFeelDecorated(true);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsername.setBounds(31, 156, 84, 21);
		frame.getContentPane().add(lblUsername);
		
		unt1 = new JTextField();
		unt1.setBounds(110, 156, 184, 20);
		frame.getContentPane().add(unt1);
		unt1.setColumns(10);
		
		 JLabel lblNewLabel = new JLabel("Please enter a correct password");
	  		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
	  		lblNewLabel.setForeground(Color.RED);
	  		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	  		lblNewLabel.setBounds(31, 337, 262, 14);
	  		frame.getContentPane().add(lblNewLabel);
	  		 lblNewLabel.setVisible(false);
		
		JButton btnNewButton = new JButton("Sign In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					username1=unt1.getText();
				String username=unt1.getText();
				String password=new String(pt1.getPassword());
				User_info user=new User_info();
				user.setUser_name(username);
				user.setUser_password(password);
				User_Service service=new User_Service(); 
				if(service.authenticate_user(user)){
                    
					User_account_window window1 = new User_account_window();
	                window1.invoke_user_account();
	                User_account_window.invoke_user();
					pt1.setText("");
	                unt1.setText("");
	               
	                lblNewLabel.setVisible(false);
	                window.frame.setVisible(false);
	               // frame.getContentPane().setVisible(false);
	            }
			else{
				    	  pt1.setText("");
				    	  lblNewLabel.setVisible(true);
				    	 }			
				}catch(Business_Exception e){
					lblNewLabel.setText(Business_Exception.error);
					lblNewLabel.setVisible(true);
				}
				}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBounds(60, 243, 184, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Forgot Password ?");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				username1=unt1.getText();
				Forgot_password window1 = new Forgot_password();
				window1.Forgot_password_invoke0();
				Forgot_password.Secret_Question_invoke();
				//frame.getContentPane().setVisible(false);
				 window.frame.setVisible(false); 
			}
		});
		btnNewButton_1.setForeground(new Color(255, 0, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setBounds(60, 279, 184, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		pt1 = new JPasswordField();
		pt1.setBounds(110, 195, 184, 20);
		frame.getContentPane().add(pt1);
		
		JLabel lblPassword = new JLabel("Password  :");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setBounds(31, 195, 84, 21);
		frame.getContentPane().add(lblPassword);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\vishant thakur\\git\\corejava_swings_bank_mangement_project\\Surya_db\\src\\com\\images\\ICICI.jpg"));
		label.setBounds(31, 11, 290, 112);
		frame.getContentPane().add(label);
		
	
		
	  
	}
}
