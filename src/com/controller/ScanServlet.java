package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.configurations.AppConfig;
import com.model.FileModel;
import com.service.UploadKycService;

/**
 * Servlet implementation class ScanServlet
 */
@WebServlet("/ScanServlet")
public class ScanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScanServlet() {
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


		UploadKycService uks=AppConfig.getuploadKycService();
		
		try {
			List<FileModel>  files=uks.getFiles();
			List<String> att1=new ArrayList<>();
			Stream<String> attack = null;
			
			
			for(FileModel file:files) {
				
				 File file1 = new File("D:\\major 2022\\BC04\\WebContent\\files\\encrypt\\"+file.getFileName()+".txt");
				 Scanner sc = new Scanner(file1);
				 
				    while (sc.hasNextLine()) {
				      System.out.println(sc.nextLine());
				      if(sc.nextLine().contains("SQL")) {
				    	  att1.add(file.getFileName());
				      }
				  }
				
				// attack=Files.lines(Paths.get("D:\\major 2022\\BC04\\WebContent\\files\\encrypt\\"+file.getFileName()+".txt"));
				// attack.close();
				
				//attack.close();
			}
			
			
			/*
			 * att1= attack.filter(x -> x.contains("SQL"))
			 * 
			 * .collect(Collectors.toList());
			 * 
			 * attack.close();*/
			 
			  for(String s: att1) { System.out.println(s); }
			 
			  String info = "<div class=\"alert alert-success wrap-input100\">\n" +
	                    "                        <p style=\"font-family: Ubuntu-Bold; font-size: 18px; margin: 0.25em 0; text-align: center\">\n" +
	                    "                            This files are suspicious\n" +
	                    "                        </p>\n" +
	                  
	                    "                    </div>";
			request.setAttribute("info", info);
			request.setAttribute("files", att1);
       //   request.getRequestDispatcher("adminhome.jsp").forward(request, response);
          request.getRequestDispatcher("adminhome.jsp?userpage=scan").forward(request, response);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
