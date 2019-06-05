package businessLogic;

import dataAccess.DescriptionDAO;
import dataAccess.model.Description;

public class DescriptionController {
	
	public String getBreed(String sex, String age, String temperament ) {
		DescriptionDAO descriptionDAO=new DescriptionDAO();
		Description description=new Description(sex, age, temperament);
		String breed=descriptionDAO.getBreed(description);
		
		return breed;
	}

}
