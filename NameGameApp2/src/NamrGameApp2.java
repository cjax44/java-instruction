import util.Console;

public class NamrGameApp2 {

	public static void main(String[] args) {
		//welcome
		System.out.println("Welcome to the NameGameApp v 2.0");
		//menu for starting a game
		String menuChoice = "";
		
		menuChoice = Console.getRequiredString(getMenuOptions());
		
	}

	private static String getMenuOptions() {
		String s = "Menu Options\n" + "S - Start a new game\n" + "X - Exit\n";
		return s;
	}

}
