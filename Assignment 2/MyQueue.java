import java.util.ArrayList;

/**
 * This class creates a queue that can be used with any object.
 * 
 * @author Saad Aulakh
 *
 * @param <T> - This lets the queue be generic so any type of object can be used
 *            with this class.
 */
public class MyQueue<T> implements QueueInterface<T> {

	private T[] queue;
	int size;
	private static final int DEFAULT_SIZE = 20;
	public static final int MAX_SIZE = 50;

	/**
	 * Queue constructor that calls other constructor with DEFAULT_SIZE as parameter
	 */
	public MyQueue() {
		this(DEFAULT_SIZE);
	}

	/**
	 * Queue constructor with size parameter
	 * 
	 * @param capacity - size of array given by user
	 */
	@SuppressWarnings("unchecked")
	public MyQueue(int capacity) {

		if (capacity <= MAX_SIZE) {
			queue = (T[]) new Object[capacity];
			size = 0;
		} else {
			throw new IllegalStateException("Array size is above the max size");
		}

	}

	/**
	 * Adds a value in the queue at the last index
	 * 
	 * @param e - object given by user to be added into queue
	 * @throws QueueOverflowException - throws exception if queue is full
	 * @return true - return true if object is added. If exception is thrown, true
	 *         will not be returned
	 */
	public boolean enqueue(T e) throws QueueOverflowException {

		if (isFull()) {
			throw new QueueOverflowException();
		}
		queue[size] = e;
		size++;
		return true;

	}

	/**
	 * Removes first object in queue and shifts objects in array to the left.
	 * 
	 * @throws QueueUnderflowException - throws exception is queue is empty
	 * @return result - returns the first value that is getting removed
	 */
	public T dequeue() throws QueueUnderflowException {

		if (isEmpty())
			throw new QueueUnderflowException();
		T result = queue[0];
		for (int i = 0; i < queue.length; i++) {
			if (i != queue.length - 1)
				queue[i] = queue[i + 1];
		}
		size--;
		return result;

	}

	/**
	 * Puts all the values of the queue into a string
	 * 
	 * @return str - values of the queue in string form
	 */
	public String toString() {
		String str = "";
		for (int i = 0; i < size; i++) {
			str += queue[i];
		}
		return str;
	}

	/**
	 * Puts all the values of the queue into a string with the delimiter in between
	 * each value
	 * 
	 * @return str - values of the queue in string form with delimiter in between
	 *         each value
	 */
	public String toString(String delimiter) {
		String str = "";
		for (int i = 0; i < size; i++) {

			str += queue[i] + delimiter;

		}
		return str.substring(0, str.length() - 1);
	}

	/**
	 * Checks if queue is empty or not.
	 * 
	 * @return true - if queue is empty
	 * @return false - if queue has a value in it
	 */
	public boolean isEmpty() {
		return queue[0] == null;
	}

	/**
	 * Checks if queue is full or not.
	 * 
	 * @return true - if queue is full
	 * @return false - if queue has more space
	 */
	public boolean isFull() {
		return size == queue.length;
	}

	/**
	 * Gets the size of the queue
	 * 
	 * @return size - size of the queue array
	 */
	public int size() {
		return size;
	}

	/**
	 * Fills the queue with the elements of the ArrayList
	 * 
	 * @param list - ArrayList with objects which will be copied into queue
	 */
	@SuppressWarnings("unchecked")
	public void fill(ArrayList<T> list) {
		ArrayList<T> copyList = list;
		queue = (T[]) copyList.toArray();
		size = copyList.size();

	}
}