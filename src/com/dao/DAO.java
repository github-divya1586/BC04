package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;


import com.database.DbConnection;
import com.model.KycModel;
import com.model.RegisterModel;

public class DAO {

	public int registerUser(RegisterModel rm) throws ClassNotFoundException, SQLException {

		Connection con = DbConnection.getCon();
		String sql = "insert into register values(0,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, rm.getName());
		ps.setString(2, rm.getEmailid());
		ps.setString(3, rm.getPassword());
		ps.setString(4, rm.getMobile());
		int statusReg = ps.executeUpdate();
		return statusReg;
	}

	public ResultSet getEmails() throws ClassNotFoundException, SQLException {
		Connection con = DbConnection.getCon();
		String sql = "select * from register";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		return rs;
	}
	
	public ResultSet getUserDetails(int userid) throws ClassNotFoundException, SQLException {
		Connection con = DbConnection.getCon();
		String sql = "select * from register where userid="+userid;
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		return rs;
	}
	
	public ResultSet getAllUsers() throws ClassNotFoundException, SQLException {
		Connection con = DbConnection.getCon();
		String sql = "select * from register";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		return rs;
	}

	public int insertKyc(KycModel km) throws ClassNotFoundException, SQLException {

		int statusReg = 0;
		Connection con = DbConnection.getCon();
		String sql = "insert into userfiles values(0,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setBinaryStream(1, km.getInputStream());
		ps.setString(2, new Date().toString());
		ps.setInt(3, km.getUserid());
		ps.setString(4, km.getHashValue());
		ps.setString(5, km.getName());
		ps.setString(6, km.getFatherName());
		ps.setString(7, km.getMotherName());
		ps.setString(8, km.getMobile());
		ps.setString(9, km.getAddress());
		ps.setString(10, "");
		statusReg = ps.executeUpdate();
		return statusReg;

	}

	public ResultSet getKyc(int userid) throws ClassNotFoundException, SQLException {
		Connection con = DbConnection.getCon();
		String sql = "select * from userfiles where userid="+userid ;
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		return rs;
	}

	public int insertUploadFile(int userId, String fname, String hashValue,String domain) throws ClassNotFoundException, SQLException {
		
		Connection con = DbConnection.getCon();
		String sql = "insert into fileupload values(0,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, userId);
		ps.setString(2, domain);
		ps.setString(3, fname);
		ps.setString(4, hashValue);
		return ps.executeUpdate();		
	}

	public ResultSet getFiles(int userid) throws ClassNotFoundException, SQLException {
		Connection con = DbConnection.getCon();
		String sql = "select * from fileupload where userid="+userid ;
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		return rs;
	}

	public int insertStatus(String sql, String dd) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = DbConnection.getCon();
		String sql1 = "update statustable set Sqlinject=?, DDos=?";
		PreparedStatement ps=con.prepareStatement(sql1);
		ps.setInt(1, Integer.parseInt(sql));
		ps.setInt(2, Integer.parseInt(dd));
		int i=ps.executeUpdate();
		return i;
	}

	public ResultSet getStatusOfAttack() throws ClassNotFoundException, SQLException {
		Connection con = DbConnection.getCon();
		String sql = "select * from statustable";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		return rs;
	}

	public ResultSet getFiles() throws ClassNotFoundException, SQLException {
		Connection con = DbConnection.getCon();
		String sql = "select * from fileupload";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		return rs;
	}

}
