/**
 * Write a program to move the capital characters from the string to and end.
 */
package faqs;

public class MoveCapsToEnd {

	public static void main(String[] args) {
		String s = "My Name is KrutIk";
		System.out.println(moveCapsToEnd(s));
	}

	private static String moveCapsToEnd(String s) {
		return s.replaceAll("[A-Z]", "") + s.replaceAll("[^A-Z]", "");
	}

}
