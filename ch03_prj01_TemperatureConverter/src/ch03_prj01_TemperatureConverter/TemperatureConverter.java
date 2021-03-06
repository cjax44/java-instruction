package ch03_prj01_TemperatureConverter;

import java.util.Scanner;
import java.math.RoundingMode;

public class TemperatureConverter {

	public static void main(String[] args) {

		// welcome

		System.out.println("Welcome to the amazing Temperature Converter!");
		System.out.println();

		// initialize variables and Scanner

		Scanner sc = new Scanner(System.in);
		String choice = "y";

		// prompt

		while (choice.equalsIgnoreCase("y")) {

			System.out.print("Enter F Degrees: ");
			double degreeF = sc.nextDouble();
			System.out.println();
			double degreeC = (double) Math.round(((degreeF - 32) * 5 / 9) * 100) / 100;
			System.out.print("Degree in C = " + degreeC);
			System.out.println();
			System.out.println("Continue? (y/n)");
			choice = sc.next();
			System.out.println();

		}

		// logic

		// display results

		// bye

	}

}
