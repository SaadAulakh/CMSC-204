/**
 * Exception that is thrown if password has no special characters
 * @author Saad Aulakh
 *
 */
public class NoSpecialCharacterException extends RuntimeException {
	/**
	 * Exception constructor
	 */
	public NoSpecialCharacterException() {
		super("The password must contain at least one special character");
	}
}
