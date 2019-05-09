package db;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import business.Product;

public class ProductDB implements DAO<Product> {

	private Connection getConnection() throws SQLException {
		String dbUrl = "jdbc:mysql://localhost:3306/mma";
		String username = "mma_user";
		String pwd = "sesame";
		Connection con = DriverManager.getConnection(dbUrl, username, pwd);
		return con;
	}

	@Override
	public Product get(String code) {
		
		String sql = "SELECT * FROM product where code = ?";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, code);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String description = rs.getString("Description");
				double price = rs.getDouble("Price");
				Product p = new Product(code, description, price);
				rs.close();
				return p;
				
			} else {
				rs.close();
				return null;
			}
		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}
		
	}

	@Override
	public List<Product> getAll() {

		String sql = "SELECT Code, Description, Price " + "FROM Product";
		List<Product> products = new ArrayList<>();
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				String code = rs.getString("Code");
				String description = rs.getString("Description");
				double price = rs.getDouble("Price");

				Product p = new Product(code, description, price);
				products.add(p);
				

			} return products;

		} catch (SQLException e) {
			System.err.println(e);
			products = null;

		} return products;
	}

	@Override
	public boolean add(Product t) {
		
		String sql = "INSERT INTO Product (code,description,price) "
				+ "VALUES (?, ?, ?)";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			
			ps.setString(1,  t.getCode());
			ps.setString(2, t.getDescription());
			ps.setDouble(3, t.getPrice());
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
		String sql = "delete from product " +
					"WHERE code = ?";
				try(Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
					ps.setString(1,  t.getCode());
					ps.executeUpdate();
					return true;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
	}

}
