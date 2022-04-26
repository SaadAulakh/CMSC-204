import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Road_STUDENT_Test {
	private Town source;
	private Town dest;
	private int weight;
	private String name;
	private Road r;

	@Before
	public void setUp() throws Exception {
		source = new Town("Saad's Town");
		dest = new Town("Another town");
		weight = 1;
		name = "Cool road";
		r = new Road(source, dest, weight, name);

	}

	@After
	public void tearDown() throws Exception {
		r = null;
	}

	@Test
	public void testCompareTo() {
		Road r1 = new Road(new Town(""), new Town(""), 0, "");
		assertEquals(1, r.compareTo(r1));
		Road r2 = new Road(source, dest, weight, name);
		assertEquals(0, r.compareTo(r2));
	}

	@Test
	public void testEquals() {
		Road r1 = new Road(new Town(""), new Town(""), 0, "");
		assertFalse(r.equals(r1));
		Road r2 = new Road(source, dest, weight, name);
		assertTrue(r.equals(r2));
	}

	@Test
	public void testGetName() {
		String s = "Cool road";
		assertEquals(s, r.getName());
	}
	@Test
	public void testGetWeight() {
		assertEquals(1,r.getWeight());
	}
	@Test
	public void testGetSource() {
		Town t1= new Town ("Saad's Town");
		assertTrue(t1.equals(r.getSource()));
	}
	@Test
	public void testGetDestination() {
		Town t1= new Town ("Another town");
		assertTrue(t1.equals(r.getDestination()));
	}
	
	
}

