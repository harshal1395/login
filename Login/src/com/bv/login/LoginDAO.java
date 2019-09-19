package com.bv.login;

public class LoginDAO {
	public static boolean validateUser(String username,String password)
	{
		if(username.equals("jack") && password.equals("kate"))
			return true;
		return false;
	}

}
