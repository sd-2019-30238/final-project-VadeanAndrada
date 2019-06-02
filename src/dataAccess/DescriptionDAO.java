package dataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import dataAccess.connection.ConnectionDB;
import dataAccess.model.Description;

public class DescriptionDAO {
	
	public String getBreed( Description d){
		Connection con=ConnectionDB.getConnection();
		String breed=null;
		Statement statement=null;
		ResultSet result=null;
		try {
			String query="Select breed from description where age='"+d.getAge()+"' and sex='"+d.getSex()+"' and temperament='"+d.getTemperament()+"'";
			statement=con.createStatement();
			result=statement.executeQuery(query);
			result.next();
			breed=result.getString(1);
			return breed;
		}catch (Exception e) {
			System.out.println("can't find the user "+e);
		}
		return breed;
	}
}
