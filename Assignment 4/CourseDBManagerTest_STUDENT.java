

import static org.junit.Assert.*;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class CourseDBManagerTest_STUDENT {
	private CourseDBManagerInterface dataMgr = new CourseDBManager();

	
	@Before
	public void setUp() throws Exception {
		dataMgr = new CourseDBManager();
	}

	
	@After
	public void tearDown() throws Exception {
		dataMgr = null;
	}

	@Test
	public void testAddToDB() {
		try {
			dataMgr.add("CMSC204",30523,4,"SC350","Saad Aulakh");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	
	
	@Test
	public void testShowAll() {
		dataMgr.add("CMSC204",30523,4,"SC350","Saad Aulakh");
		dataMgr.add("CMSC203",301303,4,"SC150","Cool guy");
		dataMgr.add("CMSC204",20159,4,"SC250","John Johnson");
		ArrayList<String> list = dataMgr.showAll();
		assertEquals(list.get(0),"\nCourse:CMSC203 CRN:301303 Credits:4 Instructor:Cool guy Room:SC150");
		assertEquals(list.get(1),"\nCourse:CMSC204 CRN:30523 Credits:4 Instructor:Saad Aulakh Room:SC350");
		assertEquals(list.get(2),"\nCourse:CMSC204 CRN:20159 Credits:4 Instructor:John Johnson Room:SC250");
	 	
		
	}
	
	/**
	 * Test for the read method
	 */
	@Test
	public void testRead() {
		try {
			File inputFile = new File("Test1.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CMSC204 30514 4 SC150 Saad Aulakh");
			inFile.print("CMSC204 30523 2 SC350 John Johnson");
			
			inFile.close();
			dataMgr.readFile(inputFile);
			assertEquals("CMSC204",dataMgr.get(30514).getID());
			assertEquals("CMSC204",dataMgr.get(30523).getID());
			assertEquals("SC350",dataMgr.get(30523).getRoomNum());
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
}
