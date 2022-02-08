/**
 * Exception that is thrown if password is weak. Password is weak if it is between 6-9 characters
 * @author Saad Aulakh
 *
 */
public class WeakPasswordException extends RuntimeException {
	/**
	 * Exception constructor
	 */
	public WeakPasswordException() {
		super("The password is OK but weak - it contains fewer than 10 characters");
	}

}
