package businessLogic;

import java.sql.SQLException;
import java.util.ArrayList;

import dataAccess.PetDAO;
import dataAccess.UserDAO;
import dataAccess.model.Pet;
import dataAccess.model.User;

public class PetController {
	public void addPet(String name, String breed, String age,String doctor) {	
		UserDAO userDAO=new UserDAO();
		PetDAO petDAO= new PetDAO();	
		String owner=userDAO.getIsOnlineUsername().getName();
		Pet newPet= new Pet(name,breed, age,doctor,owner);
		petDAO.addPet(newPet);
	}
	
	public void loginPet(String name) {
		PetDAO petDAO= new PetDAO();
		Pet pet=new Pet();
		pet.setName(name);
		petDAO.setIsOnlinePet(pet);
	}

	public ArrayList<String> getPets(String username) throws SQLException{
		User user= new User();
		user.setName(username);
		ArrayList<String> allPets =new ArrayList<String>();
		PetDAO petDAO= new PetDAO();
		allPets=petDAO.getUsersPets(user);
		
		return allPets;
	}
	
	public void setOffline() {
		PetDAO petDAO=new PetDAO();
		petDAO.setAllPetsOffline();
	}
}
