import java.util.Scanner;

public class ChangeCalculator {

	public static void main(String[] args) {
			
			// Welcome
			System.out.println("Welcome to Chris's Change Calculator");
			Scanner sc = new Scanner(System.in);
			String choice = "y";
			
			
			while (choice.equalsIgnoreCase("y")) {
				
				// Prompt user input
				System.out.println("Enter number of cents (0-99): ");
				int userNumber = sc.nextInt();
				
				
				// Business Logic	
				int numQuarters = userNumber / 25;
				int numDimes = (userNumber - (numQuarters * 25)) / 10;
				int numNickels = (userNumber - (numQuarters * 25 + numDimes * 10)) / 5;
				int numPennies = (userNumber - (numQuarters * 25 + numDimes * 10 + numNickels * 5));
				
				
			
			// Display Results
				System.out.print("Quarters: " + numQuarters + "\n");
				System.out.println("Dimes: " + numDimes + "\n");
				System.out.println("Nickels: " + numNickels + "\n");
				System.out.println("Pennies: " + numPennies + "\n");
				
				
				
				System.out.println();
				System.out.println("Continue (y/n)?");
				choice = sc.next();
			}
			
			// Bye
			sc.close();
			System.out.println();
			System.out.println("Goodbye!");
		}
	}

