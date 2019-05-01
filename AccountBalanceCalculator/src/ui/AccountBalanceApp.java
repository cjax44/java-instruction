package ui;

import java.text.NumberFormat;
import java.util.Scanner;

import business.Account;
import business.CheckingAccount;
import business.SavingsAccount;

public class AccountBalanceApp {

	public static void main(String[] args) {
		//welcome + initializes
		System.out.println("Welcome to the Account Balance App");
		Scanner sc = new Scanner(System.in);
		
			//create the 2 accounts
		SavingsAccount sa = new SavingsAccount(1000, .01);
		CheckingAccount ca = new CheckingAccount(1000, 1);
		
			//define currency formatting
		NumberFormat cf = NumberFormat.getCurrencyInstance();
		
			//print starting balances using method (per specs in prj)
		System.out.println("Starting Balances:");		
		printBalances(sa, ca, cf);
		
		System.out.println("\nEnter transactions for the month:");
		
		String choice = "y";
		
		while (choice.equalsIgnoreCase("y")) {
			
			String transType = Console.getChoiceString(sc, "Withdrawal or deposit? (w/d)", "w", "d");
			String acctType = Console.getChoiceString(sc, "Checking or savings? (c/s)", "c", "s");
			double amt = Console.getDouble(sc, "Amount?", 0, Double.POSITIVE_INFINITY);
			
			Account a;
			if (acctType.equalsIgnoreCase("c")) {
				a = ca;
			} else {
				a = sa;
			}
			
			if (transType.equalsIgnoreCase("w")) {
				a.withdraw(amt);
			} else {
				a.deposit(amt);
			}
			
			choice = Console.getChoiceString(sc, "Continue?", "y", "n");
		}
		// calculate fees and apply sa interest payment
		ca.subtractMonthlyFee();
		sa.applyMonthlyPayment();
		
		System.out.println("\nMonthly payments and fees\n");
		System.out.println("Checking Fee:   " + cf.format(ca.getMonthlyfee()));
		System.out.println("Savings Interest Payment:   " + cf.format(sa.getMonthlyInterestPayment()));
		
		
		System.out.println("\nFinal Balances:\n");
		
		printBalances(sa, ca, cf);
				
		
		//bye
		System.out.println("Goodbye!");

	}

	private static void printBalances(SavingsAccount sa, CheckingAccount ca, NumberFormat cf) {
		System.out.println("Checking:  " + cf.format(ca.getBalance()));
		System.out.println("Savings:   " + cf.format(sa.getBalance()));
	}
	
	

}
