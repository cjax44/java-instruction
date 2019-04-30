import java.util.Scanner;
import java.text.NumberFormat;

public class AreaAndPerimeterApp {

    public static void main(String[] args) {
        System.out.println("Welcome to the Area and Perimeter Calculator");
        System.out.println();

        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
            // get input from user
                    
            // calculate total
            Rectangle r = new Rectangle();
            double length = r.getLength();
            r.setLength(length);
            double width = r.getWidth();
            double area = r.getArea(width, length);
            double perimeter = r.getPerimeter(width, length);

            
            // format and display output
            NumberFormat number = NumberFormat.getNumberInstance();
            number.setMinimumFractionDigits(3);
            String message = 
                "Area:         " + number.format(area) + "\n" +
                "Perimeter:    " + number.format(perimeter) + "\n";
            System.out.println(message);

            // see if the user wants to continue
            System.out.print("Continue? (y/n): ");
            choice = sc.nextLine();
            System.out.println();
        }
        System.out.println("Bye!");
    }  
}
