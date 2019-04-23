import java.util.Scanner;

public class CalculatorApp {

	public static void main(String[] args) {

		// welcome

		System.out.println("Welcome to the amazing calculator v1");

		// define 2 ints and 4 operations

		int a = 1;
		int b = 1;
		int sum = 0;
		int diff = 0;
		int product = 0;
		int quotient = 0;

		// grab inputs and store in variables

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter first integer:     ");
		a = sc.nextInt();
		System.out.print("Enter second integer:     ");
		b = sc.nextInt();
		sc.close();

		// perform operations (math)

		sum = a + b;
		diff = a - b;
		product = a * b;
		quotient = a / b;

		// display results

		System.out.print("The sum is ");
		System.out.println(sum);
		// I SHOULD HAVE DONE: System.out.println('The sum is "+sum); 
		System.out.print("The difference is ");
		System.out.println(diff);
		System.out.print("The product is ");
		System.out.println(product);
		System.out.print("The quotient is ");
		System.out.println(quotient);
	

		// bye
		System.out.println("Thanks for using the best calculator in the world!");
		
	}

}
