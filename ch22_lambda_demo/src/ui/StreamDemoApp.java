package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import business.Contact;

public class StreamDemoApp {

	public static void main(String[] args) {

		List<Contact> contacts = new ArrayList<>();
		
		System.out.println("Hello");
		
		contacts.add(new Contact("Mike Murach", null, "800-221-5528"));
		contacts.add(new Contact("Anne Boehm", null, null));
		contacts.add(new Contact("Joel Murach", "joel@murach.com", null));
		
		// filter using Predicate interface p717
		contacts.stream().filter(c -> c.getPhone() == null).forEach(c -> System.out.println(c.getName())); 
		
		// filter and collect p717
		List<Contact> contactsNoPhone = contacts.stream().filter(c -> c.getPhone()==null)
				.collect(Collectors.toList());
		
		System.out.println("There are " + contactsNoPhone.size() + " contacts w/o phone");
		
		// transform a list using map method - p719
		List<String> contactNames = contacts.stream().map(Contact::getName).collect(Collectors.toList());
		
		contactNames.stream().forEach(System.out::println);
		
		
		// map and reduce p721
		String csv = contacts.stream().map(c -> c.getName()).reduce("", (a, b) -> a + b + ", ");
		
		csv = csv.substring(0, csv.length()-2);
		System.out.println("All contacts: " + csv);
		
		System.out.println("Bye");
		}

}
