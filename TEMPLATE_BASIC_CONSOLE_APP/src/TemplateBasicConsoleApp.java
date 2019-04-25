import java.util.Scanner;

public class TemplateBasicConsoleApp {

	public static void main(String[] args) {
		
		// Welcome
		System.out.println("Welcome to ");
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		
		// Prompt user input
		
		
		// Business Logic
		while (choice.equalsIgnoreCase("y")) {
			
			
			System.out.println();
			System.out.println("Continue (y/n)?");
			choice = sc.next();
		}
		
		// Display Results
		
		
		// Bye
		System.out.println();
		System.out.println("Goodbye!");
	}

}
