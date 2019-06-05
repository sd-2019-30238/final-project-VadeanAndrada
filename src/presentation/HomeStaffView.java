package presentation;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import businessLogic.AppointmentController;
import businessLogic.StaffController;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

public class HomeStaffView extends JFrame{
	private JTable table;
	private JFrame frame;
	private JButton btnVeziLista;
	private JButton btnAproba ;
	private String name;
	private String data;
	public HomeStaffView() {
		frame=new JFrame();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("HomeStaff");
		getContentPane().setPreferredSize(new Dimension(500,400));

		getContentPane().setLayout(null);

		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginStaffView main=new LoginStaffView();
				main.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(10, 11, 89, 23);
		getContentPane().add(btnBack);

		JLabel lblListaProgramarilorCe = new JLabel("Lista programarilor ce necesita aprobare");
		lblListaProgramarilorCe.setBounds(10, 40, 215, 32);
		getContentPane().add(lblListaProgramarilorCe);

		btnAproba = new JButton("Aproba");

		btnAproba.setBounds(238, 93, 89, 23);
		getContentPane().add(btnAproba);

		table = new JTable();
		table.setBounds(10, 83, 218, 131);
		table.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int row=table.rowAtPoint(evt.getPoint());
				name=table.getValueAt(row, 1).toString();
				data=table.getValueAt(row, 0).toString();
				btnAproba.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						StaffController staffController=new StaffController();
						staffController.checkAppointment(name, data);		
					}
				});


			}
		});
		getContentPane().add(table);

		btnVeziLista = new JButton("Vezi lista");
		btnVeziLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppointmentController appointmentController=new AppointmentController();
				ArrayList<String[]> rows=new ArrayList<String[]>();
				try {
					rows=appointmentController.getAllApp();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}

				DefaultTableModel tableModel= new DefaultTableModel();
				String[] col= {"data", "nume animal","tip","proprietar","validat"};

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
		btnVeziLista.setBounds(238, 45, 89, 23);
		getContentPane().add(btnVeziLista);


		frame.setContentPane(getContentPane());
		frame.pack();
		frame.setVisible(true);
	}

}
