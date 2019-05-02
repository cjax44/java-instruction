import java.text.NumberFormat;

public class MonthSelectorApp {

    public static void main(String[] args) {
        System.out.println("Monthly Sales\n");
        
        // declare monthNames and monthSales arrays
        String[] monthName = new String[12];
        monthName[0] = "January";
        monthName[1] = "February";
        monthName[2] = "March";
        monthName[3] = "April";
        monthName[4] = "May";
        monthName[5] = "June";
        monthName[6] = "July";
        monthName[7] = "August";
        monthName[8] = "September";
        monthName[9] = "October";
        monthName[10] = "November";
        monthName[11] = "December";
        
        
        double[] monthSales = new double[12];
        monthSales[0] = 241000;
        monthSales[1] = 222000;
        monthSales[2] = 244550;
        monthSales[3] = 243211;
        monthSales[4] = 290000;
        monthSales[5] = 211000;
        monthSales[6] = 101000;
        monthSales[7] = 191000;
        monthSales[8] = 277000;
        monthSales[9] = 241840;
        monthSales[10] = 241300;
        monthSales[11] = 241910;
        
        double total = 0;

        // get currency formatting
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        
        // get one or more months
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
            // get the input from the user
            int monthNumber = Console.getInt("Enter month number: ");
            
            // validate input
            if (monthNumber < 1 || monthNumber > monthName.length) {
                Console.displayLine("Invalid month number. Try again.");
                continue;                
            }
            
            // get the index number for the month
            System.out.println("\nSales for "+monthName[monthNumber-1]+ ": " + currency.format(monthSales[monthNumber-1]));
            
            // and display the month name and sales     


            // check if the user wants to continue
            choice = Console.getString("\nContinue? (y/n): ");
            Console.displayLine();
        }
        
        // display the total sales for the year
        for (int i = 0; i < monthSales.length; i++) {
        	total += monthSales[i];        	
        }
        System.out.println("Total sales: "+currency.format(total));
        
        Console.displayLine();
    }    

}
