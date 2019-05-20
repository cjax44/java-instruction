import static org.junit.Assert.*;

import org.junit.*;

public class BeforeAndAfterTest {

	@Test
	public void test1() {
		System.out.println("Test1 called");
	}
	
	@Test
	public void test2() {
		System.out.println("Test2 called");
	}
	
	@Test
	public void test3() {
		System.out.println("Test3 called");
	}
	
	@Before
	public void before() {
		System.out.println("Before called");
	}
	
	@After
	public void after() {
		System.out.println("after called");
	}
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("bc called");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("ac called");
	}

}
