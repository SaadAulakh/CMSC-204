import java.util.ArrayList;

/**
 * Class that has methods for stack which will be used to convert infix to
 * postfix and vice versa
 * 
 * @author Saad Aulakh
 *
 * @param <T> This lets the queue be generic so any type of object can be used
 *            with this class.
 */
public class MyStack<T> implements StackInterface<T> {

	private T[] stack;
	int size;
	private static final int DEFAULT_SIZE = 20;
	public static final int MAX_SIZE = 50;

	public MyStack() {
		this(DEFAULT_SIZE);
	}

	@SuppressWarnings("unchecked")
	public MyStack(int capacity) {

		if (capacity <= MAX_SIZE) {
			stack = (T[]) new Object[capacity];
			size = 0;
		} else {
			throw new IllegalStateException("Array size is above the max size");
		}

	}

	/**
	 * Checks if queue is empty or not.
	 * 
	 * @return true - if stack is empty
	 * @return false - if stack has a value in it
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Checks if queue is full or not.
	 * 
	 * @return true - if stack is full
	 * @return false - if stack has more space
	 */
	public boolean isFull() {
		return size == stack.length;
	}

	/**
	 * Removes last object in stack and returns it.
	 * 
	 * @throws StackUnderflowException - throws exception is stack is empty
	 * @return result - returns the last value that is getting removed
	 */
	public T pop() throws StackUnderflowException {
		if (isEmpty())
			throw new StackUnderflowException();
		T result = stack[size - 1];
		stack[size--] = null;
		return result;
	}

	/**
	 * Shows the top value
	 * 
	 * @return last value in the stack
	 */
	public T top() throws StackUnderflowException {
		if (isEmpty())
			throw new StackUnderflowException();
		return stack[size - 1];
	}

	/**
	 * Gets the size of the stack
	 * 
	 * @return size - size of the stack array
	 */
	public int size() {
		return size;
	}

	/**
	 * Adds a value in the stack at the last index
	 * 
	 * @param e - object given by user to be added into queue
	 * @throws StackOverflowException - throws exception if stack is full
	 * @return true - return true if object is added. If exception is thrown, true
	 *         will not be returned
	 */
	public boolean push(T e) throws StackOverflowException {
		if (isFull())
			throw new StackOverflowException();
		stack[size++] = e;
		return true;
	}

	/**
	 * Puts all the values of the stack into a string
	 * 
	 * @return str - values of the stack in string form
	 */
	public String toString() {
		String str = "";
		for (int i = 0; i < size; i++) {
			str += stack[i];
		}
		return str;
	}

	/**
	 * Puts all the values of the stack into a string with the delimiter in between
	 * each value
	 * 
	 * @return str - values of the stack in string form with delimiter in between
	 *         each value
	 */
	public String toString(String delimiter) {
		String str = "";
		for (int i = 0; i < size; i++) {

			str += stack[i] + delimiter;

		}
		return str.substring(0, str.length() - 1);
	}

	/**
	 * Fills the stack with the elements of the ArrayList
	 * 
	 * @param list - ArrayList with objects which will be copied into stack
	 */
	@SuppressWarnings("unchecked")
	public void fill(ArrayList<T> list) {
		ArrayList<T> copyList = list;
		for (int i = 0; i < copyList.size(); i++) {
			stack[i] = copyList.get(i);
		}
		size = copyList.size();

	}

}