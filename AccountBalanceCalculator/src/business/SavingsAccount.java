package business;
import business.Account;

public class SavingsAccount extends Account {
	
	double monthlyInterestRate;
	double monthlyInterestPayment;

	public SavingsAccount(double balance, double monthlyInterestRate) {
		super(balance);
		this.monthlyInterestRate = monthlyInterestRate;
	}
	
	public void applyMonthlyPayment() {
		
		monthlyInterestPayment = balance * monthlyInterestRate;
		balance += monthlyInterestPayment;
		
	}
	
	
	
	public double getMonthlyInterestPayment() {
		return monthlyInterestPayment;
	}

}
