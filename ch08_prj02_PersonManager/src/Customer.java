import java.util.Scanner;

public class Customer extends Person{
	Scanner sc = new Scanner(System.in);
	String cnumber;
	
	public Customer(String first, String last, String number) {
		
	}
	
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}


	public String getCustomerNumber() {
		System.out.print("First Name: ");
		String first = sc.nextLine();
		System.out.print("Last Name: ");
		String last = sc.nextLine();
		System.out.print("Customer Number: ");
		String cnumber = sc.nextLine();
		String result = "\nYou entered a new customer!\nName: " + first + " " + last + "\nCustomer Number: " + cnumber;
		
		return result;
		
	}
	public void setCustomerNumber(String number) {
		
	}


	@Override
	public String toString() {
		
		return super.toString() + "\nCustomer Number: " + cnumber;
	}


}
