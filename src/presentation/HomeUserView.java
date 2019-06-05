package presentation;

import javax.swing.JFrame;
import javax.swing.JTextField;

import businessLogic.PetController;
import businessLogic.UserController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

public class HomeUserView extends JFrame {
	
	private JFrame frame;
	public HomeUserView() {
		frame=new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("HomeUser");
		
		getContentPane().setPreferredSize(new Dimension(500,400));
		getContentPane().setLayout(null);

		
		
		UserController userC=new UserController();
		String name=userC.getOnlineUser();
		PetController petC= new PetController();
		ArrayList<String> petsName=new ArrayList<String>();
		int size=0;

		try {
			 petsName=petC.getPets(name);
			size=petsName.size();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		JButton[] buttons = new JButton[size];
		
		JTextField[] namePet= new JTextField[size];
		
		
		int a=34;
		for(int i=0; i<size; i++) {
			namePet[i] = new JTextField(petsName.get(i));
			namePet[i].setBounds(a, 46, 86, 20);
			getContentPane().add(namePet[i]);
			namePet[i].setColumns(10);	
			buttons[i] = new JButton("click"+i);
			buttons[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					UserController userC=new UserController();
					String name=userC.getOnlineUser();
					PetController petC= new PetController();

						ArrayList<String> petsName2;
						try {
							petsName2 = petC.getPets(name);
							String command = ((JButton) e.getSource()).getActionCommand();
							char index= command.charAt(command.length()-1);
							int petsIndex= Integer.parseInt(index+"");
							petC.loginPet(petsName2.get(petsIndex));
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					HomePetView main=new HomePetView();
					main.setVisible(true);
					frame.setVisible(false);
						
			
				}
			});
			buttons[i].setBounds(a, 95, 89, 23);
			
			getContentPane().add(buttons[i]);
			
			a+=100;
			
		}

		
		JButton btnFatiProfilul = new JButton("Fa-ti profilul :)");
		btnFatiProfilul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateProfileView view=new CreateProfileView();
				view.setVisible(true);
				frame.setVisible(false);
			}
		});
		
		btnFatiProfilul.setBounds(31, 187, 138, 23);
		getContentPane().add(btnFatiProfilul);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginUserView main=new LoginUserView();
				main.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(10, 11, 89, 23);
		getContentPane().add(btnBack);
		
		JButton btnNewPet = new JButton("Adauga animal");
		btnNewPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreatePetProfileView view=new CreatePetProfileView();
				view.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewPet.setBounds(34, 221, 135, 23);
		getContentPane().add(btnNewPet);
		
		frame.setContentPane(getContentPane());
		frame.pack();
		frame.setVisible(true);
	}

	
}
