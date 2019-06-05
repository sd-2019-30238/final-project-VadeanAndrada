package presentation;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;

import businessLogic.DescriptionController;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateProfileView extends JFrame{
	private JTextField textRasa;
	private JComboBox comboTemperament;
	private JComboBox comboVarsta;
	private JComboBox comboSex;
	private JFrame frame;
	public CreateProfileView() {
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
		JLabel lblTemeperament = new JLabel("Temeperament:");
		lblTemeperament.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 15));
		lblTemeperament.setBounds(10, 40, 128, 14);
		getContentPane().add(lblTemeperament);
		
		JLabel lblVarsata = new JLabel("Varsta:");
		lblVarsata.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 15));
		lblVarsata.setBounds(10, 85, 128, 14);
		getContentPane().add(lblVarsata);
		
		JLabel lblSex = new JLabel("Sex:");
		lblSex.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 15));
		lblSex.setBounds(10, 123, 128, 14);
		getContentPane().add(lblSex);
		
		JLabel lblRasaCareVi = new JLabel("Rasa care vi s-ar potrivi:");
		lblRasaCareVi.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 15));
		lblRasaCareVi.setBounds(119, 213, 248, 14);
		getContentPane().add(lblRasaCareVi);
		
		textRasa = new JTextField();
		textRasa.setBounds(140, 238, 128, 20);
		getContentPane().add(textRasa);
		textRasa.setColumns(10);
		
		comboTemperament = new JComboBox();
		comboTemperament.setModel(new DefaultComboBoxModel(new String[] {"Coleric", "Sangvinic", "Flegmatic", "Melancolic"}));
		comboTemperament.setBounds(148, 40, 120, 20);
		getContentPane().add(comboTemperament);
		
		comboVarsta = new JComboBox();
		comboVarsta.setModel(new DefaultComboBoxModel(new String[] {"20-30", "30-50", "50+"}));
		comboVarsta.setBounds(148, 85, 120, 20);
		getContentPane().add(comboVarsta);
		
		comboSex = new JComboBox();
		comboSex.setModel(new DefaultComboBoxModel(new String[] {"F", "M"}));
		comboSex.setBounds(148, 123, 120, 20);
		getContentPane().add(comboSex);
		
		JButton btnClick = new JButton("Click");
		btnClick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DescriptionController descController=new DescriptionController();  
				String sex=comboSex.getSelectedItem().toString();
				String age=comboVarsta.getSelectedItem().toString();
				String temperament=comboTemperament.getSelectedItem().toString();
				
				String breed=descController.getBreed(sex, age, temperament);
				textRasa.setText(breed);
			}
		});
		btnClick.setBounds(166, 168, 89, 23);
		getContentPane().add(btnClick);
		
		frame.setContentPane(getContentPane());
		frame.pack();
		frame.setVisible(true);
	}

}
 