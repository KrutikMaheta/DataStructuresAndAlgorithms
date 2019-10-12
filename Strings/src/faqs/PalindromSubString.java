/**
 * Write a program to list out the palindrome substrings from the given string
 */
package faqs;

import java.util.HashSet;
import java.util.Set;

public class PalindromSubString {

	public static void main(String[] args) {
		palimSubString("geek");
	}

	private static void palimSubString(String string) {
		Set<String> palimSubStrings = new HashSet<String>();
		for (int i = 0; i < string.length(); i++) {
			for (int j = i + 1; j <= string.length(); j++) {
				if (isPalindrome(string.substring(i, j)))
					palimSubStrings.add(string.substring(i, j));
			}
		}
		System.out.println(palimSubStrings);
	}

	private static boolean isPalindrome(String substring) {
		return substring.equals(new StringBuffer(substring).reverse().toString());
	}

}
