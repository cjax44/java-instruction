package db;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import business.Stuffy;

public class StuffyDB implements DAO<Stuffy> {

	private Connection getConnection() throws SQLException {
		String dbUrl = "jdbc:mysql://localhost:3306/stuffy";
		String username = "stuffy_user";
		String pwd = "sesame";
		Connection con = DriverManager.getConnection(dbUrl, username, pwd);
		return con;
	}

	@Override
	public Stuffy get(int ID) {
		
		String sql = "SELECT * FROM Stuffy where ID = ?";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, ID);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String type = rs.getString("Type");
				String color = rs.getString("Color");
				String size = rs.getString("Size");
				int limbs = rs.getInt("Limbs");
				Stuffy p = new Stuffy(ID, type, color, size, limbs);
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
	public List<Stuffy> getAll() {

		String sql = "SELECT ID, Type, Color, Size, Limbs " + "FROM Stuffy";
		List<Stuffy> stuffies = new ArrayList<>();
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				int ID = rs.getInt("ID");
				String type = rs.getString("Type");
				String color = rs.getString("Color");
				String size = rs.getString("Size");
				int limbs = rs.getInt("Limbs");
				Stuffy p = new Stuffy(ID, type, color, size, limbs);
				stuffies.add(p);
				

			} return stuffies;

		} catch (SQLException e) {
			System.err.println(e);
			stuffies = null;

		} return stuffies;
	}

	@Override
	public boolean add(Stuffy t) {
		
		String sql = "INSERT INTO Stuffy (type, color, size, limbs) "
				+ "VALUES (?, ?, ?, ?)";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			
//			ps.setInt(1,  t.getId());
			ps.setString(1, t.getType());
			ps.setString(2, t.getColor());
			ps.setString(3, t.getSize());
			ps.setInt(4, t.getLimbs());
			ps.executeUpdate();
			return true;
			
			
		} catch (SQLException e) {
			System.err.println(e);
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean update(Stuffy t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Stuffy t) {
		String sql = "delete from product " +
					"WHERE code = ?";
				try(Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
					ps.setInt(1,  t.getId());
					ps.executeUpdate();
					return true;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
	}

}