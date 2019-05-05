package util;

public class Math {



public static int addNumbers() {
	int a = 0;
	a += Console.getInt("Enter a number: ");
	a += Console.getInt("Enter second number: ");
	System.out.println("The result is: " + a);
	return a;
	
}

public static int subNumbers() {
	int a = 0;
	a = Console.getInt("Enter first number: ");
	a -= Console.getInt("Enter second number: ");
	System.out.println("The result is: " + a);
	return a;
}

public static int divNumbers() {
	int a = 0;
	a = Console.getInt("Enter first number: ");
	a /= Console.getInt("Enter second number: ");
	System.out.println("The result is: " + a);
	return a;
}

public static int multNumbers() {
	int a = 0;
	a = Console.getInt("Enter first number: ");
	a *= Console.getInt("Enter second number: ");
	System.out.println("The result is: " + a);
	return a;
}

}
