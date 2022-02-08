/**
 * Exception that is thrown if there is no numbers in the password
 * @author Saad Aulakh
 *
 */
public class NoDigitException extends RuntimeException {
	/**
	 * Exception constructor
	 */

	public NoDigitException() {
		super("The password must contain at least one digit");
	}

}
