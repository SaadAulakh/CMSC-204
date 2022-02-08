import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
/**
 * Program that checks a users password or list of passwords to make sure they are valid under a certain criteria.
 * @author Saad Aulakh
 *
 */
public class PasswordCheckerUtility extends Object {

	/**
	 * This method checks if the password is less than 10 characters but >= 6. If
	 * the password is less than 10 characters but >= 6, it is a weak password.
	 * 
	 * @param password Password that user enters
	 * @return true if the password has 6 or more characters and 9 or less
	 *         characters.
	 * @throws WeakPasswordException thrown if password is over 6 characters and less than 10 characters long
	 */
	public static boolean isWeakPassword(String password) throws WeakPasswordException {

		if (password.length() > 5 && password.length() < 10) {
			throw new WeakPasswordException();
		}

		return false;
	}

	/**
	 * Checks if password is valid by checking if it is long enough, if it has an
	 * upper case/lower case letter, a number, a special character and if it doesn't
	 * have more than two characters in a row that are the same.
	 * 
	 * @param password Password that user enters
	 * @return true if password is valid
	 * @throws LengthException             thrown if password is too short
	 * @throws NoUpperAlphaException       thrown if password has no upper case
	 *                                     letter
	 * @throws NoDigitException            thrown if password has no number
	 * @throws NoLowerAlphaException       thrown if password has no lower case
	 *                                     number
	 * @throws InvalidSequenceException    thrown if password has more than 2
	 *                                     characters in a row that are the same
	 * @throws NoSpecialCharacterException thrown if password has no special
	 *                                     characters
	 */
	public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException,
			NoDigitException, NoLowerAlphaException, InvalidSequenceException, NoSpecialCharacterException {
		if (!isValidLength(password))
			throw new LengthException();
		if (!hasUpperAlpha(password))
			throw new NoUpperAlphaException();
		if (!hasLowerAlpha(password))
			throw new NoLowerAlphaException();
		if (!hasDigit(password))
			throw new NoDigitException();
		if (!hasSpecialChar(password))
			throw new NoSpecialCharacterException();
		if (!NoSameCharInSequence(password))
			throw new InvalidSequenceException();

		return true;
	}

	/**
	 * This method checks if a password has between 6 and 9 characters.
	 * 
	 * @param password Password that user enters
	 * @return true if the password has 6 or more characters and 9 or less
	 *         characters.
	 */
	public static boolean hasBetweenSixAndNineChars(String password) {

		return (password.length() > 5 && password.length() < 10);
	}

	/**
	 * Puts all the invalid passwords into an ArrayList and return it
	 * 
	 * @param passwords ArrayList full of passwords 
	 * @return an ArrayList full of invalid passwords
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
		ArrayList<String> invalidPasswords = new ArrayList<>();
		for (int i = 0; i < passwords.size(); i++)
			try {
				isValidPassword(passwords.get(i));
			} catch (Exception e) {
				//if password is not valid, it is added to an ArrayList with its exception message
				invalidPasswords.add(passwords.get(i) + " -> " + e.getMessage());
			}
		return invalidPasswords;

	}

	/**
	 * Check if password is over 6 characters
	 * 
	 * @param password Password that user enters
	 * @return true if password is over 6 characters
	 * @throws LengthException thrown if password is less than 6 characters
	 */
	public static boolean isValidLength(String password) throws LengthException {
		if (password.length() < 6)
			throw new LengthException();
		return true;
	}

	/**
	 * Checks if password has a lower case letter
	 * 
	 * @param password Password that user enters
	 * @return true if there is a lower case letter in the password
	 * @throws NoLowerAlphaException thrown if password has no lower case letters
	 */
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
		Pattern pattern = Pattern.compile("[a-z]");
		for (int i = 0; i < password.length(); i++) {
			//check each character until a lower case letter is found
			Matcher matcher = pattern.matcher(Character.toString(password.charAt(i)));
			// if matcher finds lower case letter, return true
			if (matcher.matches())
				return true;
		}
		throw new NoLowerAlphaException();
	}

	/**
	 * Checks if password has a upper case letter
	 * 
	 * @param password Password that user enters
	 * @return true if there is a upper case letter in the password
	 * @throws NoUpperAlphaException thrown if there is no upper case letters in the password
	 */
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
		Pattern pattern = Pattern.compile("[A-Z]*");
		for (int i = 0; i < password.length(); i++) {
			//check each character until a upper case letter is found
			Matcher matcher = pattern.matcher(Character.toString(password.charAt(i)));
			// if matcher finds upper case letter, return true
			if (matcher.matches())
				return true;
		}
		throw new NoUpperAlphaException();
	}

	/**
	 * Checks if password has a number
	 * 
	 * @param password Password that user enters
	 * @return true if there is a number in the password
	 * @throws NoDigitException thrown if there is no numbers in the password
	 */
	public static boolean hasDigit(String password) throws NoDigitException {
		Pattern pattern = Pattern.compile("[0-9]");
		for (int i = 0; i < password.length(); i++) {
			//check each character until a number is found
			Matcher matcher = pattern.matcher(Character.toString(password.charAt(i)));
			// if matcher finds number, return true
			if (matcher.matches())
				return true;
		}
		throw new NoDigitException();
	}

	/**
	 * Checks if password has a special character
	 * 
	 * @param password Password that user enters
	 * @return true if there is a special character in the password
	 * @throws NoSpecialCharacterException thrown if no special characters are found in the password
	 */
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
		Pattern pattern = Pattern.compile("\\W");
		for (int i = 0; i < password.length(); i++) {
			//check each character until a special character is found
			Matcher matcher = pattern.matcher(Character.toString(password.charAt(i)));
			// if matcher finds special character, return true
			if (matcher.matches())
				return true;
		}
		throw new NoSpecialCharacterException();
	}

	/**
	 * Check if there is more than 2 characters in a row that are the same
	 * 
	 * @param password Password that user enters
	 * @return true if there is not 2 or more characters in a row that are the same
	 * @throws InvalidSequenceException thrown if there is more than two characters in a row that are the same in the password
	 */
	public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException {

		for (int i = 0; i < password.length(); i++) {
			try {
				if (password.charAt(i) == password.charAt(i + 1) && password.charAt(i) == password.charAt(i + 2))
					throw new InvalidSequenceException();
			} catch (IndexOutOfBoundsException e) {
				break;
			}
		}
		return true;
	}

	/**
	 * Check if the password and confirm password are the same
	 * 
	 * @param password Password that user enters
	 * @param password2 Password that user enters to confirm their password
	 * @return true if both passwords are identical
	 */
	public static boolean comparePasswordsWithReturn(String password, String password2) {
		if (password.equals(password2))
			return true;
		return false;
	}

	/**
	 * Calls a method to check if passwords are identical. If they are not
	 * identical, throw an exception.
	 * 
	 * @param password Password that user enters
	 * @param password2 Password that user enters to confirm their password
	 * @throws UnmatchedException thrown if both passwords do no match
	 */
	public static void comparePasswords(String password, String password2) throws UnmatchedException {

		if (!(comparePasswordsWithReturn(password, password2))) {
			throw new UnmatchedException();
		}
	}

}
