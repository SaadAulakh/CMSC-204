/**
 * Exception that is thrown if password and "confirm" password are not the same
 * @author Saad Aulakh
 *
 */
public class UnmatchedException extends RuntimeException {
	/**
	 * Exception constructor
	 */
	public UnmatchedException() {
		super("Passwords do not match");
	}

}
