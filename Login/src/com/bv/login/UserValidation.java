package com.bv.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bv.login.DBConnection;

public class UserValidation {

	public static boolean validate(String username,String password)
	{
		boolean isUser=false;
		try {
			String sql = "select HOLDER_NAME,PASS from account where HOLDER_NAME=? and PASS=?";
			Connection connection = DBConnection.getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next())
			{
				
				isUser=true;
				//System.out.println("Welcome"+ " " + resultSet.getString("username"));
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return isUser;
		
	}
}
