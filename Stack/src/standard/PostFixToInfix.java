/**
 * 
 * Write a program to convert the postfix expression to infix.
 * 
 * Algorithm:
 * 
 * 	1.While there are input symbol left,
		1.1 Read the next symbol from the input.
 *	2.If the symbol is an operand
		2.1 Push it onto the stack.
 *	3.Otherwise,
		…3.1 the symbol is an operator.
		…3.2 Pop the top 2 values from the stack.
		…3.3 Put the operator, with the values as arguments and form a string.
		…3.4 Push the resulted string back to stack.
 *	4.If there is only one value in the stack
		…4.1 That value in the stack is the desired infix string.
 */

package standard;

import basic.LinkedStack;

public class PostFixToInfix {

	static LinkedStack<String> stringStack = new LinkedStack<>();

	private static String postFixToInfixConversion(String postFixExpression) {
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
				stringStack.push("(" + op2 + String.valueOf(c) + op1 + ")");
			}
		}
		// There must be a single element
		// in stack now which is the required
		// infix.
		return stringStack.peek();

	}

	public static void main(String[] args) {
		String postFixExpression = "abcd^e-fgh*+^*+i-";
		System.out.println(
				"Infix For postfix : " + postFixExpression + " is ==> " + postFixToInfixConversion(postFixExpression));
	}

}
