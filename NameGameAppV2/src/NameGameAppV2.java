

public class NameGameAppV2 {

	public static void main(String[] args) {

		//welcome
				System.out.println("Welcome to the NameGameApp v 2.0\n");
				//menu on launch
				String menuChoice = "";				
				menuChoice = Console.getRequiredString(getMenuOptions());
				
				//as long as they don't exit - start the game
				while (!menuChoice.equalsIgnoreCase("x")) {
					
					//get number of players
					int numPlayers = Console.getInt("How many players?\n");
					
					//declare array to store player objects
					Player[] playerArr = new Player[numPlayers];
					
					//loop to create # of player objects
					for (int i = 0; i < numPlayers; i++) {
						playerArr[i] = new Player(i);
						playerArr[i].setPlayerScore(0);
						System.out.println("Player " + (i + 1) + " created.");
					}
					
					String continueChoice = "y";
					
					//initialize game by getting first entry to start game and setting player to 1 (player#2)
					String nameEntry1 = Game.startGame();
					int currentPlayer = 1;
					//begin looping to check entry2 vs entry1 - then replace entry1 var 
					//with entry 2 value to make loop continue to apply
					while (continueChoice.equalsIgnoreCase("y")) {
					for (currentPlayer = 0; currentPlayer < numPlayers; currentPlayer++) {
						int score = 0;
						String nameEntry2 = Console.getRequiredString("Next player please enter a first and last name: ");
						System.out.println("\nThe name chosen was " + nameEntry2 + "\n");
						//break strings out to compare to each other
						String[] brokenOut1 = nameEntry1.split(" ");
						String[] brokenOut2 = nameEntry2.split(" ");
						//use game class to compare strings
						Game.compareNames(playerArr, numPlayers, brokenOut1[0], brokenOut1[1], brokenOut2[0], brokenOut2[1]);
						// add score to current player
						playerArr[currentPlayer].setPlayerScore(score + 1);
						//put newest name as nameEntry1 variable so next loop through uses that to compare
						nameEntry1 = nameEntry2;
						if (currentPlayer == (numPlayers-1)) {
							currentPlayer = -1;
						}

					}
					printStats(playerArr, numPlayers);
					
					}  continueChoice = "n";
					
					menuChoice = Game.exitGame(playerArr, numPlayers);
					
					
					
					} // continueChoice = Console.getChoiceString("Continue?", "y", "n");
					
				// x was chosen at menu - say goodbye
				System.out.println("\nThanks for playing!");
				}
	
			public static void printStats(Player[] playerArr, int numPlayers) {
				
				for (int playerNum = 0; playerNum < numPlayers; playerNum++) {
					System.out.println(playerArr[playerNum].getPlayerScore());
				}
				
			}
				


			public static String getMenuOptions() {
				String s = "Menu Options\n" + "S - Start a new game\n" + "X - Exit\n";
				return s;
			}
			
			

}
