package ch04_prj01_TableOfPowers;
import java.util.Scanner;

public class TableOfPowers {

	public static void main(String[] args) {
		
		// Welcome
		System.out.println("Welcome to the powerful Table of Powers!");
		System.out.println();
		
		// Initialize scanner and global variables
		
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		
		// Pormpt For Input
		
		while (choice.equalsIgnoreCase("y")) {
		System.out.println("Enter an integer:  ");
		int userNumber = sc.nextInt();
		System.out.println();
		
		
		// Business Logic
		
		
		
		// Display Results
		System.out.println("Number \t" + "Square \t" + "Cube \t");
		System.out.println("==== \t ==== \t ====");
		for (int i = 1; i <= userNumber; i++) {
			int squareNumber = i * i;
			int cubeNumber = i * i * i;
			System.out.println(i + "\t" + squareNumber + "\t" + cubeNumber);
		}
		System.out.println();
		System.out.println("Continue (y/n)? ");
		choice = sc.next();
		
	}
		// Bye
		
		System.out.println();
		System.out.println("Goodbye!");
		sc.close();
		

	}

}
