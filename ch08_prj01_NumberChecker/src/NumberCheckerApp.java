import java.util.Scanner;

public class NumberCheckerApp {

	public static void main(String[] args) {

		// Welcome + Initalize Scanner
		Scanner sc = new Scanner(System.in);
		Console c = new Console();
		MyConsole r = new MyConsole();
		String choice = "y";
		int userNumber = 0;

		System.out.println("Welcome to the Odd/Even Number Checker App \n \n \n");

		// Prompt User for Input
		while (choice.equalsIgnoreCase("y")) {
			userNumber = c.getInt("Enter an integer: ");


			// biz logic
			
			System.out.println("Your number " + userNumber + " is " + r.getOddOrEven(userNumber));

			// display results - kind of lumped in with logic

			// cont?

			System.out.println("Continue (y/n)?");
			choice = sc.next();
		}

	}

}
