package com.smsapp;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class helloUpdate extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	
	public helloUpdate(int v) {
		setTitle("Update Record");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 489, 477);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBackground(Color.WHITE);
		textField.setBounds(167, 42, 75, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(167, 99, 282, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(167, 161, 282, 27);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(167, 216, 282, 27);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(167, 275, 116, 27);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(167, 333, 282, 27);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblEmployeeId = new JLabel("EMPLOYEE ID");
		lblEmployeeId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmployeeId.setBounds(22, 40, 116, 27);
		contentPane.add(lblEmployeeId);
		
		JLabel lblNewLabel = new JLabel("EMPLOYEE NAME");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(22, 97, 124, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SKILL");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(22, 159, 88, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ROLE");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(22, 216, 116, 27);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblAllocationStatus = new JLabel("ALLOCATION STATUS");
		lblAllocationStatus.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAllocationStatus.setBounds(22, 273, 135, 27);
		contentPane.add(lblAllocationStatus);
		
		JLabel lblProjectEndDate = new JLabel("PROJECT END DATE");
		lblProjectEndDate.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblProjectEndDate.setBounds(22, 333, 124, 27);
		contentPane.add(lblProjectEndDate);
		
		btnNewButton = new JButton("UPDATE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int q = Integer.parseInt(textField.getText());
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ALPHA", "tensbit");
					PreparedStatement smt = con.prepareStatement("update smsemp set Skill = ?, Role = ?, Allocation_Status = ?, Project_End_Date = ? where Employee_ID = ?");
					smt.setString(1,textField_2.getText());
					smt.setString(2,textField_3.getText());
					smt.setString(3,textField_4.getText());
					smt.setString(4,textField_5.getText());
					smt.setInt(5,q);
					smt.executeUpdate();
					dispose();
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
				hello2 h2 = new hello2();
				h2.refresh();
				h2.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(138, 385, 124, 42);
		contentPane.add(btnNewButton);
		
		//hello2 h = new hello2();
		//int m = h.var;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ALPHA", "tensbit");
			PreparedStatement smt = con.prepareStatement("select * from smsemp where Employee_ID = ?");
			smt.setInt(1,v);
			ResultSet rs = smt.executeQuery();
			while(rs.next())
			{
				textField.setText(rs.getInt(1)+"");
				textField_1.setText(rs.getString(2));
				textField_2.setText(rs.getString(3));
				textField_3.setText(rs.getString(4));
				textField_4.setText(rs.getString(5));
				textField_5.setText(rs.getString(6));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
