package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import business.User;

public class UserDB implements DAO<User> {
	
	private Connection getConnection() throws SQLException {
		String dbUrl = "jdbc:mysql://localhost:3306/prs";
		String username = "prs_user";
		String pwd = "sesame";
		Connection con = DriverManager.getConnection(dbUrl, username, pwd);
		return con;
	}

	@Override
	public User get(int ID) {
		
		String sql = "SELECT * FROM User where ID = ?";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, ID);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String userName = rs.getString("UserName");
				String password = rs.getString("Password");
				String firstName = rs.getString("FirstName");
				String lastName = rs.getString("LastName");
				String phoneNumber = rs.getString("PhoneNumber");
				String email = rs.getString("Email");
				User p = new User(ID, userName, password, firstName, lastName, phoneNumber, email);
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
	public List<User> getAll() {
		String sql = "SELECT ID, UserName, Password, FirstName, LastName, PhoneNumber, Email, IsReviewer, IsAdmin " + "FROM User";
		List<User> users = new ArrayList<>();
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				int ID = rs.getInt("ID");
				String userName = rs.getString("UserName");
				String password = rs.getString("Password");
				String firstName = rs.getString("FirstName");
				String lastName = rs.getString("LastName");
				String phoneNumber = rs.getString("PhoneNumber");
				String email = rs.getString("Email");
				boolean isReviewer = rs.getBoolean("IsReviewer");
				boolean isAdmin = rs.getBoolean("IsAdmin");
				User p = new User(ID, userName, password, firstName, lastName, phoneNumber, email, isReviewer, isAdmin);
				users.add(p);
				

			} return users;

		} catch (SQLException e) {
			System.err.println(e);
			users = null;

		} return users;
	}

	@Override
	public boolean add(User t) {
		String sql = "INSERT INTO User (UserName, Password, FirstName, LastName, PhoneNumber, Email) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			
//			ps.setInt(1,  t.getId());
			ps.setString(1, t.getUserName());
			ps.setString(2, t.getPassword());
			ps.setString(3, t.getFirstName());
			ps.setString(4, t.getLastName());
			ps.setString(5, t.getPhoneNumber());
			ps.setString(6, t.getEmail());
			ps.executeUpdate();
			return true;
			
			
		} catch (SQLException e) {
			System.err.println(e);
			e.printStackTrace();
			return false;
		}
	}
	

	@Override
	public boolean update(User t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(User t) {
		String sql = "DELETE from User " +
				"WHERE ID = ?";
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
