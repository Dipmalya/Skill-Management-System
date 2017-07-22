package com.smsapp;
import javax.swing.*;
import java.awt.*;

import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class hello1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hello1 frame = new hello1();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public hello1() {
		setResizable(false);
		setTitle("Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,1366,768);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 250));
		panel.setBounds(340, 90, 653, 264);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Dipmalya Sen\\workspace\\SpamMail\\img\\tb.jpg"));
		lblNewLabel.setBounds(22, 45, 204, 178);
		panel.add(lblNewLabel);
		
		JLabel lblSignOut = new JLabel("SIGN OUT");
		lblSignOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null, "Logged out Successfully..");
				dispose();
			}
		});
		lblSignOut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblSignOut.setForeground(new Color(0, 0, 128));
		lblSignOut.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSignOut.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignOut.setBounds(569, 11, 74, 17);
		panel.add(lblSignOut);
		
		//System.out.println(m);
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setText("WELCOME  ADMIN");
		lblNewLabel_1.setVerticalTextPosition(SwingConstants.TOP);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(267, 186, 316, 37);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(32, 178, 170));
		panel_1.setBounds(340, 395, 653, 294);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("EMPLOYEE RECORD");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				hello2 o = new hello2();
				o.setVisible(true);
				//dispose();
			}
		});
		btnNewButton_2.setBounds(90, 25, 190, 82);
		panel_1.add(btnNewButton_2);
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		
		JButton btnNewButton = new JButton("PROJECT RECORD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helloProject hpr = new helloProject();
				hpr.setVisible(true);
			}
		});
		btnNewButton.setBounds(90, 181, 190, 83);
		panel_1.add(btnNewButton);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnNewButton_3 = new JButton("REPORTING MODULE");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helloRM hrm = new helloRM();
				hrm.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(367, 24, 223, 85);
		panel_1.add(btnNewButton_3);
		btnNewButton_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton btnNewButton_1 = new JButton("RESOURCE ALLOCATION");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helloAllo ha = new helloAllo();
				ha.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(367, 183, 223, 79);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Dipmalya Sen\\workspace\\SpamMail\\img\\37051357-dark-blue-wallpaper.jpg"));
		label.setBounds(0,0,1366,768);
		contentPane.add(label);
		
		JButton btnNewButton4 = new JButton("X");
		btnNewButton4.setBackground(new Color(255, 255, 255));
		btnNewButton4.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton4.setBounds(1321, 0, 45, 36);
		btnNewButton4.addActionListener( new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    	dispose();
		    }
		    });
		contentPane.add(btnNewButton4);
	}
}
