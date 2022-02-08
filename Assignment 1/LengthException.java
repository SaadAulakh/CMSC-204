/**
 * Exception that is thrown if password has less than 6 characters
 * @author Saad Aulakh
 *
 */
public class LengthException extends RuntimeException{
	/**
	 * Exception constructor
	 */
	public LengthException() {
		super("The password must be at least 6 characters long");
	}

}