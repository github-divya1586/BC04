package com.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

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

		String fname = req.getParameter("fileName");
		String userId = req.getParameter("userId");
		String domain = req.getParameter("domain");

		Part part = req.getPart("file");

		InputStream inputStream = part.getInputStream();

		HttpSession session = req.getSession();
		RegisterModel rm = (RegisterModel) session.getAttribute("account");

		String genearatehash = rm.getEmailid() + rm.getPassword();
		// + gender.substring(0, 2);
		String hashValue = HashCodeGenearate.getHashValue(genearatehash);
		try {
			String filePath = "C:\\Users\\shyam\\git\\BC04\\WebContent\\files\\";
			System.out.println(filePath);

			File targetFile = new File(filePath + fname + ".txt");

			try (OutputStream outStream = new FileOutputStream(targetFile)) {
				byte[] buffer = new byte[8 * 1024];
				int bytesRead;
				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outStream.write(buffer, 0, bytesRead);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			File ecncryptFile = new File(filePath + fname + "enc.txt");

			CryptoUtilsTest.encrptAlgoritham("shyamshyamshyamm", targetFile, ecncryptFile);
			targetFile.delete();

			boolean f = uks.insertFile(Integer.parseInt(userId), fname, hashValue, domain);
			if (f) {
				String info = "<div class=\"alert alert-success wrap-input100\">\n"
						+ "                        <p style=\"font-family: Ubuntu-Bold; font-size: 18px; margin: 0.25em 0; text-align: center\">\n"
						+ "                            Upload Success!\n" + "                        </p>\n"
						+ "                    </div>";
				req.setAttribute("info", info);
				req.setAttribute("userpage", "upload");
				req.getRequestDispatcher("profile.jsp").forward(req, resp);
			} else {

			}

		} catch (Exception e) {
			String alert = "<div class=\"alert alert-success wrap-input100\">\n"
					+ "                        <p style=\"font-family: Ubuntu-Bold; font-size: 18px; margin: 0.25em 0; text-align: center\">\n"
					+ "                            " + e.getMessage() + "                        </p>\n"
					+ "                    </div>";
			req.setAttribute("info", alert);
			req.setAttribute("userpage", "upload");
			req.getRequestDispatcher("profile.jsp").forward(req, resp);
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
