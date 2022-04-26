import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Town_STUDENT_Test {
	private Town town;

	@Before
	public void setUp() throws Exception {
		town = new Town("Saad's Town");
		

	}

	@After
	public void tearDown() throws Exception {
		town = null;
	}

	@Test
	public void testCompareTo() {
		Town town1 = new Town("Not the same");
		assertEquals(1, town.compareTo(town1));
		Town town2 = new Town("Saad's Town");
		assertEquals(0, town.compareTo(town2));
	}
	@Test
	public void testEquals() {
		Town town1 = new Town("Not the same");
		assertFalse(town.equals(town1));
		Town town2 = new Town("Saad's Town");
		assertTrue(town.equals(town2));
	}
	@Test
	public void testGetName() {
		String s = "Saad's Town";
		assertEquals(s, town.getName());
	}
}
