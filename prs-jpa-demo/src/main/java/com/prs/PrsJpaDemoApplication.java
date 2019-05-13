package com.prs;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.prs.business.*;
import com.prs.db.*;
import com.prs.util.*;

@SpringBootApplication
public class PrsJpaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrsJpaDemoApplication.class, args);

			System.out.println("Welcome to the prs-jpa-demo App");
			
			String choice = "";
			while (!choice.equalsIgnoreCase("x")) {

				// Inside Loop
				choice = Console.getRequiredString(getMenuOptions());
				
				if (choice.equalsIgnoreCase("V")) {
//					displayAllVendors();
				} else if (choice.equalsIgnoreCase("U")) {
					displayAllUsers();
				} else if (choice.equalsIgnoreCase("P")) {
					displayAllProducts();
				} else if (choice.equalsIgnoreCase("+V")) {
					
//					String code = Console.getRequiredString("Vendor Code:   ");
//					String name = Console.getRequiredString("Stuffy Name:   ");
//					String address = Console.getRequiredString("Stuffy Address:   ");
//					String city = Console.getRequiredString("Stuffy City:   ");
//					String state = Console.getRequiredString("Stuffy State:   ");
//					String zip = Console.getRequiredString("Stuffy Zip:   ");
//					String phoneNumber = Console.getRequiredString("Stuffy Phone Number:   ");
//					String email = Console.getRequiredString("Stuffy Email:   ");
//					
//					Vendor v = new Vendor(code, name, address, city, state, zip, phoneNumber, email);
//					vendorDAO.add(v);
//					
				} else if (choice.equalsIgnoreCase("+U")) {
					
					String username = Console.getRequiredString("Username:   ");
					String password = Console.getRequiredString("Password:   ");
					String firstName = Console.getRequiredString("First Name:   ");
					String lastName = Console.getRequiredString("Last Name:   ");
					String phoneNumber = Console.getRequiredString("Phone Number:   ");
					String email = Console.getRequiredString("Email:   ");
					
					User u = new User(username, password, firstName, lastName, phoneNumber, email);
					UserDB.insert(u);
					
				} else if (choice.equalsIgnoreCase("+P")) {
					
					int vendorId = Console.getInt("Vendor ID:   ");
					Vendor vendor = VendorDB.selectVendor(vendorId);
					String partNumber = Console.getRequiredString("Part Number:   ");
					String name = Console.getRequiredString("Name:   ");
					double price = Console.getDouble("Price:   ");
					String photoPath = Console.getRequiredString("PhotoPath:   ");
				
					
					Product p = new Product(vendor, partNumber, name, price, photoPath);
					ProductDB.insert(p);
					
				} else if (choice.equalsIgnoreCase("-V")) {
					
				} else if (choice.equalsIgnoreCase("-U")) {
					delUser();
					
				} else if (choice.equalsIgnoreCase("-P")) {
					delProd();
				}
				
				
			} 
			
			System.out.println("Thanks for using this amazing prs-jpa-demo App!");


		}
			
		private static String getMenuOptions() {

			String s = "\nMenu Options\n============"
					+ "\nType + in front of your selection to add\n"
					+ "\nType - in front of your selection to subtract\n\n"
					+ "V - List all vendors\n"
//					+ "+V - Add a vendor\n"
					+ "U - List all Users\n"
//					+ "+U - Add a user\n"
					+ "P - List all products\n"
//					+ "+P - Add a product\n"
					+ "X - Exit\n";

			return s;

		}
		
		private static void displayAllProducts() {
			System.out.println("PRODUCT LIST:");
			System.out.println("=====================");
			List<Product> products = ProductDB.getAll();
			StringBuilder sb = new StringBuilder();
			for (Product p: products) {
				sb.append(p.getId() + "\t");
				sb.append(p.getVendor().getCode() + "\t");
				sb.append(StringUtils.padWithSpaces(p.getPartNumber(), 15));
				sb.append(StringUtils.padWithSpaces(p.getName(), 55));
				sb.append(p.getPrice());
				sb.append("\n");
			}
			System.out.println(sb.toString());
		}
		
		private static void displayAllUsers() {
			System.out.println("USER LIST:");
			System.out.println("=====================");
			List<User> users = UserDB.getAll();
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
		
//		private static void displayAllVendors() {
//			System.out.println("VENDOR LIST:");
//			System.out.println("=====================");
//			List<Vendor> vendors = vendorDAO.getAll();
//			StringBuilder sb = new StringBuilder();
//			for (Vendor p: vendors) {
//				sb.append(p.getId() + "\t");
//				sb.append(p.getCode());
//				sb.append(StringUtils.padWithSpaces(p.getName(), 15));
//				sb.append(StringUtils.padWithSpaces(p.getAddress(), 15));
//				sb.append(StringUtils.padWithSpaces(p.getCity(), 15));
//				sb.append(StringUtils.padWithSpaces(p.getState(), 15));
//				sb.append(StringUtils.padWithSpaces(p.getZip(), 15));
//				sb.append(StringUtils.padWithSpaces(p.getPhoneNumber(), 15));
//				sb.append(StringUtils.padWithSpaces(p.getEmail(), 15));
//				sb.append(p.isPreApproved());
//				
//				sb.append("\n");
//			}
//			System.out.println(sb.toString());
//		}
//		
		private static void delUser() {
			System.out.println("WARNING: DELETING USER!!!!");
			String email = Console.getRequiredString("Enter User email to delete:  ");
			// get a product based on code
			User p = UserDB.selectUser(email);
			if (p == null) {
				System.out.println("Invalid code.");
			}
			else {
				try  {
					UserDB.delete(p);
					System.out.println("Delete success");
				} catch (Exception e) {
					System.err.println("DELETE WENT WRONG SOMEHOW");
				} 
				
			}
		}
		
		private static void delProd() {
			System.out.println("WARNING: DELETING PRODUCT!!!!");
			int id = Console.getInt("Enter Product ID to delete:  ");
			// get a product based on code
			Product p = ProductDB.selectProduct(id);  
			if (p == null) {
				System.out.println("Invalid code.");
			}
			else {
				try  {
					ProductDB.delete(p);
					System.out.println("Delete success");
				} catch (Exception e) {
					System.err.println("DELETE WENT WRONG SOMEHOW");
				} 
				
			}
		}
}
				
		
	
		// OLD WAY OF SETTING UP STUFF TO TEST USER LIST FUNCTIONALITY
		
//		System.out.println("Hello");
//		
//		List<User> users = UserDB.getAll();
//		
//		if (users!=null) {
//			for (User u: users) {
//				System.out.println(u);
//			}
//		} 
//		else {
//				System.out.println("users null");
//			}
//		
//		System.out.println("Goodbye");
//			
//		}
		


