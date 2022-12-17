package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.database.DbConnection;

public class LoginDAO {

	public ResultSet checkUser(String email,String password) throws ClassNotFoundException, SQLException {

		Connection con = DbConnection.getCon();
		String sql = "select * from register where emailid=? and password=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, email);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		return rs;
	}
	public ResultSet checkUser1(String email,String password) throws ClassNotFoundException, SQLException {

		Connection con = DbConnection.getCon();
		String sql = "SELECT username,PASSWORD"
				+ " FROM register"
				+ " WHERE emailid =? UNION SELECT emailid,PASSWORD FROM register";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, email);
		ResultSet rs = ps.executeQuery();
		return rs;
	}
	
	public ResultSet checkUser(String email) throws ClassNotFoundException, SQLException {
		Connection con = DbConnection.getCon();
		String sql = "select * from register where emailid=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, email);
		ResultSet rs = ps.executeQuery();
		return rs;
		
	}

	public int getAttack(String string) throws ClassNotFoundException, SQLException {
		Connection con = DbConnection.getCon();
		String sql = "select * from statustable";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			return rs.getInt(2);
		}else {
			return rs.getInt(2);
		}
		
	}

}
