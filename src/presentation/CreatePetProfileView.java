package presentation;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;

import businessLogic.PetController;
import businessLogic.UserController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreatePetProfileView extends JFrame {
	private JTextField textNume;
	private JTextField textVarsta;
	private JTextField textRasa;
	private JTextField textVeterinar;
	private JFrame frame;
	public CreatePetProfileView() {
		frame=new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("HomeUser");
		
		getContentPane().setPreferredSize(new Dimension(500,400));
		getContentPane().setLayout(null);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeUserView homeUserView= new HomeUserView();
				homeUserView.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(5, 5, 89, 23);
		getContentPane().add(btnBack);
		
		JLabel lblNume = new JLabel("Nume:");
		lblNume.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 14));
		lblNume.setBounds(28, 57, 74, 18);
		getContentPane().add(lblNume);
		
		JLabel lblVarsta = new JLabel("Varsta:");
		lblVarsta.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 14));
		lblVarsta.setBounds(28, 90, 74, 18);
		getContentPane().add(lblVarsta);
		
		JLabel lblRasa = new JLabel("Rasa:");
		lblRasa.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 14));
		lblRasa.setBounds(28, 119, 74, 18);
		getContentPane().add(lblRasa);
		
		JLabel lblVeterinar = new JLabel("Veterinar:");
		lblVeterinar.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 14));
		lblVeterinar.setBounds(28, 150, 74, 18);
		getContentPane().add(lblVeterinar);
		
		textNume = new JTextField();
		textNume.setBounds(120, 57, 141, 20);
		getContentPane().add(textNume);
		textNume.setColumns(10);
		
		textVarsta = new JTextField();
		textVarsta.setColumns(10);
		textVarsta.setBounds(120, 90, 141, 20);
		getContentPane().add(textVarsta);
		
		textRasa = new JTextField();
		textRasa.setColumns(10);
		textRasa.setBounds(120, 119, 141, 20);
		getContentPane().add(textRasa);
		
		textVeterinar = new JTextField();
		textVeterinar.setColumns(10);
		textVeterinar.setBounds(120, 150, 141, 20);
		getContentPane().add(textVeterinar);
		
		JButton btnProfile = new JButton("Creeaza profil");
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PetController petController=new PetController();
				String name=textNume.getText();
				String age=textVarsta.getText();
				String breed=textRasa.getText();
				String doctor=textVeterinar.getText();
				
				petController.addPet(name, breed, age, doctor);
				
			}
		});
		btnProfile.setBounds(28, 207, 121, 23);
		getContentPane().add(btnProfile);
		
		frame.setContentPane(getContentPane());
		frame.pack();
		frame.setVisible(true);
	}

}
