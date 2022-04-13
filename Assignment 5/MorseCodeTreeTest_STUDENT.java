import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MorseCodeTreeTest_STUDENT {

	MorseCodeTree tree;

	@Before
	public void setUp() throws Exception {
		tree = new MorseCodeTree();
	}

	@After
	public void tearDown() throws Exception {
		tree = null;
	}

	@Test
	public void fetchTest() {
		String s = tree.fetch("..");
		assertEquals(s, "i");

		s = tree.fetch("...-");
		assertEquals(s, "v");
	}

	@Test
	public void toArrayListTest() {
		ArrayList<String> a = tree.toArrayList();
		assertEquals(a.get(0), "h");
		assertEquals(a.get(10), "p");
		assertEquals(a.get(20), "y");
		assertEquals(a.get(13), "");
	}

	@Test
	public void exceptionTest() {
		try {
			tree.update();
		}
		catch(UnsupportedOperationException e)
		{
			assertTrue("An exception was thrown", true);
		}
		
		try {
			tree.delete("");
		}
		catch(UnsupportedOperationException e)
		{
			assertTrue("An exception was thrown", true);
		}
	}
}
