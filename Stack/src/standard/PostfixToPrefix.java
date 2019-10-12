/**
 * 
 * Write a program to convert the postfix expression to prefix.
 * 
 * Algorithm:
 * 
 * 1.	Read the Postfix expression from left to right
 * 2.	If the symbol is an operand, then push it onto the Stack
 * 3.	If the symbol is an operator, then pop two operands from the Stack
 * 4.	Create a string by concatenating the two operands and the operator before them.
			string = operator + operand2 + operand1
 * 5.	And push the resultant string back to Stack
 * 6.	Repeat the above steps until end of Prefix expression.
 * 
 */

package standard;

import basic.LinkedStack;

public class PostfixToPrefix {
	static LinkedStack<String> stringStack = new LinkedStack<>();

	private static String postFixToPrefixConversion(String postFixExpression) {
		for (int i = 0; i < postFixExpression.length(); i++) {
			char c = postFixExpression.charAt(i);
			if (Character.isLetterOrDigit(c))
				stringStack.push(String.valueOf(c));

			// We assume that input is
			// a valid postfix and expect
			// an operator.
			else {
				String op1 = stringStack.pop();
				String op2 = stringStack.pop();
				stringStack.push(String.valueOf(c) + op2 + op1);
			}
		}
		// There must be a single element
		// in stack now which is the required
		// infix.
		return stringStack.peek();
	}

	public static void main(String[] args) {
		String postFixExpression = "AB+CD-*";
		System.out.println("postfix For prefix : " + postFixExpression + " is ==> "
				+ postFixToPrefixConversion(postFixExpression));
	}

}
