
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class CourseDBStructureTest_STUDENT {
	CourseDBStructure cds, testStructure;

	@Before
	public void setUp() throws Exception {
		cds = new CourseDBStructure(20);
		testStructure = new CourseDBStructure("Saad", 20);
	}

	@After
	public void tearDown() throws Exception {
		cds = testStructure = null;
	}

	@Test
	public void testGetTableSize() {
		assertEquals(19, cds.getTableSize());
		assertEquals(20, testStructure.getTableSize());
	}

	@Test
	public void testHashTable() {

		
		CourseDBElement cde1 = new CourseDBElement("CMSC100", 39919, 2, "SC200", "Saad Aulakh");
		
		cds.add(cde1);  
		cds.add(cde1);  
	 
		ArrayList<String> courseList = cds.showAll(); 
		assertTrue(courseList.size()==1);  
		
		CourseDBElement cde2 = new CourseDBElement("CMSC420", 43300, 3, "SC100", "Who IsThis");
	 
 		try {
			assertEquals(39919, cds.get(cde1.getCRN()).getCRN());  
			cds.get(cde2.getCRN()).getCRN();
		} catch (IOException e) {

			assertTrue("threw Exception successfuly for the course not found", true);
		}
		
 		cds.add(cde2);
 		courseList = cds.showAll(); 
		assertTrue(courseList.size()==2);  
		
		try {
			assertEquals(43300, cds.get(cde2.getCRN()).getCRN());
		} catch (IOException e) {
			 
			fail("Should not throw exception");
		}  
		CourseDBElement cde1Update = new CourseDBElement("CMSC100-updated", 39919, 4, "SC200", "updated");
		cds.add(cde1Update);  //Same CRN updated information
 		courseList = cds.showAll(); 
		assertTrue(courseList.size()==2);  
		
		try {
			assertEquals(39919, cds.get(cde1Update.getCRN()).getCRN());
			assertEquals("CMSC100-updated", cds.get(cde1Update.getCRN()).getID());
		} catch (IOException e) {
			 
			fail("Should not throw exception");
		}  
		testStructure.add(cde1); 
		courseList = testStructure.showAll(); 
		assertTrue(courseList.size()==1); 
	}
}
