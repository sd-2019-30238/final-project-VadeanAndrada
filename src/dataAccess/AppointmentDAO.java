package dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;

import dataAccess.connection.ConnectionDB;
import dataAccess.model.Appointment;
import dataAccess.model.User;

public class AppointmentDAO {
	
	public void addAppointment(Appointment a ) {
		Connection con=ConnectionDB.getConnection();
		PreparedStatement statement =null;
		try {
			String query="Insert into appointment (data, namePet,type,nameOwner, check) values (?,?,?,?,?)";
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

}
