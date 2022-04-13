import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class that is used to convert morse code to English
 * 
 * @author Saad Aulakh
 *
 */
public class MorseCodeConverter {
	private static MorseCodeTree tree = new MorseCodeTree();

	/**
	 * Method that translates a String that has morse code into English
	 * 
	 * @param code morse code
	 * @return string which is the English translation of the code
	 */
	protected static String convertToEnglish(String code) {
		String words[] = code.split("/");
		String str = "";
		String letters[];
		for (int i = 0; i < words.length; i++) {
			words[i] = words[i].trim();
			letters = words[i].split(" ");
			for (int j = 0; j < letters.length; j++) {
				str += tree.fetch(letters[j]);
			}
			str += " ";

		}

		return str.trim();
	}

	/**
	 * Methods that translates morse code from a file
	 * 
	 * @param file a file that has morse code in it
	 * @return string which is the English translation of the morse code in the file
	 * @throws FileNotFoundException if the file is not found
	 */
	protected static String convertToEnglish(File file) throws FileNotFoundException {
		BufferedReader fileReader = new BufferedReader(new FileReader(file));
		StringBuilder strB = new StringBuilder();
		String line = null;
		
		try {
			while ((line = fileReader.readLine()) != null) {
				strB.append(convertToEnglish(line));
				strB.append("\n");
			}
			fileReader.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		String str = strB.toString().trim();
		return str;
	}

	/**
	 * Method that prints out the binary tree
	 * 
	 * @return string that has all the values of the binary tree separated by a
	 *         space
	 */
	protected static String printTree() {
		ArrayList<String> fullTree = tree.toArrayList();
		String str = "";
		for (String letter : fullTree) {
			str += letter + " ";
		}
		return str.trim();
	}
}
