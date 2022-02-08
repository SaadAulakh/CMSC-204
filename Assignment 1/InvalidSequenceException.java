/**
 * Exception that is thrown if password has more than 2 characters in a row that are the same.
 * @author Saad Aulakh
 *
 */
public class InvalidSequenceException extends RuntimeException {
	/**
	 * Exception constructor
	 */
	public InvalidSequenceException() {
		super("The password cannot contain more than two of the same character in sequence");
	}
	
}
