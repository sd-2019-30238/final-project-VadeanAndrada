package presentation;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import businessLogic.StaffController;


public class LoginStaffView extends JFrame{
	private JTextField fieldUsername;
	private JFrame frame;
	private JLabel lblLogin;
	private JPasswordField passwordField;
	private JButton btnBack;
	private JButton btnCreateaccount;
	public LoginStaffView() {
		frame=new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Staff");
		
		getContentPane().setPreferredSize(new Dimension(300,400));
		getContentPane().setLayout(null);
		
		fieldUsername = new JTextField();
		fieldUsername.setBounds(129, 115, 140, 20);
		getContentPane().add(fieldUsername);
		fieldUsername.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(64, 118, 66, 14);
		getContentPane().add(lblUsername);
		
		JLabel lblPssword = new JLabel("Password:");
		lblPssword.setBounds(64, 163, 79, 14);
		getContentPane().add(lblPssword);
		
		lblLogin = new JLabel("LogIn");
		lblLogin.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 24));
		lblLogin.setBounds(129, 43, 127, 45);
		getContentPane().add(lblLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(129, 160, 140, 20);
		getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("LogIn");
		btnLogin.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StaffController staff=new StaffController();
				String username=fieldUsername.getText();	 
				String password=new String(passwordField.getPassword());
				int isOK=staff.logInStaff(username, password);
				System.out.println(password);
				if(isOK==0)
					JOptionPane.showMessageDialog(frame,
							"Username-ul sau parola sunt gresite! Incearca cu mai multa atentie!");
				else
				{
					HomeStaffView newWindow= new HomeStaffView();
					newWindow.setVisible(true);
					frame.setVisible(false);
				}
			}
		});
		btnLogin.setBounds(118, 227, 120, 23);
		getContentPane().add(btnLogin);
		
		btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeView main=new HomeView();
				main.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(10, 11, 89, 23);
		getContentPane().add(btnBack);
		

		
		frame.setContentPane(getContentPane());
		frame.pack();
		frame.setVisible(true);
	}

}
