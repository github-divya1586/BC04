package com.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.io.FileUtils;

import com.configurations.AppConfig;
import com.model.KycModel;
import com.model.RegisterModel;
import com.service.UploadKycService;
import com.utils.CryptoUtilsTest;
import com.utils.HashCodeGenearate;

@WebServlet("/upload")
@MultipartConfig
public class FileUpload extends HttpServlet {

	private static final long serialVersionUID = 1L;
	UploadKycService uks = new UploadKycService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("uname");
		String fname = req.getParameter("fname");
		String mname = req.getParameter("mname");
		String mobile = req.getParameter("mobile");
		String gender = req.getParameter("gender");
		String address = req.getParameter("address");

		Part part = req.getPart("file");
		String fileName= part.getName();
		InputStream inputStream = part.getInputStream();
		
		/*
		 * StringBuilder textBuilder = new StringBuilder(); try (Reader reader = new
		 * BufferedReader(new InputStreamReader (inputStream,
		 * Charset.forName(StandardCharsets.UTF_8.name())))) { int c = 0; while ((c =
		 * reader.read()) != -1) { textBuilder.append((char) c); } }
		 * System.out.println(textBuilder.toString());
		 */

		KycModel kycModel = AppConfig.getKycmodel();

		HttpSession session = req.getSession();
		RegisterModel rm = (RegisterModel) session.getAttribute("account");

	//	String genearatehash = name.substring(0, 2) + fname.substring(0, 2) + mname.substring(0, 2)
			//	+ gender.substring(0, 2);
	//	String hashValue = HashCodeGenearate.getHashValue(genearatehash);
		try {
		String filePath="C:/Users/shyam/git/BC04-master/BC04-master/WebContent/files/";
		System.out.println(filePath);
		
		File targetFile = new File(filePath+"test.txt");
		
		
		
		 try (OutputStream outStream = new FileOutputStream(targetFile)) {
			byte[] buffer = new byte[8 * 1024];
			    int bytesRead;
			    while ((bytesRead = inputStream.read(buffer)) != -1) {
			        outStream.write(buffer, 0, bytesRead);
			    }
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		 

	   // FileUtils.copyInputStreamToFile(inputStream, targetFile);
	    
	    
	    File ecncryptFile = new File(filePath+"sampleenc.txt");

	    CryptoUtilsTest.encrptAlgoritham("shyamshyamshyamm", targetFile, ecncryptFile);
	    targetFile.delete();
	    
	    File decryptFile = new File(filePath+"sampledec.txt");
	    CryptoUtilsTest.decryptAlgoritham("shyamshyamshyamm", ecncryptFile, decryptFile);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		/*
		 * kycModel.setName(name); kycModel.setFatherName(fname);
		 * kycModel.setMotherName(mname); kycModel.setMobile(mobile);
		 * kycModel.setGender(gender); kycModel.setAddress(address);
		 * kycModel.setInputStream(inputStream); kycModel.setHashValue(hashValue);
		 * kycModel.setUserid(rm.getUserid());
		 * 
		 * try { boolean b = uks.uploadKyc(kycModel); if(b==true) { String info =
		 * "<div class=\"alert alert-success wrap-input100\">\n" +
		 * "                        <p style=\"font-family: Ubuntu-Bold; font-size: 18px; margin: 0.25em 0; text-align: center\">\n"
		 * + "                            Upload Success!\n" +
		 * "                        </p>\n" + "                    </div>";
		 * req.setAttribute("info", info);
		 * req.getRequestDispatcher("uploadkyc.jsp").forward(req, resp); }else { String
		 * alert = "<div class=\"alert alert-danger wrap-input100\">\n" +
		 * "                        <p style=\"font-family: Ubuntu-Bold; font-size: 18px; margin: 0.25em 0; text-align: center\">\n"
		 * + "                            KYC document updation failed\n" +
		 * "                        </p>\n" + "                    </div>";
		 * req.setAttribute("alert", alert);
		 * req.getRequestDispatcher("uploadkyc.jsp").forward(req, resp);
		 * 
		 * } } catch (ClassNotFoundException | SQLException e) { e.printStackTrace();
		 * String alert = "<div class=\"alert alert-danger wrap-input100\">\n" +
		 * "                        <p style=\"font-family: Ubuntu-Bold; font-size: 18px; margin: 0.25em 0; text-align: center\">\n"
		 * + "                            Image size is greater than 1mb \n" +
		 * "                        </p>\n" + "                    </div>";
		 * req.setAttribute("alert", alert);
		 * req.getRequestDispatcher("upload.jsp").forward(req, resp); }
		 */

	}

}
