/**
 * Class that makes elements which will go into the hashtable
 * @author Saad Aulakh
 *
 */
public class CourseDBElement implements Comparable<CourseDBElement>
{
	private String ID;
	private int CRN;
	private int credits;
	private String roomNumber;
	private String instructorName;
	public CourseDBElement()
	{
		this(null,00000,0,null,null);
	}
	public CourseDBElement(int CRN)
	{
		this.CRN=CRN;
	}
	public CourseDBElement(String ID, int CRN, int credits, String roomNumber, String instructorName)
	{
		this.ID=ID;
		this.CRN=CRN;
		this.credits=credits;
		this.roomNumber=roomNumber;
		this.instructorName=instructorName;
	}
	/**
	 * Returns CRN as a string
	 * @return crn as a string
	 */
	public String getHash() {
		return "" + CRN;
	}
	/**
	 * Returns course ID
	 * @return ID - course ID
	 */
	public String getID() {
		return ID;
	}
	/**
	 * Sets the course ID
	 * @param ID - course ID
	 */
	public void setID(String ID) {
		this.ID = ID;
	}
	/**
	 * returns the CRN of the class
	 * @return CRN - crn of the class
	 */
	public int getCRN() {
		return CRN;
	}
	/**
	 * Sets the CRN of the class
	 * @param CRN - crn of the class
	 */
	public void setCRN(int CRN) {
		this.CRN = CRN;
	}
	/**
	 * Returns the credits of the class
	 * @return credits - credits of the class
	 */
	public int getCredits() {
		return credits;
	}
	/**
	 * Sets the credits of the class
	 * @param credits - credits of the class
	 */
	public void setCredits(int credits) {
		this.credits = credits;
	}
	/**
	 * returns the room number of the class
	 * @return roomNumber - room number of the class
	 */
	public String getRoomNum() {
		return roomNumber;
	}
	/**
	 * Sets the room number of the class
	 * @param roomNumber - room number of the class
	 */
	public void setRoomNum(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	/**
	 * Returns the name of the instructor
	 * @return instructorName - name of the instructor
	 */
	public String getinstructorName() {
		return instructorName;
	}
	/**
	 * Sets the name of instructor
	 * @param instructorName - name of the instructor
	 */
	public void setinstructorName(String instructorName) {
		this.instructorName = instructorName;
	}
	@Override
	public int compareTo(CourseDBElement o) {
		return 0;
	}
	/**
	 * Puts all of the values of element into a string
	 * @return str - a string with all values of the element
	 */
	@Override
	public String toString() {
		String str = "\nCourse:" + ID + " CRN:" + CRN + " Credits:" + credits + " Instructor:" + instructorName
				+ " Room:" + roomNumber;
		return str;
	}
	
}