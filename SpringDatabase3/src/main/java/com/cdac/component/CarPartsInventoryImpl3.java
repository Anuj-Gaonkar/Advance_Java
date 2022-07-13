package com.cdac.component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("carParts3")
public class CarPartsInventoryImpl3 implements CarPartsInventory {
	@Autowired
	private DataSource dataSource;
	
	public void addNewPart(CarPart carPart) {
		Connection conn = null;
		try {
			long ms1 = System.currentTimeMillis();
			conn = dataSource.getConnection();
			long ms2 = System.currentTimeMillis();
			System.out.println("Approx time taken to obtain a connection from the pool : " + (ms2 - ms1) + " ms");
	
			PreparedStatement st = conn.prepareStatement("insert into tbl_carpart(part_name, car_model, price, quantity) values(?, ?, ?, ?)");
			st.setString(1, carPart.getPartName());
			st.setString(2, carPart.getCarModel());
			st.setDouble(3, carPart.getPrice());
			st.setInt(4, carPart.getQuantity());
			st.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}				
	}

	public List<CarPart> getAvailableParts() {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
	
			PreparedStatement st = conn.prepareStatement("select * from tbl_carpart");
			ResultSet rs = st.executeQuery();
			
			List<CarPart> list = new ArrayList<>();
			while (rs.next()) {
				CarPart carPart = new CarPart();
				carPart.setPartNo(rs.getInt(1));
				carPart.setPartName(rs.getString(2));
				carPart.setCarModel(rs.getString(3));
				carPart.setPrice(rs.getDouble(4));
				carPart.setQuantity(rs.getInt(5));
				list.add(carPart);
			}
			return list;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}	
	}
}
