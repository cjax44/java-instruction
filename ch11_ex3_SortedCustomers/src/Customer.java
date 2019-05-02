
public class Customer implements Comparable {

    private String email;
    private String firstName;
    private String lastName;

    public Customer(String email, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

	@Override
	public int compareTo(Object customer) {
		Customer c = (Customer) customer;
		int test = this.getFirstName().compareToIgnoreCase(c.getFirstName());
		
		return test;
	}
}
