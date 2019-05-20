import static org.junit.Assert.*;

import org.junit.Test;

public class PirateTest {
	
	Pirate p1 = new Pirate("Oreo");

	@Test
	public void createPirateTest() {
		p1 = new Pirate("Patchy");
		assertEquals("Patchy", p1.getName());
		assertEquals(4, p1.getLimbsRemaining());
	}
	
	@Test
	public void createOctoPirateTest() {
		Pirate p1 = new Pirate("OctoGary", 8);
		assertEquals("OctoGary", p1.getName());
		assertEquals(8, p1.getLimbsRemaining());
	}
	
	@Test
	public void isDeadTest() {
		Pirate p1 = new Pirate("PirateSteve");
		assertFalse(p1.isDead());
	}
	
	@Test(timeout=1000)
	public void timeoutTest() {

	}

}
