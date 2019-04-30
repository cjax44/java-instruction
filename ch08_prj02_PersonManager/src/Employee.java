import java.util.Scanner;

public class Employee extends Person{
	Scanner sc = new Scanner(System.in);
	String ssn;
	String ssnMasked;
	
	public Employee(String first, String last, String ssn) {
		
	}
	public Employee() {
		
	}
	public String getSsn() {
		System.out.print("First Name: ");
		String first = sc.nextLine();
		System.out.print("Last Name: ");
		String last = sc.nextLine();
		System.out.print("SSN: ");
		String ssn = sc.nextLine();
		
		ssnMasked = ssn; // FORMAT THIS TO ONLY SHOW LAST 4
				
		String result = "You entered a new employee!\nName: " + first + " " + last + "\nSSN: " + ssnMasked;
		return result;
		
	}
	public void setSsn(String ssn) {
		
		
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "\nSSN: " + ssnMasked;
	}


}
