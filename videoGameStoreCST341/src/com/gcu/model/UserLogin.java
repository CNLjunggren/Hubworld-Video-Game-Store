package com.gcu.model;


public class UserLogin extends User
{
		
	//When a User is registered
		public UserLogin(String username, String password)
		{
			super(username, password, "      ", "       ", "        ", 0, 0);
		}
}
