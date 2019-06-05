package presentation;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import businessLogic.AppointmentController;
import businessLogic.PetController;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class HomePetView extends JFrame {
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTextField msgVeterinar;
	private JTextField txtProgramariTuns;
	private JTextField txtProgramariDeparaziatre;
	private JFrame frame;
	private JComboBox cmbZiua;
	private JComboBox cmbLuna;
	private JComboBox cmbAn;
	private JComboBox comboBox;
	private JButton veziDeparazitare;
	private JButton veziTuns;
	private JButton veziVeterinar;
	public HomePetView() {
		
		frame=new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("HomePet");
		
		
		getContentPane().setPreferredSize(new Dimension(580,600));
		getContentPane().setLayout(null);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PetController petController= new PetController();
				petController.setOffline();
				LoginUserView main=new LoginUserView();
				main.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(5, 5, 89, 23);
		getContentPane().add(btnBack);
		
		table = new JTable();
		table.setBounds(23, 70, 231, 111);
		getContentPane().add(table);

		
		table_1 = new JTable();
		table_1.setBounds(23, 240, 231, 111);
		getContentPane().add(table_1);
		
		table_2 = new JTable();
		table_2.setBounds(23, 410, 231, 111);
		getContentPane().add(table_2);
		
		msgVeterinar = new JTextField();
		msgVeterinar.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
		msgVeterinar.setText("Programari veterinar");
		msgVeterinar.setBounds(23, 370, 174, 20);
		getContentPane().add(msgVeterinar);
		msgVeterinar.setColumns(10);
		
		txtProgramariTuns = new JTextField();
		txtProgramariTuns.setText("Programari tuns");
		txtProgramariTuns.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
		txtProgramariTuns.setColumns(10);
		txtProgramariTuns.setBounds(23, 200, 174, 20);
		getContentPane().add(txtProgramariTuns);
		
		txtProgramariDeparaziatre = new JTextField();
		txtProgramariDeparaziatre.setText("Programari deparaziatre");
		txtProgramariDeparaziatre.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
		txtProgramariDeparaziatre.setColumns(10);
		txtProgramariDeparaziatre.setBounds(23, 31, 174, 20);
		getContentPane().add(txtProgramariDeparaziatre);
		
		comboBox = new JComboBox(new String[] {"programare veterinar","programare tuns","programare deparazitare"});
		comboBox.setToolTipText("programare veterinar\r\nprogramare tuns\r\nprogramare deparazitare");
		comboBox.setBounds(286, 31, 122, 20);
		getContentPane().add(comboBox);
		
		cmbZiua = new JComboBox();
		cmbZiua.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));
		cmbZiua.setBounds(286, 67, 32, 20);
		getContentPane().add(cmbZiua);
		
		cmbLuna = new JComboBox();
		cmbLuna.setModel(new DefaultComboBoxModel(new String[] {"Ian", "Feb", "Mar", "Apr", "Mai", "Iun", "Iul", "Aug", "Sept", "Oct", "Nov", "Dec"}));
		cmbLuna.setMaximumRowCount(31);
		cmbLuna.setBounds(334, 67, 40, 20);
		getContentPane().add(cmbLuna);
		
		cmbAn = new JComboBox();
		cmbAn.setModel(new DefaultComboBoxModel(new String[] {"2019", "2020", "2021"}));
		cmbAn.setMaximumRowCount(3);
		cmbAn.setBounds(390, 67, 38, 20);
		getContentPane().add(cmbAn);
		
		veziDeparazitare = new JButton("Vezi");
		veziDeparazitare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppointmentController appC= new AppointmentController();
				ArrayList<String[]> rows=new ArrayList<String[]>();
				try {
					rows=appC.getDisinfestationApp();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				DefaultTableModel tableModel= new DefaultTableModel();
				String[] col= {"data","nume","aprobat"};
			
				for(String s: col) {
						tableModel.addColumn(s);
				}
				tableModel.addRow(col);
				for(String[] r: rows) {
					tableModel.addRow(r);
				}
				
				table.setModel(tableModel);	
				
			}
		});
		veziDeparazitare.setBounds(197, 30, 89, 23);
		getContentPane().add(veziDeparazitare);
		
		veziTuns = new JButton("Vezi");
		veziTuns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppointmentController appC= new AppointmentController();
				ArrayList<String[]> rows=new ArrayList<String[]>();
				try {
					rows=appC.getHaircutApp();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				DefaultTableModel tableModel= new DefaultTableModel();
				String[] col= {"data","nume","aprobat"};
			
				for(String s: col) {
						tableModel.addColumn(s);
				}
				tableModel.addRow(col);
				for(String[] r: rows) {
					tableModel.addRow(r);
				}
				
				table_1.setModel(tableModel);	
			}
		});
		veziTuns.setBounds(197, 199, 89, 23);
		getContentPane().add(veziTuns);
		
		veziVeterinar = new JButton("Vezi");
		veziVeterinar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppointmentController appC= new AppointmentController();
				ArrayList<String[]> rows=new ArrayList<String[]>();
				try {
					rows=appC.getDoctorApp();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				DefaultTableModel tableModel= new DefaultTableModel();
				String[] col= {"data","nume","aprobat"};
			
				for(String s: col) {
						tableModel.addColumn(s);
				}
				tableModel.addRow(col);
				for(String[] r: rows) {
					tableModel.addRow(r);
				}
				
				table_2.setModel(tableModel);	
			}
		});
		veziVeterinar.setBounds(197, 369, 89, 23);
		getContentPane().add(veziVeterinar);
		
		JButton btnFaProgramare = new JButton("Fa programare");
		btnFaProgramare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ziua=cmbZiua.getSelectedItem().toString()+"-";
				String luna=cmbLuna.getSelectedItem().toString()+"-";
				String an=cmbAn.getSelectedItem().toString();
				String data=ziua+luna+an;
				String type=comboBox.getSelectedItem().toString();		
				AppointmentController appController=new AppointmentController();
				appController.makeAppointment(data, type);
			}
		});
		btnFaProgramare.setBounds(415, 28, 140, 23);
		getContentPane().add(btnFaProgramare);
		frame.setContentPane(getContentPane());
		frame.pack();
		frame.setVisible(true);
	}
}
