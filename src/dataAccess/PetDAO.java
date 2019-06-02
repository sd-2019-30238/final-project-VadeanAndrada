package dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import dataAccess.connection.ConnectionDB;
import dataAccess.model.Pet;
import dataAccess.model.Staff;
import dataAccess.model.User;

public class PetDAO {

	public Pet getOnlinePet(){
		Connection con=ConnectionDB.getConnection();
		Pet pet= new Pet();
		Statement statement=null;
		ResultSet result=null;
		try {
			String query="Select name from pet where online=1";
			statement=con.createStatement();
			result=statement.executeQuery(query);
			result.next();
			String username=result.getString(1);
			pet.setName(username);
			return pet;
		}catch (Exception e) {
			System.out.println("can't find the user "+e);
		}
		return pet;
	}
	
	public void setIsOnlinePet(Pet pet){
		Connection con=ConnectionDB.getConnection();
		PreparedStatement statement=null;
		int result=0;
		try {
			String query="UPDATE pet SET online = 1 WHERE name = "+pet.getName();
			statement=con.prepareStatement(query);
			statement.executeUpdate();
			result=statement.executeUpdate();	
		}catch (Exception e) {
			System.out.println("can't find the user "+e);
		}
	}
	
	public void addPet(Pet p) {
		Connection con=ConnectionDB.getConnection();
		PreparedStatement statement =null;
		try {
			String query="Insert into pet (name, age, owner, breed,doctor, online) values (?,?,?,?,?,?)";
			statement=con.prepareStatement(query);
			statement.setString(1, p.getName());
			statement.setString(2, p.getAge());
			statement.setString(3, p.getOwner());
			statement.setString(4, p.getBreed());
			statement.setString(5, p.getDoctor());
			statement.setInt(6,0);
			statement.executeUpdate();
		}catch (Exception e) {
			System.out.println("cannot add into database!=> "+e);
		}
	}

}
