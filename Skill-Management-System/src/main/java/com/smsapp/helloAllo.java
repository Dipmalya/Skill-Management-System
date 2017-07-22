package com.smsapp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class helloAllo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTextField textField;
	private JButton btnAllocateResources;
	public String rest;
	public int al,hk,jah=0,test,alTest;
	boolean yes;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					helloAllo frame = new helloAllo();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	int checkRes()
	{
		int ch = 0;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ALPHA", "tensbit");
			PreparedStatement smt = con.prepareStatement("select * from smsproject where Project_ID = ?");
			smt.setString(1,textField.getText());
			ResultSet rs = smt.executeQuery();
			while(rs.next())
			{
				ch=rs.getInt(4);
			}
			if(ch<=0)
			{
				ch=999;
			}
			else
				ch=1;
			
		}
		catch(Exception e10)
		{
			e10.printStackTrace();
		}
		return ch;
	}
	

	/**
	 * Create the frame.
	 */
	public helloAllo() {
		setResizable(false);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setTitle("Resource Allocation");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0,0, 1366,768);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 98, 843, 308);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ALPHA", "tensbit");
			PreparedStatement smt = con.prepareStatement("select * from smsemp order by Employee_ID ASC");
			ResultSet rs = smt.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(21, 491, 843, 228);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ALPHA", "tensbit");
			PreparedStatement smt = con.prepareStatement("select * from smsproject order by Project_ID ASC");
			ResultSet rs = smt.executeQuery();
			table_1.setModel(DbUtils.resultSetToTableModel(rs));
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		JLabel lblEmployeeRecord = new JLabel("EMPLOYEE RECORD");
		lblEmployeeRecord.setForeground(Color.WHITE);
		lblEmployeeRecord.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEmployeeRecord.setBounds(21, 41, 235, 36);
		contentPane.add(lblEmployeeRecord);
		
		JLabel lblProjectDetails = new JLabel("PROJECT DETAILS");
		lblProjectDetails.setForeground(Color.WHITE);
		lblProjectDetails.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblProjectDetails.setBounds(21, 428, 217, 36);
		contentPane.add(lblProjectDetails);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 51, 102));
		panel.setBounds(966, 98, 328, 431);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(89, 81, 114, 29);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblSearchByProject = new JLabel("SEARCH BY PROJECT ID");
		lblSearchByProject.setForeground(new Color(253, 245, 230));
		lblSearchByProject.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSearchByProject.setBounds(51, 26, 229, 37);
		panel.add(lblSearchByProject);
		
		JButton btnNewButton = new JButton("CHECK RESOURCES");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try
			{
				if(textField.getText().isEmpty())
				{
					try{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ALPHA", "tensbit");
						PreparedStatement smt = con.prepareStatement("select * from smsproject order by Project_ID ASC");
						ResultSet rs = smt.executeQuery();
						table_1.setModel(DbUtils.resultSetToTableModel(rs));
						smt = con.prepareStatement("select * from smsemp order by Employee_ID ASC");
						rs = smt.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						con.close();
					}
					catch(Exception eal)
					{
						eal.printStackTrace();
						JOptionPane.showMessageDialog(null,"Please enter proper Project ID");
					}
					textField.setText(null);
					btnAllocateResources.setEnabled(false);
					JOptionPane.showMessageDialog(null,"Please enter proper Project ID");
					
				}
				else if(Integer.parseInt(textField.getText())<=table_1.getRowCount() && Integer.parseInt(textField.getText())>0)
				{
					try
					{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ALPHA", "tensbit");
						PreparedStatement smt = con.prepareStatement("select * from smsproject where Project_ID = ?");
						smt.setString(1,textField.getText());
						ResultSet rs = smt.executeQuery();
						while(rs.next())
						{
							rest = rs.getString(3);
							test=rs.getInt(4);
						}
						rs = smt.executeQuery();
						table_1.setModel(DbUtils.resultSetToTableModel(rs));
						if(test>0)
							btnAllocateResources.setEnabled(true);
						con.close();
					}
					catch(Exception e1) {
						JOptionPane.showMessageDialog(null,"Please enter proper Project ID");
						e1.printStackTrace();
					}
					try
					{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ALPHA", "tensbit");
						PreparedStatement smt = con.prepareStatement("select * from smsemp where Skill = ? and Allocation_Status = ?");
						smt.setString(1,rest);
						smt.setString(2,"No");
						ResultSet rs = smt.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						//btnAllocateResources.setEnabled(true);
						con.close();
					}
					catch(Exception e1) {
						JOptionPane.showMessageDialog(null,"Please enter proper Project ID");
						e1.printStackTrace();
					}
					
				}
				else
					JOptionPane.showMessageDialog(null,"Project ID does not exist");
				
			}
				catch(Exception e6)
				{
					JOptionPane.showMessageDialog(null,"Please enter proper Project ID");
					e6.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(61, 165, 197, 48);
		panel.add(btnNewButton);
		
		btnAllocateResources = new JButton("ALLOCATE RESOURCES");
		btnAllocateResources.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int op = checkRes();
				if(table.getRowCount()!=0&&op!=999)
				{
					int r = Integer.parseInt(JOptionPane.showInputDialog("Enter the Employee ID you want to allocate."));
					try{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ALPHA", "tensbit");
						PreparedStatement smt = con.prepareStatement("update smsemp set Allocation_Status = ? where Employee_ID = ? and Skill = ?");
						smt.setString(1,"Yes");
						smt.setInt(2,r);
						smt.setString(3,rest);
						int i=smt.executeUpdate();
						smt = con.prepareStatement("select * from smsemp where Allocation_Status = ? and Skill = ?");
						smt.setString(1,"No");
						smt.setString(2,rest);
						ResultSet rs = smt.executeQuery();
						while(rs.next())
						{
							alTest = rs.getInt(1);
						}
						yes =true;
						table.setModel(DbUtils.resultSetToTableModel(rs));
						if(i==0)
						{
							JOptionPane.showMessageDialog(null,"This Employee does not match the required Skill");
							jah=999;
						}
						
						al = Integer.parseInt(textField.getText());
						smt = con.prepareStatement("select * from smsproject where Project_ID = ?");
						smt.setInt(1,al);
						rs = smt.executeQuery();
						while(rs.next())
						{	
							if(jah!=999)
							{
								hk = rs.getInt(4);
								if(hk>0)
								{
									hk--;
									System.out.println(hk);
								}
								else
								{
									JOptionPane.showMessageDialog(null,"This Project doesnot require any more Resource");
								}
							}
							else
							{
								hk = rs.getInt(4);
							}	
						}
						smt = con.prepareStatement("update smsproject set Resource_Needed = ? where Project_ID = ?");
						smt.setInt(1,hk);
						smt.setInt(2,al);
						smt.executeUpdate();
						
						smt = con.prepareStatement("select * from smsproject where Project_ID = ?");
						smt.setInt(1,al);
						rs = smt.executeQuery();
						
						table_1.setModel(DbUtils.resultSetToTableModel(rs));
						
						con.close();
						}
					catch(Exception e1) {
						JOptionPane.showMessageDialog(null, "This Employee does not match the required Skill");
						e1.printStackTrace();
		           }
					
				}
				else
					JOptionPane.showMessageDialog(null,"No available employee meeting the required criteria. Please ask for new recruitment");
			}
		});
		btnAllocateResources.setEnabled(false);
		btnAllocateResources.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAllocateResources.setBounds(51, 361, 229, 48);
		panel.add(btnAllocateResources);
		
		JButton btnNewButton_1 = new JButton("REFRESH");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ALPHA", "tensbit");
					PreparedStatement smt = con.prepareStatement("select * from smsproject order by Project_ID ASC");
					ResultSet rs = smt.executeQuery();
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
					smt = con.prepareStatement("select * from smsemp order by Employee_ID ASC");
					rs = smt.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					con.close();
				}
				catch(Exception eal)
				{
					eal.printStackTrace();
				}
				textField.setText(null);
				btnAllocateResources.setEnabled(false);
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnNewButton_1.setBounds(61, 252, 197, 48);
		panel.add(btnNewButton_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Dipmalya Sen\\workspace\\SpamMail\\img\\37051357-dark-blue-wallpaper.jpg"));
		label.setBounds(0, 0, 1366, 768);
		contentPane.add(label);
		
		
		
		JButton btnNewButton3 = new JButton("X");
		btnNewButton3.setBackground(new Color(255, 255, 255));
		btnNewButton3.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton3.setBounds(1321, 0, 45, 36);
		btnNewButton3.addActionListener( new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    	dispose();
		    }
		    });
		contentPane.add(btnNewButton3);
	}
}
	
