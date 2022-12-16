package com.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import com.configurations.AppConfig;
import com.dao.DAO;
import com.model.FileModel;
import com.model.KycModel;
import com.model.RegisterModel;

public class UploadKycService {

	DAO dao = AppConfig.getDao();

	public boolean uploadKyc(KycModel kycModel) throws ClassNotFoundException, SQLException {

		int i = dao.insertKyc(kycModel);
		if (i != -1) {
			return true;
		} else {
			return false;
		}

	}

	public List<KycModel> getKyc(int userid) throws ClassNotFoundException, SQLException, IOException {

		List<KycModel> listKyc = new ArrayList<KycModel>();
		ResultSet rs = dao.getKyc(userid);
		/*
		 * if(rs.next()) { System.out.println(rs.getString(1)); }
		 */

		if (rs.next() == false) {
			return listKyc;

		} else {
			do {
				KycModel km = new KycModel();
				km.setName(rs.getString("uname"));
				km.setFatherName(rs.getString("fname"));
				km.setMotherName(rs.getString("mname"));
				km.setMobile(rs.getString("mobile"));
				km.setBase64Image(getBase64Image(rs.getBlob(2)));
				listKyc.add(km);
			} while (rs.next());
		}

		return listKyc;

	}

	// Method to get blob image from database.
	private String getBase64Image(Blob blob) throws SQLException, IOException {
		InputStream inputStream = blob.getBinaryStream();
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[4096];
		int bytesRead = -1;

		while ((bytesRead = inputStream.read(buffer)) != -1) {
			byteArrayOutputStream.write(buffer, 0, bytesRead);
		}
		byte[] imageBytes = byteArrayOutputStream.toByteArray();

		return Base64.getEncoder().encodeToString(imageBytes);
	}

	public int uploadFile(int userid, String fileName, String hashkey) {

		return 0;
	}

	public RegisterModel getUserDetails(int userId) throws ClassNotFoundException, SQLException {

		ResultSet rs = dao.getUserDetails(userId);
		if (rs.next()) {
			return new RegisterModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(5), rs.getString(4));

		} else {
			return null;
		}

	}

	public boolean insertFile(int userId, String fname, String hashValue,
			String domain) throws ClassNotFoundException, SQLException {

		int i = dao.insertUploadFile(userId, fname, hashValue,domain);

		if (i != -1) {
			return true;
		} else {
			return false;
		}

	}

	public List<FileModel> getFiles(int userid) throws ClassNotFoundException, SQLException {

		ResultSet rs = dao.getFiles(userid);

		List<FileModel> al = new ArrayList<FileModel>();

		while (rs.next()) {

			FileModel fm = new FileModel();
			fm.setUserId(rs.getInt(2));
			fm.setFileName(rs.getString(3));
			fm.setHashKey(rs.getString(4));
			al.add(fm);

		}

		return al;

	}

}
