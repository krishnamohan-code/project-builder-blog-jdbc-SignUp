package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import utility.ConnectionManager;
//import java.ConnectionManager;
public class UserDAO implements UserDaoInterface {
	  String signup= "INSERT INTO USERS (email, password) VALUES (?,?) ";
	 String login= "SELECT * FROM USERS WHERE email = ? AND password = ? ";
	public int signUp(User user)  {
		
		 try
		 {
			Connection con = ConnectionManager.getConnection();
		    int result = 0;	
		   
		   
			PreparedStatement st = con.prepareStatement(signup);
			st.setString(1,user.getEmail());
			st.setString(2,user.getPassword());
			
			
			result = st.executeUpdate();
			System.out.println(result);
			return result;
		} 
		 catch (Exception e)
		    {
			System.out.println(e);
		   }
		return 0;
	}
	
	public boolean loginUser(User user)  {
		try 
		{
			Connection con = ConnectionManager.getConnection();
			System.out.println("working");
			boolean result = false;
		    PreparedStatement st = con.prepareStatement(login);
		
			st.setString(1, user.getEmail());
			st.setString(2, user.getPassword());

			System.out.println(st);
			ResultSet rs = st.executeQuery();
			result = rs.next();
			return result;
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}
		return false;
	}

}