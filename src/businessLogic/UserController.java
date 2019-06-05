package businessLogic;

import dataAccess.UserDAO;
import dataAccess.model.User;

public class UserController {

	public int addUser(String name, String email, String phone, String pasword, String address) {
		UserDAO userDAO=new UserDAO();
		if(checkNewUser(name, email,phone,pasword,address)==2)
			return 2;//mai am un user cu acelasi nume
		if(checkNewUser(name, email,phone,pasword,address)==0)
			return 0;
		User user=new User(name, email,phone, pasword, address);
		user.setOnline(0);
		userDAO.addUser(user);
		return 1;
	}
	
	public int checkNewUser(String name, String email, String phone, String password, String address) {
		UserDAO userDAO=new UserDAO();
		User user=new User();
		user.setName(name);
		if(name.length()==0||email.length()==0||phone.length()==0||password.length()==0||address.length()==0)
			return 0;
		int noUser=userDAO.searchUserByName(user);
		if(noUser!=0 )
			return 2;
		if(phone.length()!=10)
			return 0;
		if(password.length()<8)
			return 0;
		return 1;	
	}
	
	public int logInUser(String name, String password) {
		UserDAO userDAO= new UserDAO();
		User user=new User();
		user.setName(name);
		user.setPassword(password);
		if(userDAO.searchUserByNamePassword(user)==0) {
			System.out.println("We can't find your account!");	
			return 0;
		}	
		userDAO.setIsOnlineUser(user);
		return 1; 
	}


	public void setAllUsersOffline() {
		UserDAO userDAO= new UserDAO();
		userDAO.setIsOffline();
	}
	
	public String getOnlineUser() {
		UserDAO userDAO= new UserDAO();
		User userOnline=userDAO.getIsOnlineUsername();

		return userOnline.getName();
	}

}
