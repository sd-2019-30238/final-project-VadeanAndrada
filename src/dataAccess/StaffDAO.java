package dataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import dataAccess.connection.ConnectionDB;
import dataAccess.model.Staff;

public class StaffDAO {
	public int searchStaffByNamePassword(Staff s){
		Connection con=ConnectionDB.getConnection();
		Statement statement=null;
		ResultSet result=null;
		try {
			String query="Select count(nameStaff) AS total from staff where name='"+s.getName()+"' and password='"+s.getPassword()+"'";
			statement=con.createStatement();
			result=statement.executeQuery(query);
			result.next();
			int noUser=result.getInt("total");
			return noUser;
		}catch (Exception e) {
			System.out.println("can't find the staff account, maybe you don't have an account "+e);
		}
		return 0;
	}

}
