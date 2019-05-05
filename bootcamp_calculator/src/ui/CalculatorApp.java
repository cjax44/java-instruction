package ui;

import java.util.Scanner;

import util.Console;
import util.MathFunctions;

public class CalculatorApp {
	
	static Scanner sc = new Scanner(System.in);
	static String choice = "y";
	

	public static void main(String[] args) {
		
		while (choice.equalsIgnoreCase("y")) {
		String s = getMenuOption("+ for Addition\n"
				+ "- for Subtraction\n"
				+ "* for Multiplication\n"
				+ "/ for Division\n");
		
			while (s.equalsIgnoreCase("+") && choice.equalsIgnoreCase("y")) { 
			
					MathFunctions.addNumbers();
					choice = continuePrompt("Would you like to add more numbers? (y/n)");
				
			} 
			
			while (s.equalsIgnoreCase("-") && choice.equalsIgnoreCase("y"))  {
				
				MathFunctions.subNumbers();
				choice = continuePrompt("Would you like to subtract more numbers? (y/n)");
				
			} 
			
			while (s.equalsIgnoreCase("*") && choice.equalsIgnoreCase("y"))  {
				
				MathFunctions.multNumbers();
				choice = continuePrompt("Would you like to multiply more numbers? (y/n)");
				
			} 
			while (s.equalsIgnoreCase("/") && choice.equalsIgnoreCase("y"))  {
				
				MathFunctions.divNumbers();
				choice = continuePrompt("Would you like to divide more numbers? (y/n)");
				
			}
		if (choice.equalsIgnoreCase("n")) {
			
		choice = continuePrompt("Would you like to return to the menu to do more functions? (y/n)");
		continue;
			}
		}
		
		System.out.println("Thank you for using the app!");	
		
	}
	
	private static String continuePrompt(String prompt) {
		
		System.out.println(prompt);
		choice = sc.nextLine();
		return choice;
		
	}



	public static String getMenuOption(String prompt) {

		System.out.println(prompt);
		String s = sc.nextLine();

		return s;

	}

}
