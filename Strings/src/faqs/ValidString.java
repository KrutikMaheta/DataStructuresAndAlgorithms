/**
 * Valid String: Check the given string is valid or not
 * 
 * Check if a string has all characters with same frequency with one variation allowed.
 * 
 * Given a string of lowercase alphabets, find if it can be converted to a Valid String by 
 * removing 1 or 0 characters. A “valid” string is a string str such that for all distinct 
 * characters in str each such character occurs the same number of times in it.
 *
 * Input : string str = "abbca"
 * Output : Yes
 * We can make it valid by removing "c"
 * 
 * Input : string str = "aabbcd"
 * Output : No
 * We need to remove at least two characters to make it valid.
 * 
 * Input : string str = "abbccd"
 * Output : No
 * 
 */
package faqs;

import java.util.Arrays;

public class ValidString {

	public static void main(String[] args) {
		System.out.println(validString("aaabbcc"));
	}

	private static String validString(String string) {
		if (string.length() == 1 || string.length() == 2)
			return "YES";
		int count[] = new int[26];
		boolean isRemoved = false;
		int max_occur = -1;

		for (int i = 0; i < string.length(); i++)
			count[string.charAt(i) - 'a']++;

		System.out.println(Arrays.toString(count));
		for (int i = 0; i < count.length; i++) {
			if (count[i] == 0)
				continue;
			else if (max_occur == -1)
				max_occur = count[i];
			else if (max_occur == count[i])
				continue;
			else if (!isRemoved && (count[i] == 1 || count[i] == max_occur + 1)) {
				isRemoved = !isRemoved;
			} else
				return "NO";
		}

		return "YES";
	}

}
