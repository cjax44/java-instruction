package ui;

import business.Customer;
import business.Employee;
import util.Console;

public class PersonManagerApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Person Manager");
		String cont = "y";
		
		String choice = Console.getChoiceString("Create customer or employee?", "c", "e");
		
		while (cont.equalsIgnoreCase("y")) {
				if (choice.equalsIgnoreCase("c")) {
					String first = Console.getRequiredString("\nFirst name: ");
					String last = Console.getRequiredString("Last name: ");
					String custNum = Console.getRequiredString("Customer number: ");
					
					Customer c = new Customer(first, last, custNum);
					
					System.out.println("\n\nYou entered a new Customer:");
					System.out.println(c.toString() + "\n");
					
					cont = Console.getChoiceString("\nContinue? (y/n)", "y", "n");
					
				} else {
					
					String first = Console.getRequiredString("\nFirst name: ");
					String last = Console.getRequiredString("Last name: ");
					String ssn = Console.getRequiredString("SSN: ");
					
					Employee e = new Employee(first, last, ssn);
					
					System.out.println("You entered a new Employee: ");
					System.out.println(e.toString());
					
					cont = Console.getChoiceString("\nContinue? (y/n)", "y", "n");
				}
		}
		
		System.out.println("\nThank you for using the Person Manager App!");

	}

}
