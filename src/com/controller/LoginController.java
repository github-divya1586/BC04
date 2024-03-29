package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exceptions.MyExcetpion;
import com.model.RegisterModel;
import com.service.LoginService;


@WebServlet("/login")
public class LoginController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String emailid=req.getParameter("emailid");
		String password=req.getParameter("password");
		
		if(emailid.equalsIgnoreCase("admin@gmail.com") && password.equalsIgnoreCase("admin")) {
		
		 req.setAttribute("admin", "admin");
	     req.getRequestDispatcher("adminhome.jsp").forward(req, resp);
			
		}else {
		
		LoginService lc=new LoginService();
		int userStatus=lc.userLogin(emailid, password);
		
		if(userStatus==1 || userStatus==2) {
			try {
				RegisterModel rm=lc.getUserDetails(emailid);
				 HttpSession session = req.getSession();
				 session.setAttribute("account", rm);
				 String s= userStatus==2?"sql":"nosql";
				if (s.equalsIgnoreCase("sql")) {
					 req.setAttribute("sql", "SQL INJECTION ATTACK");}
				
				 req.setAttribute("account", rm);
			     req.getRequestDispatcher("index.jsp").forward(req, resp);
			} catch (ClassNotFoundException | SQLException | MyExcetpion e) {
				e.printStackTrace();
			}	
			
		}else {
			String alert = "<div class=\"alert alert-danger wrap-input100\">\n" +
                    "                        <p style=\"font-family: Ubuntu-Bold; font-size: 18px; margin: 0.25em 0; text-align: center\">\n" +
                    "                            email/passowrd wrong!\n" +
                    "                        </p>\n" +
                    "                    </div>";
		req.setAttribute("alert", alert);
        req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		}
	}

}
