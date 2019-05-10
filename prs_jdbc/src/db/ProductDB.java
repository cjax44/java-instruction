package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import business.Product;
import business.Vendor;

public class ProductDB implements DAO<Product> {
	
	private Connection getConnection() throws SQLException {
		String dbUrl = "jdbc:mysql://localhost:3306/prs";
		String username = "prs_user";
		String pwd = "sesame";
		Connection con = DriverManager.getConnection(dbUrl, username, pwd);
		return con;
	}

	@Override
	public Product get(int ID) {
		return null;
	}

	@Override
	public List<Product> getAll() {
		String sql = "SELECT ID, VendorID, PartNumber, Name, Price, Unit, PhotoPath " + "FROM Product";
		List<Product> products = new ArrayList<>();
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				int id = rs.getInt("ID");
				int vendorID = rs.getInt("VendorID");
				String partNumber = rs.getString("PartNumber");
				String name = rs.getString("Name");
				int price = rs.getInt("Price");
//				String unit = rs.getString("Unit");
//				String photoPath = rs.getString("PhotoPath");


				Product p = new Product(id, vendorID, partNumber, name, price);
				products.add(p);
				

			} return products;

		} catch (SQLException e) {
			System.err.println(e);
			products = null;

		} return products;
	}

	@Override
	public boolean add(Product t) {
		
		String sql = "INSERT INTO Product (VendorID, PartNumber, Name, Price, PhotoPath) "
				+ "VALUES (?, ?, ?, ?, ?)";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			
//			ps.setInt(1,  t.getId());
			ps.setInt(1, t.getVendorId());
			ps.setString(2, t.getPartNumber());
			ps.setString(3, t.getName());
			ps.setDouble(4, t.getPrice());
			ps.setString(5, t.getPhotoPath());
			ps.executeUpdate();
			return true;
			
			
		} catch (SQLException e) {
			System.err.println(e);
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Product t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Product t) {
		// TODO Auto-generated method stub
		return false;
	}

}
