package presentation;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import businessLogic.UserController;



public class HomeView extends JFrame{
	private JFrame frame;
	private JButton btnUser, btnStaff;
	private JPanel contentPanel;
	
	public HomeView() {
		frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Best furniture deals");
		contentPanel=new JPanel();
		contentPanel.setLayout(null);
		setComp();
		contentPanel.add(btnUser);
		contentPanel.add(btnStaff);
		contentPanel.setPreferredSize(new Dimension(200, 300));
		frame.setContentPane(contentPanel);
		frame.pack();
		frame.setVisible(true);
		
		
	}
	
	public void setComp() {
		 
		btnUser=new JButton("LogIn User");
		btnUser.setToolTipText("you are an USER");
		btnUser.setBounds(80, 106, 100, 45);
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserController u= new UserController();
				u.setAllUsersOffline();
				LoginUserView user=new LoginUserView();
				user.setVisible(true);
				frame.setVisible(false);
			}
		});
		
		btnStaff=new JButton("LogIn Staff");
		btnStaff.setToolTipText("you are from STAFF");
		btnStaff.setBounds(80,200, 100, 45);
        btnStaff.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				LoginStaffView staff=new LoginStaffView();
				staff.setVisible(true);
				frame.setVisible(false);
			}
		});	
		
	}
	
	
	public static void main(String[] Args) {
		Runnable r = new Runnable() {

			public void run() {
				
				new HomeView();
				
			}

		};
		EventQueue.invokeLater(r);
	}

}
