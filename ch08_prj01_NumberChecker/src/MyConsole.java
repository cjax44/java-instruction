
public class MyConsole extends Console {

	@Override
	public String getString(String prompt) {
		
		return super.getString(prompt);
	}
	
	public String getOddOrEven(int m)	{
		double k = m % 2;
		
		if (k > 0) {
//			System.out.println("Your number is Odd");
			return "Odd";
		} else {
//			System.out.println("Your number is Even");
			return "Even";
		}
		
		
			
		
	}
	

}
