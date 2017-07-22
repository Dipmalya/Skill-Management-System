package com.smsapp;

import java.awt.*;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
public class hello extends JApplet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmSkillManagementSystem;
	private JTextField textField;
	private JTextField textField_1;
	public String car;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		helloL hl = new helloL();
		hl.setVisible(true);
		try {
			Thread.sleep(4000);
			hl.setVisible(false);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hello window = new hello();
					window.frmSkillManagementSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public hello() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//Container contentPane = getContentPane();
		frmSkillManagementSystem = new JFrame();
		frmSkillManagementSystem.setForeground(Color.WHITE);
		frmSkillManagementSystem.setTitle("Skill Management System");
		frmSkillManagementSystem.setResizable(false);
		frmSkillManagementSystem.setLocationRelativeTo(null);
		frmSkillManagementSystem.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Dipmalya Sen\\Downloads\\hello.ico"));
		frmSkillManagementSystem.getContentPane().setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		/*frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setUndecorated(true);
		frame.setVisible(true);*/
		//frame.setSize(1300,750);
		frmSkillManagementSystem.setUndecorated(true);
		frmSkillManagementSystem.setBounds(0,0,1366,768);
		frmSkillManagementSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSkillManagementSystem.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(191, 110, 633, 524);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 7));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Dipmalya Sen\\Downloads\\Slide1.png"));
		frmSkillManagementSystem.getContentPane().add(lblNewLabel);
		
		
		
		Panel panel = new Panel();
		panel.setBackground(new Color(169, 169, 169));
		panel.setBounds(883, 134, 290, 479);
		frmSkillManagementSystem.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(102, 245, 158, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(102, 297, 158, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setFont(new Font("Constantia", Font.BOLD, 16));
		btnNewButton.setBounds(91, 354, 137, 47);
		panel.add(btnNewButton);
		
		
		//The action of the LOGIN button.. checking the username and password in database..
		btnNewButton.addActionListener( new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    	String pass = textField_1.getText();
		    	String un = textField.getText();
		        boolean b=check(un,pass);
		        if(b)
		        {
		        	//System.out.println("Logged in");
		        	hello1 obj = new hello1();
		        	obj.setVisible(true);
		        	frmSkillManagementSystem.dispose();
		        }
		        else
		        {
		        	JOptionPane.showMessageDialog(frmSkillManagementSystem, "Invalid username or password!!");
		        	textField.setText(null);
		        	textField_1.setText(null);
		        }
		    }
		});
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(10, 243, 82, 20);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 298, 82, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Dipmalya Sen\\Desktop\\Literature\\tb.jpg"));
		lblNewLabel_3.setBounds(20, 11, 240, 191);
		panel.add(lblNewLabel_3);
		
		
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Dipmalya Sen\\workspace\\SpamMail\\img\\37051357-dark-blue-wallpaper.jpg"));
		label.setBounds(0,0,1366,768);
		frmSkillManagementSystem.getContentPane().add(label);
		
		JButton btnNewButton3 = new JButton("X");
		btnNewButton3.setBackground(new Color(255, 255, 255));
		btnNewButton3.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton3.setBounds(1321, 0, 45, 36);
		btnNewButton3.addActionListener( new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    	frmSkillManagementSystem.dispose();
		    }
		    });
			frmSkillManagementSystem.getContentPane().add(btnNewButton3);
		}
	
		
	//The checking function for correct login.. and returning boolean..
	Connection myCon = null;
	PreparedStatement mySmt = null;
	ResultSet myRs = null;
	public boolean check(String u, String p)
	{
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ALPHA", "tensbit");
			PreparedStatement smt = con.prepareStatement("select * from smslogin where USERNAME = ? and PASSWORD = ?");
			smt.setString(1,u);
			smt.setString(2,p);
			ResultSet rs = smt.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString(1));
				car = rs.getString(1);
				return true;
			}
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
}

