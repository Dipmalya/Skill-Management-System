package com.smsapp;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class helloProject extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JComboBox<String> comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					helloProject frame = new helloProject();
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
	public helloProject() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setUndecorated(true);
		setResizable(false);
		setTitle("Project Record");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0,0,1366,768);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 117, 1346, 233);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
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
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ALPHA", "tensbit");
			PreparedStatement smt = con.prepareStatement("select * from smsproject order by Project_ID ASC");
			ResultSet rs = smt.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			con.close();
			
			panel = new JPanel();
			panel.setBackground(new Color(51, 51, 102));
			panel.setBounds(10, 555, 1346, 108);
			contentPane.add(panel);
			panel.setLayout(null);
			
			lblNewLabel = new JLabel("SEARCH BY SKILL");
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblNewLabel.setBounds(334, 25, 244, 49);
			panel.add(lblNewLabel);
			
			comboBox = new JComboBox<String>();
			comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
			comboBox.setBounds(588, 40, 177, 27);
			panel.add(comboBox);
			comboBox.addItem("Any");
			comboBox.addItem("JAVA");
			comboBox.addItem("C++");
			comboBox.addItem("PHP");
			comboBox.addItem("ANDROID");
			comboBox.addItem("HADOOP");
			
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon("C:\\Users\\Dipmalya Sen\\workspace\\SpamMail\\img\\37051357-dark-blue-wallpaper.jpg"));
			label.setBounds(0,0,1366,768);
			contentPane.add(label);
			comboBox.addItemListener(new ItemChangeListener());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}
	class ItemChangeListener implements ItemListener
	{
		public void itemStateChanged(ItemEvent event) {
	        if (event.getStateChange() == ItemEvent.SELECTED) {
	           Object item = event.getItem();
	           String course = item.toString();
	           try{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ALPHA", "tensbit");
					if(course!="Any")
					{	
						PreparedStatement smt = con.prepareStatement("select * from smsproject where Skill_Required = ? order by Project_ID ASC");
						smt.setString(1,course);
						ResultSet rs = smt.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					}
					else
					{
						PreparedStatement smt = con.prepareStatement("select * from smsproject order by Project_ID ASC");
						ResultSet rs = smt.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					}
					con.close();
				}
	           catch(Exception e1) {
	            //JOptionPane.showMessageDialog(null, "Cannot Filter with "+course);
	        	   e1.printStackTrace();
	           }
	        }
		}
		
	}
	
}