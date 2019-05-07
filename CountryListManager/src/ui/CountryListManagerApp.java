  package ui;

import java.util.List;

import util.Console;
import util.CountriesIO;
import util.Country;
import util.DAO;

public class CountryListManagerApp {
	private static DAO<Country> countryDAO = null;
	static CountriesIO cio = new CountriesIO();

	public static void main(String[] args) {
		//welcome
		System.out.println("Welcome to the Country List Manager");
		
		//create countries IO object for some reason
		countryDAO = new CountriesIO();
		CountriesIO cio = new CountriesIO();
		
		//present menu
		String menuChoice = Console.getRequiredString("COMMAND MENU\n\n"
				+ "1 - List Countries\n"
				+ "2 - Add a Country\n"
				+ "3 - Exit\n"
				+ "\n"
				+ "Enter a Menu Choice: ");
		if (menuChoice.equalsIgnoreCase("1")) {
			//print all countries
			cio.getCountries();
			displayAllCountries();
			
			
		} else if (menuChoice.equalsIgnoreCase("2")) {
			addCountry();
			
		} else if (menuChoice.equalsIgnoreCase("3")) {
			
			System.out.println("\n\nThanks for using this useless app!");
		}
		
	}
	
	public static void displayAllCountries() {
        System.out.println("COUNTRY LIST");

        List<String> countries = cio.getCountries();
       
        
        
        System.out.println(countries);
    }
	
	public static void addCountry() {
        String name = Console.getLine("Enter country name: ");

        Country country = new Country();
        country.setName(name);

        System.out.println();
        System.out.println(name + " "
                + " has been added.\n");
    }

}
