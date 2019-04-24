import java.util.Scanner;
import java.text.NumberFormat;

public class FutureValueApp {

    public static void main(String[] args) {
        System.out.println("The Future Value Calculator\n");
        
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
            // get the input from the user
            System.out.print("Enter monthly investment:   ");
            double monthlyInvestment = sc.nextDouble();
            // System.out.print("Enter yearly interest rate: ");
            // double interestRate = sc.nextDouble();
            System.out.print("Enter number of years:      ");
            int years = sc.nextInt();
            
            NumberFormat cf = NumberFormat.getCurrencyInstance();
            NumberFormat pf = NumberFormat.getPercentInstance();
            pf.setMinimumFractionDigits(1);
            
            String table = "";
            String headerRow = ("Year" + "\t");
            String row = "";
            double rate = 0.0;
            double futureValue = 0.0;
            
            
            // create header row and add to table
            for (rate = 5.0; rate < 7.0; rate += .5) {
            	headerRow += pf.format(rate/100) + "\t";
            	
            }
            
            table += headerRow + "\n";
            
            
            // loop through years
            for (int y = 1; y <= years; y++) {
            	
            	row = y + "\t";
            	
            	// loop through interest rates
            	for (rate = 5.0; rate < 7.0; rate += .5) {
            		
                    int months = y * 12;
                    double monthlyInterestRate = rate / 12 / 100;
                    
                    // calc futureValue
                    futureValue = 0.0;
                    for (int i = 1; i <= months; i++) {
                        futureValue = (futureValue + monthlyInvestment) * 
                                      (1 + monthlyInterestRate);
                        
                    }
                    // add calc to row
                    row += cf.format(futureValue) + "\t";
                    

            	}
            	// add row to table
            	
            	table += row + "\n";
            
            }
            
         // see if the user wants to continue
            System.out.println(table);
            System.out.println();
            System.out.print("Continue? (y/n): ");
            choice = sc.next();
            System.out.println();
        System.out.println("Bye!");
    }
}}