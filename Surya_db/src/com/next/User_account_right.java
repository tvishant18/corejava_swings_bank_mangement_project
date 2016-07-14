package com.next;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

public class User_account_right extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	public static JLabel date_label;
	
	public User_account_right() {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 23, 1096, 616);
		tabbedPane.setForeground(Color.BLACK);
		add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("New tab", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\vishant thakur\\workspace\\Surya_db\\src\\com\\images\\ICICI 2.JPG"));
		lblNewLabel.setBounds(178, 11, 756, 566);
		panel.add(lblNewLabel);
		
		 date_label = new JLabel("New label");
		date_label.setBounds(948, 11, 168, 17);
		date_label.setForeground(new Color(255, 0, 0));
		date_label.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(date_label);
		Date date=new Date();
		
		SimpleDateFormat sdf=new SimpleDateFormat("E  dd/MM/yyyy  HH:mm:ss" );
         date_label.setText(sdf.format(date));
        
        
       
	}
}
