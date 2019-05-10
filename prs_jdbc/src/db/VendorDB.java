package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import business.User;
import business.Vendor;

public class VendorDB implements DAO<Vendor> {
	
	private Connection getConnection() throws SQLException {
		String dbUrl = "jdbc:mysql://localhost:3306/prs";
		String username = "prs_user";
		String pwd = "sesame";
		Connection con = DriverManager.getConnection(dbUrl, username, pwd);
		return con;
	}

	@Override
	public Vendor get(int ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vendor> getAll() {
		String sql = "SELECT ID, Code, Name, Address, City, State, Zip, PhoneNumber, Email, IsPreapproved "
				+ "FROM Vendor";
		List<Vendor> vendors = new ArrayList<>();
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				int ID = rs.getInt("ID");
				String code = rs.getString("Code");
				String name = rs.getString("Name");
				String address = rs.getString("Address");
				String city = rs.getString("City");
				String state = rs.getString("State");
				String zip = rs.getString("Zip");
				String phoneNumber = rs.getString("PhoneNumber");
				String email = rs.getString("Email");
				boolean isPreapproved = rs.getBoolean("IsPreapproved");

				Vendor p = new Vendor(ID, code, name, address, city, state, zip, phoneNumber, email, isPreapproved);
				vendors.add(p);
				

			} return vendors;

		} catch (SQLException e) {
			System.err.println(e);
			vendors = null;

		} return vendors;
	}

	@Override
	public boolean add(Vendor t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Vendor t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Vendor t) {
		// TODO Auto-generated method stub
		return false;
	}


}
