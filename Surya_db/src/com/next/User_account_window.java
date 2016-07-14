package com.next;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.main.Login;
import com.next.Account_statement_panel;
import com.next.Record_window;
import com.next.Transaction_window;
import com.next.Update_User_Password_window1;
import com.next.User_account_right;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class User_account_window {

	private JFrame frmHome;
   public static JLabel unt3;
   public static JSplitPane splitPane;
   public static int a;
   public static int b;	
   public static User_account_window window;
   /**
	 * Launch the application.
	 */

			public void invoke_user_account() {
				try {
					window = new User_account_window();
					window.frmHome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	
	public static void invoke_user(){
		unt3.setText(Login.username1);
	}

	/**
	 * Create the application.
	 */
	public User_account_window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHome = new JFrame();
		frmHome.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmHome.setTitle("Home");
		frmHome.setBounds(100, 100, 1000, 677);
		frmHome.setExtendedState(JFrame.MAXIMIZED_BOTH);
        splitPane = new JSplitPane();
		GroupLayout groupLayout = new GroupLayout(frmHome.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(splitPane, GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(splitPane, GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		splitPane.setRightComponent(new User_account_right());
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\vishant thakur\\workspace\\Surya_db\\src\\com\\images\\Admin.png"));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		 unt3 = new JLabel("vish");
		unt3.setHorizontalAlignment(SwingConstants.CENTER);
		unt3.setForeground(new Color(138, 43, 226));
		unt3.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JButton button = new JButton("New Account");
		button.setForeground(new Color(0, 0, 139));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 // New_Account_Window window = new New_Account_Window();
				//	window.new_invoke();
				//	window.new_account_display();
					
				//	frmHome.getContentPane().setVisible(false);
				New_Account_Panel ncp=new New_Account_Panel();
				splitPane.setRightComponent(new New_Account_Panel());
				ncp.new_account_display();
				
				
				
				
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton button_1 = new JButton("Account Statement");
		button_1.setForeground(new Color(0, 0, 255));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 splitPane.setRightComponent(new Account_statement_panel());
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton button_2 = new JButton("Transaction");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				splitPane.setRightComponent( new Transaction_window());
			}
		});
		button_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton button_3 = new JButton("Record");
		button_3.setForeground(new Color(25, 25, 112));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				splitPane.setRightComponent( new Record_window());
			}
		});
		button_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton button_4 = new JButton("Change Password");
		button_4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
				unt3.getText();
				splitPane.setRightComponent(new Update_User_Password_window1());
			}
		});
		button_4.setForeground(new Color(102, 0, 0));
		button_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JButton button_5 = new JButton("Logout");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login.main(null);
				//frmHome.getContentPane().setVisible(false);
				window.frmHome.setVisible(false);
			}
		});
		button_5.setForeground(new Color(165, 42, 42));
		button_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setForeground(Color.RED);
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 15));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap(30, Short.MAX_VALUE)
							.addComponent(unt3, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(button_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
								.addComponent(button_4, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
								.addComponent(button_3, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(button, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 155, Short.MAX_VALUE)
								.addComponent(button_1, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addGap(20)
							.addComponent(button_5, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addGap(20)
							.addComponent(btnExit, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(unt3, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
					.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnExit)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		frmHome.getContentPane().setLayout(groupLayout);
	}
}
