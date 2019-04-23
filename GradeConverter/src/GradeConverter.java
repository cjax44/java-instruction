import java.util.Scanner;

public class GradeConverter {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		// Welcome
		
		System.out.println("Welcome to the Letter Grade Converter");
		System.out.println();
		
		// Initialize Scanner and variables
		
		Scanner sc = new Scanner(System.in);
		int numberGrade = 0;
		String choice = "y";
		
		// Prompts
		
		while (choice.equalsIgnoreCase("y")) {
			
		System.out.print("Enter numerical grade: ");
		numberGrade = sc.nextInt();
		
		// Logic		
			
			if (numberGrade >= 88) {
				System.out.println("Letter Grade: A");
			} else if (numberGrade >= 80) {
				System.out.println("Letter Grade: B");
			} else if (numberGrade >= 67) {
				System.out.println("Letter Grade: C");
			} else if (numberGrade >= 60) {
				System.out.println("Letter Grade: D");
			} else {
				System.out.println("Letter Grade: F");
			}
			System.out.println();
			System.out.print("Continue? (y/n):  ");
			choice = sc.next();
		}
		sc.close();


	}

}
