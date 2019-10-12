/**
 * Write a program to check the given string is palindrome using stack
 */

package standard;

import basic.LinkedStack;

public class PalindromeCheck {

	static private LinkedStack<Character> charStack = new LinkedStack<>();

	private static boolean isPalindrome(String str) {
		boolean isXencountered = false;
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) != 'X' && !isXencountered)
				charStack.push(str.charAt(i));
			else {
				isXencountered = true;
				if (charStack.isEmpty() || str.charAt(i + 1) != charStack.pop())
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String str = "aadcbaXabcdaac";
		System.out.println("Is " + str + " Palindrome : " + isPalindrome(str));
	}

}
