import java.util.*;
import java.io.*;
import java.nio.file.*;

public final class CustomerTextFile implements DAO<Customer> {

    private List<Customer> customers = null;
    private Path customersPath = null;
    private File customersFile = null;

    private final String FIELD_SEP = "\t";

    public CustomerTextFile() {
        // initialize the class variables
    	 customers = new ArrayList<>();
    	 customersPath = Paths.get("customers.txt");
    	 customersFile = customersPath.toFile();
    	 
    }

    @Override
    public List<Customer> getAll() {
        // if the customers file has already been read, don't read it again
        if (customers != null) {
        	return customers;
        }
        
       
        
        
        if (Files.exists(customersPath)) {
        	try (BufferedReader in = new BufferedReader(new FileReader("customers.txt"))) {
        		
        		String line = in.readLine();
        		
        		while (line != null) {
        			String[] fields = line.split("\t");
        			String firstName = fields[0];
        			String lastName = fields[1];
        			String emailInput = fields[2];
        			
        			Customer c = new Customer(firstName, lastName, emailInput);
        			customers.add(c);
        			line = in.readLine();
        		
        		}
        		
        		
        	} catch (IOException e) {
				e.printStackTrace();
				return null;
			};
        		
            return customers;
        }

        customers = new ArrayList<>();

        // load the array list with Customer objects created from
        // the data in the file
        return customers;
    }

    @Override
    public Customer get(String email) {
        for (Customer c : customers) {
            if (c.getEmail().equals(email)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public boolean add(Customer c) {
        customers.add(c);
        return this.saveAll();
    }

    @Override
    public boolean delete(Customer c) {
        customers.remove(c);
        return this.saveAll();
    }

    @Override
    public boolean update(Customer newCustomer) {
        // get the old customer and remove it
        Customer oldCustomer = this.get(newCustomer.getEmail());
        int i = customers.indexOf(oldCustomer);
        customers.remove(i);

        // add the updated customer
        customers.add(i, newCustomer);

        return this.saveAll();
    }

    private boolean saveAll() {
        // save the Customer objects in the array list to the file
    	try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("customers.txt")))) {
    		for (Customer c : customers) {
    			out.print(c.getFirstName() + FIELD_SEP);
    			out.print(c.getLastName() + FIELD_SEP);
    			out.print(c.getEmail() + FIELD_SEP);
    			
    		}
    		return true;
    	}	catch (IOException e) {
			e.printStackTrace();
			return false;
		}
    }
}