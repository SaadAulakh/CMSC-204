/**
 * Exception that is thrown if password has no upper case letters
 * @author Saad Aulakh
 *
 */
public class NoUpperAlphaException extends RuntimeException {
/**
 * Exception constructor
 */
	public NoUpperAlphaException() {
		super("The password must contain at least one uppercase alphabetic character");
	}
}
