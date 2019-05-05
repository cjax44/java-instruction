package ui;

import util.Console;
import util.Game;
import util.Player;

public class NameGameApp {

	public static void main(String[] args) {
		// welcome & get number of players

		System.out.println("Welcome to the Name Game! Type Pass Turn to pass on your turn.\n\n");

		String menuChoice = "";
		

		// while loop for the game


		while (!menuChoice.equalsIgnoreCase("x")) {
			menuChoice = Console.getRequiredString(getMenuOptions());
			// create player objects
			int n = Console.getInt("How many players will be playing? \n");
			Player[] playerArr = new Player[n];
			for (int i = 0; i < n; i++) {
				playerArr[i] = new Player(i);
				playerArr[i].setPlayerScore(0);
				System.out.println("Player " + (i + 1) + " created.");
			}
			
			System.out.println();
			String cont = "y";
			System.out.println("\n\nPlayer 1 starts.\n");
			String nameEntry1 = Console.getRequiredString("Please enter a first and last name: ");
			System.out.println("\nThe name chosen was " + nameEntry1 + "\n");
			int currentPlayer = 1;
			// collect user entries
			if (menuChoice.equalsIgnoreCase("S") && cont.equalsIgnoreCase("y")) {

				for (currentPlayer = 1; currentPlayer < (n + 1); currentPlayer++) {
					int score = 0;

					// get name
//				String nameEntry1 = Console.getRequiredString("Please enter a first and last name: ");
//				System.out.println("\nThe name chosen was " + nameEntry1 + "\n");
					String nameEntry2 = Console.getRequiredString("Next player please enter a first and last name: ");
					System.out.println("\nThe name chosen was " + nameEntry2 + "\n");
					// compare to each other
					String[] brokenOut1 = nameEntry1.split(" ");
					String[] brokenOut2 = nameEntry2.split(" ");

					Game.compareNames(brokenOut1[0], brokenOut1[1], brokenOut2[0], brokenOut2[1]);

					// Player[i].setPlayerScore(score+=1);

					playerArr[currentPlayer].setPlayerScore(score + 1);

					nameEntry1 = nameEntry2;

					if (currentPlayer == (n - 1)) {
						currentPlayer = 0;
						break;
					}

				}

				cont = Console.getRequiredString("Continue? (y/n)");
			} else {
				// bye
				for (int playerNum = 0; playerNum < n; playerNum++) {
					System.out.println(playerArr[playerNum].getPlayerScore());
				}
				System.out.println("\n\nThanks for playing!");
				break;

			}
			// count score of successful names

			// display results or scores

			// cont?

		}
	}

	private static void printScoreResults(Object[] playerArr) {

		for (int i = 0; i < playerArr.length; i++) {
			// String playerTot;
			// System.out.println(playerArr[i]);
		}
	}

	public static String getMenuOptions() {

		String s = "Menu Options\n" + "S - Start a new game\n" + "X - Exit\n";

		return s;

	}

}
