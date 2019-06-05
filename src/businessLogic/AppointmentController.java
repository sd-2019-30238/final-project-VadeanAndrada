package businessLogic;

import java.sql.SQLException;
import java.util.ArrayList;

import dataAccess.AppointmentDAO;
import dataAccess.PetDAO;
import dataAccess.UserDAO;
import dataAccess.model.Appointment;

public class AppointmentController {

	public void makeAppointment(String data, String type) {
		UserDAO userDAO=new UserDAO();
		PetDAO petDAO=new PetDAO();
		AppointmentDAO appointmentDAO=new AppointmentDAO();
		
		String petOwner=userDAO.getIsOnlineUsername().getName();
		String petOnline=petDAO.getOnlinePet().getName();
		Appointment app=new Appointment(data, type, petOwner, petOnline);
		appointmentDAO.addAppointment(app);
		
	}
	
	public ArrayList<String[]> getDoctorApp() throws SQLException{
		ArrayList<String[]> app=new ArrayList<String[]>();
		AppointmentDAO appDAO=new AppointmentDAO();
		app=appDAO.getDoctorAppointmets();
		return app;
	}
	
	public ArrayList<String[]> getHaircutApp() throws SQLException{
		ArrayList<String[]> app=new ArrayList<String[]>();
		AppointmentDAO appDAO=new AppointmentDAO();
		app=appDAO.getHaircutAppointmets();
		return app;
	}
	
	public ArrayList<String[]> getDisinfestationApp() throws SQLException{
		ArrayList<String[]> app=new ArrayList<String[]>();
		AppointmentDAO appDAO=new AppointmentDAO();
		app=appDAO.getDisinfestationAppointmets();
		return app;
	}
	
	public ArrayList<String[]> getAllApp() throws SQLException{
		ArrayList<String[]> app=new ArrayList<String[]>();
		AppointmentDAO appDAO=new AppointmentDAO();
		app=appDAO.getAllAppointmets();
		return app;
	}
	
}
