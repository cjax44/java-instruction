package util;

import ui.NameGameApp;

public class Game {
	

	static int gameID;
	
	public static void nextPlayer() {
		
	}

	public Game(int gameID) {
		super();
		this.gameID = gameID;
	}

	public static int getGameID() {
		return gameID;
	}

	public void setGameID(int gameID) {
		this.gameID = gameID;
	}
	
	public static void compareNames(String firstName1, String lastName1, String firstName2, String lastName2) {
		String firstLetterFirstName = firstName2.substring(0,1);
		String firstLetterLastName = lastName1.substring(0, 1);
		
		if (firstLetterLastName.equalsIgnoreCase(firstLetterFirstName)) {
			
			System.out.println("That is an acceptable name!");
			System.out.println("Player + scored a point!\n\n");
						
		} else if (firstName2.equalsIgnoreCase("pass")) {
			
			System.out.println("Player has chosen to skip their turn");
			
		} else if (firstName1.equalsIgnoreCase("pass")) {
			
			System.out.println("Player has chosen to skip their turn");
			
		} else if (firstName2.contentEquals("exit")) {
			exitGame();
		} else if (firstName1.equalsIgnoreCase("exit")) {
			exitGame();
		}
		
		else {
			System.out.println("The name does not match up!\nNo points awarded...");
		}
		
	}
	
	public static String exitGame() {
		String choice = Console.getRequiredString(NameGameApp.getMenuOptions());
		return choice;
	}

	
	

}
