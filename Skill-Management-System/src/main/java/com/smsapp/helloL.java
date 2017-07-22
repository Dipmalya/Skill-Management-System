package com.smsapp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class helloL extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					helloL frame = new helloL();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public helloL() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		setLocationRelativeTo(null);
		
		final JProgressBar progressBar = new JProgressBar();
		progressBar.setForeground(new Color(51, 204, 0));
		progressBar.setStringPainted(true);
		progressBar.setBounds(0, 283, 450, 17);
		contentPane.add(progressBar);
		
		final JLabel label = new JLabel("");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(10, 250, 236, 25);
		contentPane.add(label);
		
		JLabel lblSkill = new JLabel("SKILL");
		lblSkill.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSkill.setBounds(294, 25, 156, 67);
		contentPane.add(lblSkill);
		
		JLabel lblManagement = new JLabel("MANAGEMENT");
		lblManagement.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblManagement.setBounds(294, 66, 156, 36);
		contentPane.add(lblManagement);
		
		JLabel lblSystem = new JLabel("SYSTEM");
		lblSystem.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSystem.setBounds(294, 92, 130, 36);
		contentPane.add(lblSystem);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Dipmalya Sen\\workspace\\SpamMail\\img\\pexels-photo.jpg"));
		label_1.setBounds(0, 0, 450, 300);
		contentPane.add(label_1);
		 Thread t = new Thread() {
			    
	            public void run() {
	                int i = 0;
	                while (i <= 100) {
	                 if (i<10)
	                  label.setText("Loading Components....");
	                 else if (i<30)
	                  label.setText("Initializing UI......");
	                 else if (i<60)
	                  label.setText("Linking Databases.....");
	                 else if (i<80)
	                  label.setText("Getting Ready..");
	                 else
	                  label.setText("Welcome...");
	                    progressBar.setValue(i);
	                    try {
	                        sleep(120);
	                    } catch (InterruptedException ex) {
	                        JOptionPane.showMessageDialog(null, "Cannot Load!");
	                    }
	                    i+=3;
	                }
	            }
	        };
	        t.start();
	 }
}


