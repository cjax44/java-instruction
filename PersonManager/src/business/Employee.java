package business;

public class Employee extends Person{
	
	String ssn;
	String ssnNew;

	public Employee() {
		
	}

	public Employee(String first, String last, String ssn) {
		
		this.firstName = first;
		this.lastName = last;
		this.ssn = ssn;
		
	}

	public String getSsn() {
		String[] masked = ssn.split("");
		String ssnNew = "XXX-XX-"+masked[8]+masked[9]+masked[10]+masked[11];
		
		return ssnNew;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	@Override
	public String toString() {
		return "Name: " + firstName + " " + lastName + "\nSSN: " + ssnNew;
	}

	
	

}
