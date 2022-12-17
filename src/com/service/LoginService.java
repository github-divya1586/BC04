package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dao.LoginDAO;
import com.exceptions.MyExcetpion;
import com.interfaces.LoginInterface;
import com.model.RegisterModel;

public class LoginService {

	LoginDAO loginDAO = new LoginDAO();

	public int userLogin(String email, String password) {

		LoginInterface loginInterface = (useremail, userpassword) -> {
			int b = 0;
			ResultSet rs;
			try {
				int i=loginDAO.getAttack("Sqlinject");
				if(i==1) {
				rs = loginDAO.checkUser(email, password);
				if (rs.next() == false) {
					b = 0;
				} else {
					b = 1;
				}
				}else {
					rs = loginDAO.checkUser1(email, password);
					if (rs.next() == false) {
						b = 0;
					} else {
						b = 2;
					}
					
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
return b;
		};

		int userLoginStatus = loginInterface.userLogin(email, password);
		return userLoginStatus;

	}

	public RegisterModel getUserDetails(String emailid) throws ClassNotFoundException, SQLException, MyExcetpion {

		RegisterModel rm = new RegisterModel();
		ResultSet rs = loginDAO.checkUser(emailid);
		if (rs.next() == false) {
			throw new MyExcetpion("something went wrong in getting the user details");
		}
		do {
			rm.setUserid(Integer.parseInt(rs.getString(1)));
			rm.setName(rs.getString(2));
			rm.setEmailid(rs.getString(3));
			rm.setPassword(rs.getString(4));

		} while (rs.next());

		return rm;
	}

}
