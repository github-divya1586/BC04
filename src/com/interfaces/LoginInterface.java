package com.interfaces;

import com.model.RegisterModel;

@FunctionalInterface
public interface LoginInterface {
	
	public int userLogin(String email, String password);

}
