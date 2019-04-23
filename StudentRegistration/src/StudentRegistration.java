import java.util.Scanner;

public class StudentRegistration {

	public static void main(String[] args) {
		// Welcome message
		System.out.println("Student Registration Form");
		// Initialize Scanner and variables
		int birthYear = 0;
		String lastName = "";
		String firstName = "";
		Scanner sc = new Scanner(System.in);
		// Prompt for name and birth year
		System.out.print("Enter first name:  ");
		firstName = sc.next();
		System.out.print("Enter last name:  ");
		lastName = sc.next();
		System.out.print("Enter year of birth:  ");
		birthYear = sc.nextInt();
		sc.close();
		System.out.println();
		// RESULTS
		System.out.println("Welcome " + firstName + " " + lastName + "!");
		System.out.println("Your registration is complete.");
		System.out.println("Your temporary password is: " + firstName + "*" + birthYear);
		

	}

}
