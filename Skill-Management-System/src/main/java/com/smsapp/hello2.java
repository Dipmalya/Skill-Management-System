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
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
public class hello2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	public int var,count=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hello2 frame = new hello2();
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
	public hello2() {
		setResizable(false);
		setTitle("Employee Record");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0,0,1366,768);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 74, 1336, 597);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		/*Connection myCon = null;
		PreparedStatement mySmt = null;
		ResultSet rs = null;*/
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ALPHA", "tensbit");
			PreparedStatement smt = con.prepareStatement("select * from smsemp order by Employee_ID ASC");
			ResultSet rs = smt.executeQuery();
			while(rs.next())
				count++;
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
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
				
				JPanel panel = new JPanel();
				panel.setBackground(new Color(51, 51, 102));
				panel.setBounds(20, 682, 1336, 75);
				contentPane.add(panel);
				panel.setLayout(null);
				
				JButton btnNewButton = new JButton("UPDATE");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try{
							var=Integer.parseInt(JOptionPane.showInputDialog("Enter the Employee ID "));
							if(var <= count && var > 0)
							{
								helloUpdate hup = new helloUpdate(var);
								hup.setVisible(true);
							}
							else
								JOptionPane.showMessageDialog(null,"Employee ID does not exist");
						}
						catch(Exception e0)
						{
							//e0.printStackTrace();
							JOptionPane.showMessageDialog(null,"Please enter proper Employee ID");
						}
				   }
				});
				btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
				btnNewButton.setBounds(24, 11, 191, 43);
				panel.add(btnNewButton);
				
				JButton btnNewButton_1 = new JButton("DELETE");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try{
							int go=Integer.parseInt(JOptionPane.showInputDialog("Enter the Employee ID "));
							if(go<=table.getRowCount()&&go>0)
							{	
								try{
									Class.forName("oracle.jdbc.driver.OracleDriver");
									Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ALPHA", "tensbit");
									PreparedStatement smt = con.prepareStatement("Delete from smsemp where Employee_ID = ?");
									smt.setInt(1,go);
									smt.executeUpdate();
									smt = con.prepareStatement("Select * from smsemp order by Employee_ID ASC");
									ResultSet rs = smt.executeQuery();
									table.setModel(DbUtils.resultSetToTableModel(rs));
									con.close();
								}
								catch(Exception e)
								{
									//e.printStackTrace();
									JOptionPane.showMessageDialog(null,"Employee ID does not exist");
								}
							}
							else
								JOptionPane.showMessageDialog(null,"Employee ID does not exist");
						}
						catch(Exception ed)
						{
							//ed.printStackTrace();
							JOptionPane.showMessageDialog(null,"Employee ID does not exist");
						}
					}
				});
				btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
				btnNewButton_1.setBounds(317, 11, 191, 43);
				panel.add(btnNewButton_1);
				
				final JComboBox<String> comboBox = new JComboBox<String>();
				comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
				comboBox.setBounds(1090, 20, 218, 28);
				panel.add(comboBox);
				comboBox.addItem("Any");
				comboBox.addItem("JAVA");
				comboBox.addItem("C++");
				comboBox.addItem("PHP");
				comboBox.addItem("ANDROID");
				comboBox.addItem("HADOOP");
				comboBox.addItemListener(new ItemChangeListener());
				JLabel lblSearchBySkill = new JLabel("SEARCH BY SKILL");
				lblSearchBySkill.setForeground(new Color(255, 255, 255));
				lblSearchBySkill.setFont(new Font("Tahoma", Font.BOLD, 18));
				lblSearchBySkill.setBounds(893, 12, 168, 43);
				panel.add(lblSearchBySkill);
				
				JButton btnNewButton_2 = new JButton("REFRESH");
				btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try
						{
							Class.forName("oracle.jdbc.driver.OracleDriver");
							Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ALPHA", "tensbit");
							PreparedStatement smt = con.prepareStatement("Select * from smsemp order by Employee_ID ASC");
							ResultSet rs = smt.executeQuery();
							table.setModel(DbUtils.resultSetToTableModel(rs));
							con.close();
						}
						catch(Exception eq)
						{
							eq.printStackTrace();
						}
						comboBox.setSelectedIndex(0);
						
					}
				});
				btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
				btnNewButton_2.setBounds(609, 11, 168, 43);
				panel.add(btnNewButton_2);
				
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
				
				JLabel label = new JLabel("");
				label.setIcon(new ImageIcon("C:\\Users\\Dipmalya Sen\\workspace\\SpamMail\\img\\37051357-dark-blue-wallpaper.jpg"));
				label.setBounds(0,0,1366,768);
				contentPane.add(label);
				/*while(rs.next()){
					System.out.println(rs.getString(1));
				}*/
				
				
	}
	public void refresh()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ALPHA", "tensbit");
			PreparedStatement smt = con.prepareStatement("Select * from smsemp order by Employee_ID ASC");
			ResultSet rs = smt.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			con.close();
			System.out.println("1");
		}
		catch(Exception eq)
		{
			eq.printStackTrace();
		}
		this.dispose();
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
						PreparedStatement smt = con.prepareStatement("select * from smsemp where Skill = ? order by Employee_ID ASC");
						smt.setString(1,course);
						ResultSet rs = smt.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					}
					else
					{
						PreparedStatement smt = con.prepareStatement("select * from smsemp order by Employee_ID ASC");
						ResultSet rs = smt.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					}
					con.close();
				}
	           catch(Exception e1) {
	            JOptionPane.showMessageDialog(null, "Cannot Filter with "+course);
	           }
	        }
		}
	}
}

