/**
 * Write a program to list down the possible sub strings from the given string.
 */

package faqs;

public class PossibleSubStrings {

	public static void main(String[] args) {
		possibleSubStrings("abcd");
	}

	private static void possibleSubStrings(String string) {
		for (int i = 0; i < string.length(); i++) {
			for (int j = i + 1; j < string.length() + 1; j++) {
				System.out.println(string.substring(i, j));
			}
		}
	}

}
