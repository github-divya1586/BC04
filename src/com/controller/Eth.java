package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.configurations.AppConfig;
import com.service.UploadKycService;

/**
 * Servlet implementation class Eth
 */
@WebServlet("/Eth")
public class Eth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Eth() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Sqlvalue= request.getParameter("checkbox");
		String DDvalue= request.getParameter("checkbox1");
		
		if(Sqlvalue==null) {
			Sqlvalue="0";
		}else {
			Sqlvalue="1";
		}
		
		if(DDvalue==null) {
			DDvalue="0";
		}else {
			DDvalue="1";
		}
		
		
		UploadKycService kyc=AppConfig.getuploadKycService();
		try {
			int i=kyc.updateStatus(Sqlvalue, DDvalue);
			if(i!=-1) {
				String info = "<div class=\"alert alert-danger wrap-input100\">\n" +
	                    "                        <p style=\"font-family: Ubuntu-Bold; font-size: 18px; margin: 0.25em 0; text-align: center\">\n" +
	                    "                            Updated the status!\n" +
	                    "                        </p>\n" +
	                    "                    </div>";
			request.setAttribute("info", info);
	        request.getRequestDispatcher("adminhome.jsp?userpage=eth").forward(request, response);
			}else {
				String alert = "<div class=\"alert alert-danger wrap-input100\">\n" +
	                    "                        <p style=\"font-family: Ubuntu-Bold; font-size: 18px; margin: 0.25em 0; text-align: center\">\n" +
	                    "                            Something went wrong!\n" +
	                    "                        </p>\n" +
	                    "                    </div>";
			request.setAttribute("alert", alert);
	        request.getRequestDispatcher("adminhome.jsp?userpage=eth").forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(values.toString());
	}

}
