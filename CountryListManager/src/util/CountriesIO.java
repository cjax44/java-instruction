package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CountriesIO implements DAO<Country>{
	
// 	instance vars
	public ArrayList<String> countries = null;
    protected Path countryPath = null;
    private File countryFile = null;
    
    public CountriesIO() {
        // initialize the class variables
    	 countries = new ArrayList<String>();
    	 countryPath = Paths.get("customers.txt");
    	 countryFile = countryPath.toFile();
    	 
    }

	    
	
	public ArrayList<String> getCountries() {
		 if (countries != null) {
	        	return countries;
	        }
		 
		 if (Files.exists(countryPath)) {
	        	try (BufferedReader in = new BufferedReader(new FileReader("customers.txt"))) {
	        		
	        		String line = in.readLine();
	        		
	        		while (line != null) {
	        			String[] fields = line.split("\t");
	        			String name = fields[0];
	        			
	        			countries.add(name);
	        			line = in.readLine();
	        		
	        		}
	        		
	        		
	        	} catch (IOException e) {
					e.printStackTrace();
					return null;
				};
	        		
	            return countries;
	        }

	        countries = new ArrayList<>();

	        // load the array list with Customer objects created from
	        // the data in the file
	        return countries;
	}
	public boolean saveCountries(ArrayList<String> countries) {
		return false;
	}
	@Override
	public Country get(String code) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Country> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean add(Country t) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean update(Country t) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean delete(Country t) {
		// TODO Auto-generated method stub
		return false;
	}


}
