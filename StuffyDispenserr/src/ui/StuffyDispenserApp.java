package ui;

import java.util.ArrayList;
import java.util.List;
import business.Stuffy;
import db.DAO;
import db.StuffyDB;
import util.Console;
import util.StringUtils;

public class StuffyDispenserApp {
	
	private static DAO<Stuffy> stuffyDAO = new StuffyDB();

	public static void main(String[] args) {

		System.out.println("Welcome to the Stuffy Dispenser App");
		System.out.println("This app will mimic the functionality of a stuffy dispensing machine. "
				+ "The user will be able to select a stuffy, and hopefully the app will return one!");

		// initialize a list of stuffies
		
//		List<Stuffy> stuffies = new ArrayList<>();
		
		StuffyDB stuffyInfo = new StuffyDB();
		stuffyInfo.getAll();
		
		

		// Loop until user wants to quit
		String choice = "";
		while (!choice.equalsIgnoreCase("x")) {

			// Inside Loop
			choice = Console.getRequiredString(getMenuOptions());

			if (choice.equalsIgnoreCase("s")) {

				// 1) Prompt for user input ("Pick a stuffy")
				int selectionNbr = Console.getIntWithinRange("Pick a stuffy by number: ", 0, 457);

//				selectionNbr--;
				// 2) Do business logic (retrieve stuffy from list)

				Stuffy selectedStuffy = stuffyInfo.get(selectionNbr);
				
				

				// 3) Display the selected stuffy

				System.out.println("Congratulations, you have a " + selectedStuffy.getSize() + ", "
						+ selectedStuffy.getColor() + " " + selectedStuffy.getType() + " stuffy!!!");

			} else if (choice.equalsIgnoreCase("a")) {
				//add a stuffy
//				int id = Console.getInt("Stuffy ID:   ");
				String t = Console.getRequiredString("Stuffy Type:   ");
				String c = Console.getRequiredString("Stuffy Color:   ");
				String s = Console.getRequiredString("Stuffy Size:   ");
				int l = Console.getInt("Stuffy # of limbs:   ");
				
				Stuffy stuffy = new Stuffy(t, c, s, l);
				stuffyInfo.add(stuffy);
				
			} else if (choice.equalsIgnoreCase("L")) {
				displayAllStuffies();
			} else if (choice.equalsIgnoreCase("D")) {
				// OLD WAY
//				System.out.println("WARNING - DELETING STUFFIES\n");
//				int id = Console.getInt("Enter ID of stuffy to delete:  ");
//				Stuffy stuffy = stuffyDAO.get(id);
//				stuffyInfo.delete(stuffy);
//				System.out.println("Successfully deleted stuffy\n");
				delStuffy();
				
			}

		}

		System.out.println("Goodbye!");

	}

	private static String getMenuOptions() {

		String s = "Menu Options\n" + "L - List all stuffies\n"+ "S - Search for a Stuffy\n" + "A - Add a Stuffy\n" + "D - Delete a Stuffy\n" + "X - Exit\n";

		return s;

	}
	
	private static void displayAllStuffies() {
		System.out.println("PRODUCT LIST:");
		System.out.println("=====================");
		List<Stuffy> stuffies = stuffyDAO.getAll();
		StringBuilder sb = new StringBuilder();
		for (Stuffy p: stuffies) {
			sb.append(p.getId() + "\t");
			sb.append(StringUtils.padWithSpaces(p.getType(), 15));
			sb.append(StringUtils.padWithSpaces(p.getSize(), 15));
			sb.append(StringUtils.padWithSpaces(p.getColor(), 15));
			sb.append(p.getLimbs());
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static void delStuffy() {
		System.out.println("WARNING: DELETING STUFFY!!!!");
		int id = Console.getInt("Enter stuffy ID to delete:  ");
		// get a product based on code
		Stuffy p = stuffyDAO.get(id);
		if (p == null) {
			System.out.println("Invalid code.");
		}
		else {
			if (stuffyDAO.delete(p)) {
				System.out.println("Delete success");
			} else {
				System.out.println("Error deleting product.");
			}
		}
		
	}

}
//				for (Stuffy s: stuffies) {
//					//compare id to selectionNbr
//					if (s.getId() == selectionNbr) {
//						selectedStuffy = s;
//					}
//					
//					
//				}


// 2nd iteration using List
//		List<Stuffy> stuffies = new ArrayList<>();
//
//		stuffies.add(new Stuffy(1, "Dog", "Blue", "Large", 4));
//		stuffies.add(new Stuffy(2, "Cat", "Green", "Small", 4));
//		stuffies.add(new Stuffy(3, "Dragon", "Purple", "Medium", 6));
//		stuffies.add(new Stuffy(4, "Snail", "Yellow", "X-Large", 1));
//		stuffies.add(new Stuffy(5, "Platypus", "Blue", "Medium", 4));
//		stuffies.add(new Stuffy(6, "Octopus", "Purple", "Large", 8));
//		stuffies.add(new Stuffy(7, "Squirrel", "Brown", "Small", 4));
//		stuffies.add(new Stuffy(8, "Starfish", "Pink", "X-Large", 5));
//		stuffies.add(new Stuffy(9, "Lobster", "Red", "Large", 10));
//		stuffies.add(new Stuffy(10, "Spider", "Clear", "Small", 8));
//
//		for (Stuffy s : stuffies) {
//
//			System.out.println(s);
//
//		}

// 1st iteration using Arrays		
// 		Stuffy[] stuffies = new Stuffy[10];
//		stuffies[0] = new Stuffy(1, "Dog", "Blue", "Large", 4);
//		stuffies[1] = new Stuffy(2, "Cat", "Green", "Small", 4);
//		stuffies[2] = new Stuffy(3, "Dragon", "Purple", "Medium", 6);
//		stuffies[3] = new Stuffy(4, "Snail", "Yellow", "X-Large", 1);
//		stuffies[4] = new Stuffy(5, "Platypus", "Blue", "Medium", 4);
//		stuffies[5] = new Stuffy(6, "Octopus", "Purple", "Large", 8);
//		stuffies[6] = new Stuffy(7, "Squirrel", "Brown", "Small", 4);
//		stuffies[7] = new Stuffy(8, "Starfish", "Pink", "X-Large", 5);
//		stuffies[8] = new Stuffy(9, "Lobster", "Red", "Large", 10);
//		stuffies[9] = new Stuffy(10, "Spider", "Clear", "Small", 8);
// printing list of stuffies		
//		for (int i = 0; i < stuffies.length; i++) {
//			System.out.println("Stuffy " + i + ": " + stuffies[i].toString());
//		}
//		