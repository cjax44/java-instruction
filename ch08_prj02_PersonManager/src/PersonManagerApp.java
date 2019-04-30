import java.awt.Choice;
import java.util.Scanner;

public class PersonManagerApp {

	public static void main(String[] args) {
		
		//welcome
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the Person Manager App");
		String choice = "y";
		
		while (choice.equalsIgnoreCase("y")) {
			//prompt + biz logic
			String s = Console.getString("Create customer or employee? (c/e): ");
			if (s.equalsIgnoreCase("c")) {
				System.out.println();
				Customer c = new Customer();
				System.out.println(c.getCustomerNumber());
				
				
			} else if (s.isEmpty()) {
				System.out.println("HAVE TO ENTER SOMETHING");
			} else if (s.equalsIgnoreCase("e")) {
				System.out.println();
				Employee e = new Employee();
				System.out.println(e.getSsn());
				
			} else {
				System.out.println("Please enter either an e or a c");
			}
			
			System.out.println("\n\nContinue? (y/n)");
			choice = sc.next();
			 			
		}
		//bye
		System.out.println("Goodbye!");
	}

}
