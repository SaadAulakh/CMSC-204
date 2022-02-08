/**
 * Exception that is thrown if password has no lower case letters
 * @author Saad Aulakh
 *
 */
public class NoLowerAlphaException extends Exception {
	/**
	 * Exception constructor
	 */
	public NoLowerAlphaException() {
		super("The password must contain at least one lowercase alphabetic character");
	}

}
