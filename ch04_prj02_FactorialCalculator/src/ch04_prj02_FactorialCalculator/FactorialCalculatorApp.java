package ch04_prj02_FactorialCalculator;

import java.util.Scanner;

public class FactorialCalculatorApp {

	public static void main(String[] args) {

		// Welcome
				System.out.println("Welcome to the Factorial Calculator App");
				Scanner sc = new Scanner(System.in);
				String choice = "y";
				
				// Prompt user input
				
				// Business Logic
				while (choice.equalsIgnoreCase("y")) {
					System.out.println("Enter an integer between 0 and 10");
					int userEntry = sc.nextInt();
					long factorial = 1;
					for (long i = userEntry; i > 0; i--) {
						
						factorial *= i;
						
					}
				System.out.println("The factorial of " +userEntry+" is "+ factorial);
						
						
					
					
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

