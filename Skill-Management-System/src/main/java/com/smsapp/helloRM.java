package com.smsapp;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Cursor;
import javax.swing.ImageIcon;

public class helloRM extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public int j=0,cpp=0,had=0,and=0,ph=0;
	public int rj=0,rcpp=0,rhad=0,rand=0,rph=0;
	public int aj=0,acpp=0,ahad=0,aand=0,aph=0;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					helloRM frame = new helloRM();
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
	public helloRM() {
		setUndecorated(true);
		//setResizable(false);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(224, 45, 210, 23);
		getContentPane().add(btnNewButton);
		setTitle("Reporting Module");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(72, 61, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ALPHA", "tensbit");
			PreparedStatement smt = con.prepareStatement("select * from smsemp");
			ResultSet rs = smt.executeQuery();
			while(rs.next())
			{
				rs.getString(3);
				if(rs.getString(3).equals("JAVA"))
					j++;
				else if(rs.getString(3).equals("C++"))
					cpp++;
				else if(rs.getString(3).equals("PHP"))
					ph++;
				else if(rs.getString(3).equals("HADOOP"))
					had++;
				else if(rs.getString(3).equals("ANDROID"))
					and++;
			}
			con.close();
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
		System.out.println(j+cpp+and+had+ph);
		
		
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ALPHA", "tensbit");
			PreparedStatement smt = con.prepareStatement("select * from smsproject");
			ResultSet rs = smt.executeQuery();
			while(rs.next())
			{
				if(rs.getString(3).equals("JAVA"))
				{
					rj+=Integer.parseInt(rs.getString(4));
				}
				else if(rs.getString(3).equals("PHP"))
				{
					rph+=Integer.parseInt(rs.getString(4));
				}
				else if(rs.getString(3).equals("ANDROID"))
				{
					rand+=Integer.parseInt(rs.getString(4));
				}
				if(rs.getString(3).equals("C++"))
				{
					rcpp+=Integer.parseInt(rs.getString(4));
				}
				if(rs.getString(3).equals("HADOOP"))
				{
					rhad+=Integer.parseInt(rs.getString(4));
				}
			}
			con.close();
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
		
		
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ALPHA", "tensbit");
			PreparedStatement smt = con.prepareStatement("select * from smsemp where Allocation_Status = ?");
			smt.setString(1,"No");
			ResultSet rs = smt.executeQuery();
			while(rs.next())
			{
				if(rs.getString(3).equals("JAVA"))
				{
					aj++;
				}
				else if(rs.getString(3).equals("PHP"))
				{
					aph++;
				}
				else if(rs.getString(3).equals("ANDROID"))
				{
					aand++;
				}
				if(rs.getString(3).equals("C++"))
				{
					acpp++;
				}
				if(rs.getString(3).equals("HADOOP"))
				{
					ahad++;
				}
			}
			con.close();
		}
		catch(Exception e3)
		{
			e3.printStackTrace();
		}
		
		
		
		
		JButton btnNewButton_1 = new JButton("PIE CHART");
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultPieDataset pc = new DefaultPieDataset();
				pc.setValue("JAVA", new Integer(j));
				pc.setValue("C++", new Integer(cpp));
				pc.setValue("ANDROID", new Integer(and));
				pc.setValue("HADOOP", new Integer(had));
				pc.setValue("PHP", new Integer(ph));
				JFreeChart chart = ChartFactory.createPieChart("Employee Chart", pc, true, true, true);
				ChartFrame frame = new ChartFrame("Pie Chart", chart);
				frame.setVisible(true);
				frame.setResizable(false);
				frame.setSize(450, 500);
				frame.setLocationRelativeTo(null);

			}
		});
		btnNewButton_1.setBounds(922, 400, 173, 52);
		contentPane.add(btnNewButton_1);
		
		JButton btnBarChart = new JButton("BAR CHART");
		btnBarChart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBarChart.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBarChart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultCategoryDataset ds = new DefaultCategoryDataset();
				ds.setValue(j,"Employees","JAVA");
				ds.setValue(cpp,"Employees","C++");
				ds.setValue(and,"Employees","ANDROID");
				ds.setValue(had,"Employees","HADOOP");
				ds.setValue(ph,"Employees","PHP");
				
				JFreeChart chart = ChartFactory.createBarChart("Employee Chart", "Skill", "Resources", ds, PlotOrientation.VERTICAL,false,true,false);
				CategoryPlot p = chart.getCategoryPlot();
				p.setRangeGridlinePaint(Color.black);
				ChartFrame frame = new ChartFrame("Bar Chart",chart);
				frame.setVisible(true);
				frame.setResizable(false);
				frame.setSize(550, 500);
				frame.setLocationRelativeTo(null);
				
			}
		});
		btnBarChart.setBounds(922, 320, 173, 52);
		contentPane.add(btnBarChart);
		
		JLabel lblViewEmployeeStats = new JLabel("EMPLOYEE DASHBOARD");
		lblViewEmployeeStats.setForeground(new Color(255, 255, 255));
		lblViewEmployeeStats.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblViewEmployeeStats.setBounds(893, 207, 370, 71);
		contentPane.add(lblViewEmployeeStats);
		
		JLabel lblEmployeeStats = new JLabel("EMPLOYEE STATS");
		lblEmployeeStats.setForeground(new Color(255, 255, 255));
		lblEmployeeStats.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEmployeeStats.setBounds(172, 102, 246, 40);
		contentPane.add(lblEmployeeStats);
		
		JLabel lblJava = new JLabel("JAVA");
		lblJava.setForeground(new Color(255, 255, 255));
		lblJava.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblJava.setBounds(78, 228, 79, 30);
		contentPane.add(lblJava);
		
		JLabel lblC = new JLabel("C++");
		lblC.setForeground(new Color(255, 255, 255));
		lblC.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblC.setBounds(78, 301, 79, 40);
		contentPane.add(lblC);
		
		JLabel lblPhp = new JLabel("PHP");
		lblPhp.setForeground(new Color(255, 255, 255));
		lblPhp.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPhp.setBounds(78, 365, 79, 35);
		contentPane.add(lblPhp);
		
		JLabel lblAndroid = new JLabel("ANDROID");
		lblAndroid.setForeground(new Color(255, 255, 255));
		lblAndroid.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAndroid.setBounds(78, 430, 103, 35);
		contentPane.add(lblAndroid);
		
		JLabel lblHadoop = new JLabel("HADOOP");
		lblHadoop.setForeground(new Color(255, 255, 255));
		lblHadoop.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblHadoop.setBounds(78, 499, 116, 24);
		contentPane.add(lblHadoop);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField.setBounds(232, 233, 62, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText(j+"");
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_1.setBounds(232, 304, 62, 25);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText(cpp+"");
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_2.setBounds(232, 368, 62, 25);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setText(ph+"");
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_3.setBounds(232, 432, 62, 25);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		textField_3.setText(and+"");
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_4.setBounds(232, 499, 62, 25);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		textField_4.setText(had+"");
		
		
		JLabel lblAvailable = new JLabel("Total Employee");
		lblAvailable.setForeground(new Color(255, 255, 255));
		lblAvailable.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAvailable.setBounds(213, 175, 108, 26);
		contentPane.add(lblAvailable);
		
		JLabel lblNeeded = new JLabel("Needed Resource");
		lblNeeded.setForeground(new Color(255, 255, 255));
		lblNeeded.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNeeded.setBounds(377, 175, 103, 25);
		contentPane.add(lblNeeded);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_5.setBounds(392, 233, 62, 25);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		textField_5.setText(rj+"");
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_6.setBounds(392, 304, 62, 25);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		textField_6.setText(rcpp+"");
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_7.setBounds(392, 368, 62, 25);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		textField_7.setText(rph+"");
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_8.setBounds(392, 432, 62, 25);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		textField_8.setText(rand+"");
		
		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_9.setBounds(392, 498, 62, 25);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		textField_9.setText(rhad+"");
		
		textField_10 = new JTextField();
		textField_10.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_10.setEditable(false);
		textField_10.setBounds(557, 233, 62, 25);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		textField_10.setText(aj+"");
		
		textField_11 = new JTextField();
		textField_11.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_11.setEditable(false);
		textField_11.setBounds(557, 304, 62, 25);
		contentPane.add(textField_11);
		textField_11.setColumns(10);
		textField_11.setText(acpp+"");
		
		textField_12 = new JTextField();
		textField_12.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_12.setEditable(false);
		textField_12.setBounds(557, 368, 62, 25);
		contentPane.add(textField_12);
		textField_12.setColumns(10);
		textField_12.setText(aph+"");
		
		textField_13 = new JTextField();
		textField_13.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_13.setEditable(false);
		textField_13.setBounds(557, 432, 62, 25);
		contentPane.add(textField_13);
		textField_13.setColumns(10);
		textField_13.setText(aand+"");
		
		textField_14 = new JTextField();
		textField_14.setEditable(false);
		textField_14.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_14.setBounds(557, 499, 62, 25);
		contentPane.add(textField_14);
		textField_14.setColumns(10);
		textField_14.setText(ahad+"");
		
		JLabel lblAvailable_1 = new JLabel("Available");
		lblAvailable_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAvailable_1.setForeground(new Color(255, 255, 255));
		lblAvailable_1.setBounds(557, 171, 90, 30);
		contentPane.add(lblAvailable_1);
		
		JButton btnNewButton_2 = new JButton("ASK FOR RECRUITMENT");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
				{
					String a = JOptionPane.showInputDialog(null,"Enter the required Skill");
					int b = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the number of Employees"));
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ALPHA", "tensbit");
					PreparedStatement smt = con.prepareStatement("insert into smsreq (Skill,Employee_No)"+"values(?,?)");
					smt.setString(1,a);
					smt.setInt(2,b);
					smt.executeUpdate();
					JOptionPane.showMessageDialog(null,"A Request for Recruiting new Employees has been sent");
					con.close();
				}
				catch(Exception e4)
				{
					//e4.printStackTrace();
					JOptionPane.showMessageDialog(null,"Please Enter the Skill and Number properly");
				}
				
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.setBounds(264, 624, 231, 51);
		contentPane.add(btnNewButton_2);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Dipmalya Sen\\workspace\\SpamMail\\img\\37051357-dark-blue-wallpaper.jpg"));
		label.setBounds(0, 0,1366,768);
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

