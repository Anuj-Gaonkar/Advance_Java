package com.cdac.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginService {
	public boolean isValid(String username, String password) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/db_for_jdbc", "anuj", "cdac");
			
			PreparedStatement pst = conn.prepareStatement("select password from students where username = ?");
			pst.setString(1, username);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String curPassword = rs.getString(1);
				if (curPassword.equals(password)) {
					System.out.println("is equal");
					return true;
				}
			}
			return false;
			
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}
	}
}
