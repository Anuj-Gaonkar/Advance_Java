package com.cdac.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Base64;

public class RegisterService {
	public boolean isRegistered(String email) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_for_jdbc", "anuj", "cdac");
			
			boolean present = false;
			
			PreparedStatement st = conn.prepareStatement("select count(*) from students where email = ?");
			st.setString(1, email);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				int c = rs.getInt(1);
				if(c == 1)
					present = true;
			}
			return present;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		} finally {
			try { conn.close(); } catch(Exception e) { }
		}
	}
	
	public int insertEntry(String name, String email, String mobileno, String username, String password) {
		System.out.println("W8");
		int mobile = Integer.parseInt(mobileno);
		String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
		
		Connection conn = null;
		int updated = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_for_jdbc", "anuj", "cdac");
			
			PreparedStatement st = conn.prepareStatement("insert into students (name, email, mobileno, username, password)"
					+ " value (?, ?, ?, ?, ?)");
			st.setString(1, name);
			st.setString(2, email);
			st.setInt(3, mobile);
			st.setString(4, username);
			st.setString(5, encodedPassword);
			updated = st.executeUpdate();
			return updated;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			updated = 0;
			return updated;
		} finally {
			try {conn.close();} catch (Exception e2) { }
		}
		
	}
	
//	public static void main(String[] args) {
//		String password = "anuj@123";
//		String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
//		System.out.println(encodedPassword);
//		
//		byte[] decodedBytes = Base64.getDecoder().decode(encodedPassword);
//		String decodedString = new String(decodedBytes);
//		System.out.println(decodedString);
//	}
}
