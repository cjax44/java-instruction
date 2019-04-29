
import java.util.Scanner;

public class TipCalculator {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
			
		
		// welcome
		System.out.println("Tip Calculator \n");
		
		
		//prompt for input
		
		String choice = "y";
		
		while (choice.equalsIgnoreCase("y")) {
			
			System.out.println("Cost of meal: ");
			double mealPrice =  sc.nextDouble();
			//biz logic
			double fifteenP = (mealPrice *0.15);
			double twentyP = (mealPrice * 0.2);
			double twentyFiveP = (mealPrice / 4);
			double total15 = fifteenP + mealPrice;
			double total20 = twentyP + mealPrice;
			double total25 = twentyFiveP + mealPrice;
			
			//display results
			System.out.println();
			System.out.println("15% \n");
			System.out.println("Tip amount: " + fifteenP);
			System.out.println("Total amount: " + total15 + "\n");
			System.out.println("20% \n");
			System.out.println("Tip amount: " + twentyP);
			System.out.println("Total amount: " + total20 + "\n");
			System.out.println("25% \n");
			System.out.println("Tip amount: " + twentyFiveP);
			System.out.println("Total amount: " + total25 + "\n");
			
			System.out.println("Continue (y/n)?");
			choice = sc.next();
		}	
		
		//bye
		System.out.println("Goodbye!");
	

	}

}
