import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Scanner;

public class InterestCalculatorApp {

	public static void main(String[] args) {
		// Welcome
		
		System.out.println("Welcome to the Interest Calculator App");
		
		// Declare Variables and Initialize Scanner
		
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		
		// Prompt for input
		
		while (choice.equalsIgnoreCase("y")) {
			System.out.println("Enter loan amount: ");
			// double loanAmt = sc.nextDouble(); OLD ATTEMPT
			String loanAmtStr = sc.next();
			BigDecimal loanAmt = new BigDecimal(loanAmtStr);
			
			System.out.println("Enter interest rate: ");
			// double intRate = sc.nextDouble(); OLD ATTEMPT
			String intRateStr = sc.next();
			BigDecimal intRate = new BigDecimal(intRateStr);
			
			
		// Logic
			
			BigDecimal intAmt = loanAmt.multiply(intRate);
			
			NumberFormat cf = NumberFormat.getCurrencyInstance();
			cf.setRoundingMode(RoundingMode.HALF_UP);
			NumberFormat pf = NumberFormat.getPercentInstance();
			pf.setMaximumFractionDigits(3);
			
		// Display Results	
			
			System.out.println("Loan Amount:      " + cf.format(loanAmt));
			System.out.println("Interest rate:     " + pf.format(intRate));
			System.out.println("Interest:      " + cf.format(intAmt));
			
			
			
			
			
			System.out.println();
			System.out.println("Continue? (y/n)");
			choice = sc.next();
			
		}
		
		
		
		
		
		
		
		// Bye
		
		System.out.println();
		System.out.println("Bye");
		

	}

}
