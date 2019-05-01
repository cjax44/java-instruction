package business;

import util.Countable;

public class AnimalCounterApp {

	public static void main(String[] args) {
		System.out.println("Counting alligators...\n");
		Alligator a = new Alligator();
		count(a, 3);
		
		System.out.println("\nCounting sheep...\n");
		Sheep s = new Sheep();
		count(s, 2);
		System.out.println();
		
		
		
		}
		
		
	public static void count(Countable c, int maxCount) {
		
		for (int i = 1; i <= maxCount; i++) {
			c.incrementCount();
			System.out.println(c.getCountString());
		}

	}

}
