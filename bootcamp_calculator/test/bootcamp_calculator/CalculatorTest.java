package bootcamp_calculator;

import static org.junit.Assert.*;

import org.junit.*;

import util.Console;
import util.MathFunctions;

public class CalculatorTest {

	@Test
	public void additionTest() {
		int a = MathFunctions.addNumbers();
		assertEquals(14, a);
	}

}
