package businessLogic;

import dataAccess.AppointmentDAO;
import dataAccess.StaffDAO;
import dataAccess.model.Staff;

public class StaffController {

	public int logInStaff(String name, String password) {
		Staff s=new Staff();
		s.setName(name);
		s.setPassword(password);
		StaffDAO staffDAO= new StaffDAO();
		if(staffDAO.searchStaffByNamePassword(s)==0) {
			System.out.println("We can't find your account!");	
			return 0;
		}		
		return 1; 
	}
	
	public void checkAppointment(String name, String data) {
		AppointmentDAO appDAO= new AppointmentDAO();
		appDAO.setAppointmentCheck(name, data);
	}

}
