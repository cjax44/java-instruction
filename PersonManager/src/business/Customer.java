package business;

public class Customer extends Person{
	
	String customerNumber;

	
	
	public Customer() {
		super();
	}
	
	public Customer(String first, String last, String customerNumber) {
		this.firstName = first;
		this.lastName = last;
		this.customerNumber = customerNumber;
	}

	public Customer(String customerNumber) {
		super();
		this.customerNumber = customerNumber;
	}



	public String getCustomerNumber() {
		return customerNumber;
	}



	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}



	@Override
	public String toString() {
		return "Name: " + firstName + " " + lastName + "\nCustomer Number: " + customerNumber;
	}
	
	
	
	
	
	

}
