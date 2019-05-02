import java.util.Arrays;

public class SortedCustomersApp {

    public static void main(String[] args) {
    	
    
    	Customer c1 = new Customer("johndoe@gmail.com", "John", "Doe");
    	Customer c2 = new Customer("stevemartin@aol.com", "Steve", "Martin");
    	Customer c3 = new Customer("dwaynejohnson@yahoo.com", "Dwayne", "Johnson");
    	
    	Customer[] custArray = {c1, c2, c3};
    	
    	Arrays.sort(custArray);
    	
    	for (Customer cust: custArray) {
    		System.out.println(cust.getEmail() + " " + cust.getFirstName() + " " + cust.getLastName());
    	}
    	
    }


}
