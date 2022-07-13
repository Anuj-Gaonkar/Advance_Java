package com.cdac.component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

@Component("userFunction1")
public class UserFunctionImpl1 implements UserFunctions {

	public void add(String name, String email, String password) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring_test", "root", "cdac");
			PreparedStatement st = conn.prepareStatement("insert into tbl_myusr(name, email, password) values (?, ?, ?)");
			st.setString(1, name);
			st.setString(2, email);
			st.setString(3, password);
			st.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void find(int id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring_test", "root", "cdac");
			PreparedStatement st = conn.prepareStatement("select * from tbl_myusr where userid = ?");
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if (rs == null ) {
				System.out.println("Nothing found");
			} else {
				System.out.println("Found");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring_test", "root", "cdac");
			PreparedStatement st = conn.prepareStatement("insert into tbl_myusr(name, email, password) values (?, ?, ?)");
			st.setString(1, user.getName());
			st.setString(2, user.getEmail());
			st.setString(3, user.getPassword());
			st.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
