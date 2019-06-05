package dataAccess.connection;

import java.sql.PreparedStatement;

import com.mysql.jdbc.Connection;

import dataAccess.UserDAO;

import dataAccess.model.User;

public class TestConn {
	
	public static void main(String[] arg) {
		
		java.sql.Connection con=ConnectionDB.getConnection();
		PreparedStatement statement =null;
		
		User u=new User();
		u.setName("Andrada");
		u.setPassword("parola");
		u.setAddress("Cluj");
		u.setOnline(0);
		u.setPhone("0755795950");
		
		UserDAO dao=new UserDAO();
		dao.addUser(u);

		
	}

}
