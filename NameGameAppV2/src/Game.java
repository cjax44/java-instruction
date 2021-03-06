
public class Game {

	public static String exitGame(Player[] playerArr, int numPlayers) {
		
		NameGameAppV2.printStats(playerArr, numPlayers);
		System.out.println("Thanks for playing!\n\n");
		String choice = Console.getRequiredString(NameGameAppV2.getMenuOptions());
		return choice;
		
	}
	
	public static String exitGame() {
		
		System.out.println("Thanks for playing!");
		String choice = Console.getRequiredString(NameGameAppV2.getMenuOptions());
		return choice;
	}
	
	public static String startGame() {
		System.out.println("\n\nPlayer 1 starts.\n");
		String nameEntry1 = Console.getRequiredString("Please enter a first and last name: ");
		System.out.println("\nThe name chosen was " + nameEntry1 + "\n");
		return nameEntry1;
	}
	
	public static boolean compareNames(Player[] playerArr, int numPlayers, String firstName1, String lastName1, String firstName2, String lastName2) {
		String firstLetterFirstName = firstName2.substring(0,1);
		String firstLetterLastName = lastName1.substring(0, 1);
		
		if (firstName2.equalsIgnoreCase("exit")) {
			
			exitGame(playerArr, numPlayers);
			return false;
			
		} else if (firstName1.equalsIgnoreCase("exit")) {
			
			exitGame(playerArr, numPlayers);
			return false;
			
		} else if (firstLetterLastName.equalsIgnoreCase(firstLetterFirstName)) {
			
			System.out.println("That is an acceptable name!");
			return true;
						
		} else if (firstName1.equalsIgnoreCase("pass")) {
			
			System.out.println("Player has chosen to skip their turn. No points awarded.");
			return false;
		} else if (firstName2.equalsIgnoreCase("pass")) {
			
			System.out.println("Player has chosen to skip their turn. No points awarded.");
			return false;
		}  
		
		else {
			System.out.println("The name does not match up!\nNo points awarded...");
			return false;
		}
		
	}

}
