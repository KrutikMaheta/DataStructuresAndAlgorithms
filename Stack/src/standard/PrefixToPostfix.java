/**
 * Write a program to convert the prefix expression to post fix.
 */

package standard;

import basic.LinkedStack;

public class PrefixToPostfix {
	static LinkedStack<String> stringStack = new LinkedStack<>();

	private static String preFixToPostfixConversion(String preFixExpression) {
		for (int i = preFixExpression.length() - 1; i >= 0; i--) {
			char c = preFixExpression.charAt(i);
			if (Character.isLetterOrDigit(c))
				stringStack.push(String.valueOf(c));

			// We assume that input is
			// a valid prefix and expect
			// an operator.
			else {
				String op1 = stringStack.pop();
				String op2 = stringStack.pop();
				stringStack.push(op1 + op2 + String.valueOf(c));
			}
		}
		// There must be a single element
		// in stack now which is the required
		// infix.
		return stringStack.peek();

	}

	public static void main(String[] args) {
		String preFixExpression = "*-A/BC-/AKL";
		System.out.println(
				"Infix For postfix : " + preFixExpression + " is ==> " + preFixToPostfixConversion(preFixExpression));
	}

}
