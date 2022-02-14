import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradebookTester {
	GradeBook test1;
	GradeBook test2;

	@BeforeEach
	void setUp() throws Exception {
		test1 = new GradeBook(5);
		test2 = new GradeBook(5);
		test1.addScore(53.0);
		test1.addScore(87.0);
		test1.addScore(99.0);
		test2.addScore(83.0);
		test2.addScore(27.0);
	}

	@AfterEach
	void tearDown() throws Exception {
		test1 = null;
		test2 = null;
	}

	@Test
	void testAddScore() {
		assertTrue(test1.toString().equals("53.0 87.0 99.0 "));
		assertEquals(3, test1.getScoreSize());
		assertTrue(test2.toString().equals("83.0 27.0 "));
		assertEquals(2, test2.getScoreSize());
		test2.addScore(22.0);
		assertTrue(test2.toString().equals("83.0 27.0 22.0 "));
		assertEquals(3, test2.getScoreSize());
	}

	@Test
	void testSum() {
		assertEquals(239.0, test1.sum());
		assertEquals(110.0, test2.sum());
	}

	@Test
	void testMinimum() {
		assertEquals(53.0, test1.minimum());
		assertEquals(27.0, test2.minimum());
	}

	@Test
	void testFinalScore() {
		assertEquals(186.0, test1.finalScore());
		assertEquals(83.0, test2.finalScore());
	}

	@Test
	void testGetScoreSize() {
		assertEquals(3, test1.getScoreSize());
		assertEquals(2, test2.getScoreSize());
	}

	@Test
	void testToString() {
		assertTrue(test1.toString().equals("53.0 87.0 99.0 "));
		assertTrue(test2.toString().equals("83.0 27.0 "));
	}
}
