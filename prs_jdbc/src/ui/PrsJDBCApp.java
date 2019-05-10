package ui;

import util.Console;
import util.StringUtils;

import java.util.List;

import business.*;
import db.*;

public class PrsJDBCApp {
	
	private static DAO<Vendor> vendorDAO = new VendorDB();
	private static DAO<User> userDAO = new UserDB();
	private static DAO<Product> productDAO = new ProductDB();

	public static void main(String[] args) {
		
	
		
		System.out.println("Welcome to the PrsJDBC App");
		
		String choice = "";
		while (!choice.equalsIgnoreCase("x")) {

			// Inside Loop
			choice = Console.getRequiredString(getMenuOptions());
			
			if (choice.equalsIgnoreCase("V")) {
				displayAllVendors();
			} else if (choice.equalsIgnoreCase("U")) {
				displayAllUsers();
			} else if (choice.equalsIgnoreCase("P")) {
				displayAllProducts();
			} else if (choice.equalsIgnoreCase("+V")) {
				
				String code = Console.getRequiredString("Vendor Code:   ");
				String name = Console.getRequiredString("Stuffy Name:   ");
				String address = Console.getRequiredString("Stuffy Address:   ");
				String city = Console.getRequiredString("Stuffy City:   ");
				String state = Console.getRequiredString("Stuffy State:   ");
				String zip = Console.getRequiredString("Stuffy Zip:   ");
				String phoneNumber = Console.getRequiredString("Stuffy Phone Number:   ");
				String email = Console.getRequiredString("Stuffy Email:   ");
				
				Vendor v = new Vendor(code, name, address, city, state, zip, phoneNumber, email);
				vendorDAO.add(v);
				
			} else if (choice.equalsIgnoreCase("+U")) {
				
				String username = Console.getRequiredString("Username:   ");
				String password = Console.getRequiredString("Password:   ");
				String firstName = Console.getRequiredString("First Name:   ");
				String lastName = Console.getRequiredString("Last Name:   ");
				String phoneNumber = Console.getRequiredString("Phone Number:   ");
				String email = Console.getRequiredString("Email:   ");
				
				User u = new User(username, password, firstName, lastName, phoneNumber, email);
				userDAO.add(u);
				
			} else if (choice.equalsIgnoreCase("+P")) {
				
				int vendorId = Console.getInt("Vendor ID:   ");
				String partNumber = Console.getRequiredString("Part Number:   ");
				String name = Console.getRequiredString("Name:   ");
				double price = Console.getDouble("Price:   ");
				String photoPath = Console.getRequiredString("PhotoPath:   ");
			
				
				Product p = new Product(vendorId, partNumber, name, price, photoPath);
				productDAO.add(p);
				
			} else if (choice.equalsIgnoreCase("-V")) {
				
			} else if (choice.equalsIgnoreCase("-U")) {
				delUser();
				
			} else if (choice.equalsIgnoreCase("-P")) {
				
			}
			
			
		} 
		
		System.out.println("Thanks for using this amazing PrsJDBC App!");


	}
		
	private static String getMenuOptions() {

		String s = "\nMenu Options\n============"
				+ "\nType + in front of your selection to add\n"
				+ "\nType - in front of your selection to subtract\n\n"
				+ "V - List all vendors\n"
//				+ "+V - Add a vendor\n"
				+ "U - List all Users\n"
//				+ "+U - Add a user\n"
				+ "P - List all products\n"
//				+ "+P - Add a product\n"
				+ "X - Exit\n";

		return s;

	}
	
	private static void displayAllProducts() {
		System.out.println("PRODUCT LIST:");
		System.out.println("=====================");
		List<Product> products = productDAO.getAll();
		StringBuilder sb = new StringBuilder();
		for (Product p: products) {
			sb.append(p.getId() + "\t");
			sb.append(p.getVendorId());
			sb.append(StringUtils.padWithSpaces(p.getPartNumber(), 15));
			sb.append(StringUtils.padWithSpaces(p.getName(), 15));
			sb.append(p.getPrice());
//			sb.append(StringUtils.padWithSpaces(p.getUnit(), 15));
//			sb.append(StringUtils.padWithSpaces(p.getPhotoPath(), 15));
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static void displayAllUsers() {
		System.out.println("USER LIST:");
		System.out.println("=====================");
		List<User> users = userDAO.getAll();
		StringBuilder sb = new StringBuilder();
		for (User p: users) {
			sb.append(p.getId() + "\t");
			sb.append(StringUtils.padWithSpaces(p.getUserName(), 15));
			sb.append(StringUtils.padWithSpaces(p.getFirstName(), 15));
			sb.append(StringUtils.padWithSpaces(p.getLastName(), 15));
			sb.append(StringUtils.padWithSpaces(p.getPhoneNumber(), 15));
			sb.append(StringUtils.padWithSpaces(p.getEmail(), 15));
			sb.append(p.isReviewer());
			sb.append(p.isReviewer());
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static void displayAllVendors() {
		System.out.println("VENDOR LIST:");
		System.out.println("=====================");
		List<Vendor> vendors = vendorDAO.getAll();
		StringBuilder sb = new StringBuilder();
		for (Vendor p: vendors) {
			sb.append(p.getId() + "\t");
			sb.append(p.getCode());
			sb.append(StringUtils.padWithSpaces(p.getName(), 15));
			sb.append(StringUtils.padWithSpaces(p.getAddress(), 15));
			sb.append(StringUtils.padWithSpaces(p.getCity(), 15));
			sb.append(StringUtils.padWithSpaces(p.getState(), 15));
			sb.append(StringUtils.padWithSpaces(p.getZip(), 15));
			sb.append(StringUtils.padWithSpaces(p.getPhoneNumber(), 15));
			sb.append(StringUtils.padWithSpaces(p.getEmail(), 15));
			sb.append(p.isPreApproved());
			
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static void delUser() {
		System.out.println("WARNING: DELETING USER!!!!");
		int id = Console.getInt("Enter User ID to delete:  ");
		// get a product based on code
		User p = userDAO.get(id);
		if (p == null) {
			System.out.println("Invalid code.");
		}
		else {
			if (userDAO.delete(p)) {
				System.out.println("Delete success");
			} else {
				System.out.println("Error deleting product.");
			}
		}
		
	}

}
