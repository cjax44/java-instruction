package business;
import business.Account;

public class CheckingAccount extends Account {
	
	
	private double monthlyFee = 1;
	
	public CheckingAccount(double balance, double monthlyFee) {
		super(balance);
	}
	
	public double getMonthlyfee() {
		return monthlyFee;
	}
	
	public void subtractMonthlyFee() {
		balance -= monthlyFee;
	}

}
