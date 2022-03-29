import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Used to create a hash table that has CDE's in it.
 * @author Saad Aulakh
 *
 */
public class CourseDBStructure implements CourseDBStructureInterface {

	protected int tableSize;
	protected ArrayList<LinkedList<CourseDBElement>> hashTable;
	private final double loadFactor = 1.5;

	public CourseDBStructure(int num) {
		int d = (int) (num / loadFactor);
		for (int k = 0; k < d; k++) {
			if ((4 * k + 3) > d) {
				if (isPrime(4 * k + 3)) {
					int size = 4 * k + 3;
					tableSize = size;
					break;
				}
			}
		}

		hashTable = new ArrayList<LinkedList<CourseDBElement>>(tableSize);
		for (int i = 0; i < tableSize; i++) {
			hashTable.add(new LinkedList<CourseDBElement>());
		}
	}

	public CourseDBStructure(String s, int n) {
		tableSize = n;
		hashTable = new ArrayList<LinkedList<CourseDBElement>>(tableSize);
		for (int i = 0; i < tableSize; i++) {
			hashTable.add(new LinkedList<CourseDBElement>());
		}
	}

	/** 
	* Adds a CourseDBElement object to the CourseDBStructure using the hashcode
	* of the CourseDatabaseElemen object's crn value.
	* If the CourseDatabaseElement already exists, exit quietly
	*  
	* @param element the CourseDBElement to be added to CourseDBStructure
	*/
	@Override
	public void add(CourseDBElement element) {
		int index = Integer.parseInt(element.getHash()) % tableSize;

		if (!(hashTable.get(index).contains(element))) {
			hashTable.get(index).add(element);
		}

		for (int i = 0; i < hashTable.get(index).size(); i++) {
			if (!((CourseDBElement) hashTable.get(index).get(i)).getID().equals(element.getID())) {
				if (((CourseDBElement) hashTable.get(index).get(i)).getCRN() == element.getCRN()) {
					hashTable.get(index).remove(i);
					hashTable.get(index).add(element);
				}
			}
		}

	}

	/**
	 * Find a courseDatabaseElement based on the crn of the
	 * courseDatabaseElement If the CourseDatabaseElement is found return it If not,
	 * throw an IOException
	 * 
	 * @param crn - crn (key) whose associated courseDatabaseElement is to be returned
	 * @return a CourseDBElement whose crn is mapped to the key
	 * @throws IOException if key is not found
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException {
		int index = crn % tableSize;
		if (!(hashTable.get(index).isEmpty())) {
			for (int i = 0; i < hashTable.get(index).size(); i++) {
				if (((CourseDBElement) hashTable.get(index).get(i)).getCRN() == crn)
					return ((CourseDBElement) hashTable.get(index).get(i));
			}
		}
		throw new IOException();

	}

	/**
	 * Method that shows all of the elements in the hash table
	 * 
	 * @return all - an ArrayList of all the elements in the hash table
	 */
	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> all = new ArrayList<String>(tableSize);

		for (int i = 0; i < tableSize; i++) {
			if (!(hashTable.get(i).isEmpty())) {
				all.add(hashTable.get(i).toString().replace("[", "").replace("]", ""));
			}
		}
		return all;
	}

	/**
	 * Method that returns the size of the table
	 * 
	 * @return tableSize
	 */
	@Override
	public int getTableSize() {
		// TODO Auto-generated method stub
		return tableSize;
	}

	/**
	 * A method that checks if a number is prime or not
	 * 
	 * @param num - number that is being checked to see if it is prime or not
	 * @return prime - a boolean that is false if num is not prime, true if it is
	 *         prime
	 */
	private static boolean isPrime(int num) {
		boolean prime = false;
		if (num <= 1) {
			return prime;
		}
		// start at 2 because num % 1 will always be true
		// increment until sqrt(num) because the highest factor in any number is the
		// sqrt of it
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return prime;
			}
		}
		prime = true;
		return prime;

	}

}