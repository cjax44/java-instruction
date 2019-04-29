package ch07_prj_03_GuessingGame;

import java.util.Scanner;

public class Game {
	
	private int theNumber;
	private int numberGuesses;

	
	public Game() {
		theNumber = getRandomNumber();
		numberGuesses = 0;
	}

	public Game(int theNumber, int numberGuesses) {
		super();
		this.theNumber = theNumber;
		this.numberGuesses = numberGuesses;
	}

	public static void displayWelcomeMessage() {
		System.out.println("Welcome to the Guess the Number Game");
		System.out.println("++++++++++++++++++++++++++++++++++++");
		System.out.println();
	}
	
	public static int getRandomNumber() {
		return (int) (Math.random() * 100) + 1;
	}
	
	public static void displayPleaseGuessMessage() {
		System.out.println("I'm thinking of a number from 1-100");
		System.out.println("Try to guess it.");
		System.out.println();
	}	
	
	public static void displayCorrectGuessMessage(int counter) {
        System.out.println("You got it in " + counter + " tries.");
        if (counter <= 3) {
            System.out.println("Great work! You are a mathematical wizard.\n");
        } else if (counter > 3 && counter <= 7) {
            System.out.println("Not too bad! You've got some potential.\n");
        } else {
            System.out.println("What took you so long? Maybe you should take some lessons.\n");
        }
    }
	
	public static int getInt(Scanner sc, String prompt) {
        int i = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                i = sc.nextInt();
                isValid = true;
            } else {
                System.out.println("Error! Invalid integer value. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return i;
    }
	
    public static void displayGuessAgainMessage(int number, int guessNumber) {
        int difference = guessNumber - number;
        if (guessNumber > number) {
            if (difference > 10) {
                System.out.println("Way too high! Guess again.\n");            
            } else {
                System.out.println("Too high! Guess again.\n");
            }
        } else {
            if (difference < -10) {
                System.out.println("Way to low! Guess again.\n");
            } else {
                System.out.println("Too low! Guess again.\n");
            }
        }
    }
	
    public static String getChoiceString(Scanner sc, String prompt,
            String s1, String s2) {
        String s = "";
        boolean isValid = false;
        while (!isValid) {
            s = getRequiredString(sc, prompt);
            if (!s.equalsIgnoreCase(s1) && !s.equalsIgnoreCase(s2)) {
                System.out.println("Error! Entry must be '" + s1 + "' or '" + s2 + "'. Try again.");
            } else {
                isValid = true;
            }
        }
        return s;
    }
	
    public static String getRequiredString(Scanner sc, String prompt) {
        String s = "";
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt);
            s = sc.nextLine();
            if (s.equals("")) {
                System.out.println("Error! This entry is required. Try again.");
            } else {
                isValid = true;
            }
        }
        return s;
    }
	
    public static int getIntWithinRange(Scanner sc, String prompt,
            int min, int max) {
        int i = 0;
        boolean isValid = false;
        while (!isValid) {
            i = getInt(sc, prompt);
            if (i <= min) {
                System.out.println("Error! Number must be greater than " + min);
            } else if (i >= max) {
                System.out.println("Error! Number must be less than " + max);
            } else {
                isValid = true;
            }
        }
        return i;
    }

	
	public void displayGuessAgainMessage() {
		
	}

	public static int incrementGuessesCounter(int numberOfGuesses) {
		return numberOfGuesses ++;
		
	}

}
