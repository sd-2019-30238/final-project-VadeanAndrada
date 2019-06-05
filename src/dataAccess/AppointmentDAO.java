package dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dataAccess.connection.ConnectionDB;
import dataAccess.model.Appointment;
import dataAccess.model.User;

public class AppointmentDAO {
	
	public void addAppointment(Appointment a ) {
		Connection con=ConnectionDB.getConnection();
		PreparedStatement statement =null;
		try {
			String query="Insert into appointment (dataa, namePet, typee, nameOwner, checkk ) values (?,?,?,?,?)";
			statement=con.prepareStatement(query);
			statement.setString(1, a.getData());
			statement.setString(2, a.getNamePet());
			statement.setString(3, a.getType());
			statement.setString(4, a.getNameOwner());
			statement.setInt(5,0);
			statement.executeUpdate();
		}catch (Exception e) {
			System.out.println("cannot add into database!=> "+e);
		}
		
	}
	
	public ArrayList<String[]> getDoctorAppointmets()throws SQLException {
		Connection con= ConnectionDB.getConnection();
		ArrayList<String[]> appointmets =new ArrayList<String[]>();
		try {
			String query="Select * from appointment where typee='programare veterinar'";
			Statement statement=con.createStatement();
			ResultSet result=statement.executeQuery(query);
			while(result.next()) {
				String[] oneRow= new String[100];		
				oneRow[0]=result.getString(1);
				oneRow[1]=result.getString(2);
				oneRow[3]=result.getString(5);
				appointmets.add(oneRow);
			}
		}catch (Exception e) {
			System.out.println("Cannot contect!");
		}
		return appointmets;
	}
	
	public ArrayList<String[]> getDisinfestationAppointmets()throws SQLException {
		Connection con= ConnectionDB.getConnection();
		ArrayList<String[]> appointmets =new ArrayList<String[]>();
		try {
			String query="Select * from appointment where typee='programare deparazitare'";
			Statement statement=con.createStatement();
			ResultSet result=statement.executeQuery(query);
			while(result.next()) {
				String[] oneRow= new String[100];		
				oneRow[0]=result.getString(1);
				oneRow[1]=result.getString(2);
				oneRow[3]=result.getString(5);
				appointmets.add(oneRow);
			}
		}catch (Exception e) {
			System.out.println("Cannot contect!");
		}
		return appointmets;
	}
	
	
	public ArrayList<String[]> getHaircutAppointmets()throws SQLException {
		Connection con= ConnectionDB.getConnection();
		ArrayList<String[]> appointmets =new ArrayList<String[]>();
		try {
			String query="Select * from appointment where typee='programare tuns'";
			Statement statement=con.createStatement();
			ResultSet result=statement.executeQuery(query);
			while(result.next()) {
				String[] oneRow= new String[100];		
				oneRow[0]=result.getString(1);
				oneRow[1]=result.getString(2);
				oneRow[3]=result.getString(5);
				
				appointmets.add(oneRow);
			}
		}catch (Exception e) {
			System.out.println("Cannot contect!");
		}
		return appointmets;
	}
	
	public ArrayList<String[]> getAllAppointmets()throws SQLException {
		Connection con= ConnectionDB.getConnection();
		ArrayList<String[]> appointmets =new ArrayList<String[]>();
		try {
			String query="Select * from appointment where checkk=0";
			Statement statement=con.createStatement();
			ResultSet result=statement.executeQuery(query);
			while(result.next()) {
				String[] oneRow= new String[100];		
				oneRow[0]=result.getString(1);
				oneRow[1]=result.getString(2);
				oneRow[2]=result.getString(3);
				oneRow[3]=result.getString(4);
				oneRow[4]=result.getString(5);	
				appointmets.add(oneRow);
			}
		}catch (Exception e) {
			System.out.println("Cannot contect!");
		}
		return appointmets;
	}

	public void setAppointmentCheck(String name, String data ) {
		Connection con=ConnectionDB.getConnection();
		PreparedStatement st=null;
		int res=0;
		try { 
			String query="Update appointment set checkk= 1 where namePet='"+name+"' and checkk = 0 and dataa='"+data+"'";
			st=con.prepareStatement(query);
			st.executeUpdate();
			res=st.executeUpdate();	
		}catch (Exception e) {
			System.out.println("no database "+e);
		}
	}
}
