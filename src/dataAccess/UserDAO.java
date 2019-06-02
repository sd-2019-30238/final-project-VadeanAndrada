package dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import dataAccess.connection.ConnectionDB;
import dataAccess.model.User;

public class UserDAO {
	
	public void addUser(User u) {
		Connection con=ConnectionDB.getConnection();
		PreparedStatement statement =null;
		try {
			String query="Insert into user (name, email, phone, password, address, online) values (?,?,?,?,?,?)";
			statement=con.prepareStatement(query);
			statement.setString(1, u.getName());
			statement.setString(2, u.getEmail());
			statement.setString(3, u.getPhone());
			statement.setString(4, u.getPassword());
			statement.setString(5, u.getAddress());
			statement.setInt(6,0);
			statement.executeUpdate();
		}catch (Exception e) {
			System.out.println("cannot add into database!=> "+e);
		}
	}
	public int searchUserByName(User user){
		Connection con=ConnectionDB.getConnection();
		Statement statement=null;
		ResultSet result=null;
		try {
			String query="Select count(name) AS total from user where name='"+user.getName()+"'";
			statement=con.createStatement();
			result=statement.executeQuery(query);
			result.next();
			int noUser=result.getInt("total");
			return noUser;
		}catch (Exception e) {
			System.out.println("can't find the user "+e);
		}
		return 0;
	}
	
	public User getIsOnlineUsername(){
		Connection con=ConnectionDB.getConnection();
		User user= new User();
		Statement statement=null;
		ResultSet result=null;
		try {
			String query="Select name from user where online=1";
			statement=con.createStatement();
			result=statement.executeQuery(query);
			result.next();
			String username=result.getString(1);
			user.setName(username);
			return user;
		}catch (Exception e) {
			System.out.println("can't find the user "+e);
		}
		return user;
	}
	
	public void setIsOnlineUser(User user){
		Connection con=ConnectionDB.getConnection();
		PreparedStatement statement=null;
		int result=0;
		try {
			String query="UPDATE user SET online = 1 WHERE name = "+user.getName();
			statement=con.prepareStatement(query);
			statement.executeUpdate();
			result=statement.executeUpdate();	
		}catch (Exception e) {
			System.out.println("can't find the user "+e);
		}

	}
	public void setIsOffline(){
		Connection con=ConnectionDB.getConnection();
		PreparedStatement statement=null;
		int result=0;
		try {
			String query="UPDATE user SET online = 0";
			statement=con.prepareStatement(query);
			statement.executeUpdate();
			result=statement.executeUpdate();	
		}catch (Exception e) {
			System.out.println("can't find the user "+e);
		}

	}
	
	public int searchUserByNamePassword(User user){
		Connection con=ConnectionDB.getConnection();
		Statement statement=null;
		ResultSet result=null;
		try {
			String query="Select count(name) AS total from user where name='"+user.getName()+"' and password='"+user.getPassword()+"'";
			statement=con.createStatement();
			result=statement.executeQuery(query);
			result.next();
			int noUser=result.getInt("total");
			return noUser;
		}catch (Exception e) {
			System.out.println("can't find the user, maybe you don't have an account "+e);
		}
		return 0;
	}
	
	
	

}
