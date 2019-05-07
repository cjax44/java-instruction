package sandbox;

public class Sandbox {

	public static void main(String[] args) {
		
		String s1 = "118-45-9271";
		String s2 = "";
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != '-') {
				s2 += s1.charAt(i);
			}
		}
		s2 = s2.replace('-', '.');
		System.out.println(s2);
	}
}
