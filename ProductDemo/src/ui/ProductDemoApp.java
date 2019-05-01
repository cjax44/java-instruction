package ui;

import business.Book;

public class ProductDemoApp {

	public static void main(String[] args) {
		
//		// welcome
//		
//		System.out.println("Hello");
//		
//		Product product1 = new Product("java", "Murach's Java Programming", 57.50);
//		Product product2 = new Product("mysql", "Murach's MySQL", 54.50);
//		
//		// goodbye
//		
//		System.out.println(product1.getCode()+ " " + product1.getDescription() + " " + product1.getPrice());
//		System.out.println(product2.toString());
		
		Book chrisBook = new Book("java", "Murach's Java Programming", 57.50, "Joel Murach");
		System.out.println(chrisBook);
		System.out.println("Bye");

	}  

}
   