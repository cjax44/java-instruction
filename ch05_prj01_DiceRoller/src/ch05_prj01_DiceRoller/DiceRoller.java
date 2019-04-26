package ch05_prj01_DiceRoller;

import java.util.Scanner;

public class DiceRoller {
	
	private static String diceDisplay(int d1, int d2) {
		return ("First Die: "+d1+"\n"
				+ "Second Die: "+d2+"\n"
				+ "Total: "+(d1+d2));
	}

	public static void main(String[] args) {
				// Welcome
				System.out.println("Welcome to Dice Roller v1.2.1.9.3.3.4.0b \n");
				Scanner sc = new Scanner(System.in);
				String choice = "y";
				
				// Prompt user input
				System.out.println("Let's throw some dice! \n");
				
				
				// Business Logic
				while (choice.equalsIgnoreCase("y")) {
					int d1 = (int) ((Math.random() * 6) + 1);
					int d2 = (int) ((Math.random() * 6) + 1);
					
					System.out.println(diceDisplay(d1, d2));

					switch (d1 + d2) {
					case 12:
						System.out.println("BOXCAR!");
						break;
					case 2:
						System.out.println("SNAKE EYES!");
						break;
					default:
						break;
					}
					
					System.out.println();
					System.out.println("Re-roll? (y/n)");
					choice = sc.next();
				}
				
				// Display Results
				
				
				// Bye
				System.out.println();
				System.out.println("Goodbye!");
	}

}
