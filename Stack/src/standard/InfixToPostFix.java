/**
 * 
 * Write a program to convert infix to post fix expression
 * 
 * Algorithm:
 * 
 * 1. Scan the infix expression from left to right
 * 2. If the scanned character is an operand, output it.
 * 3. Else,
		3.1 If the precedence of the scanned operator is greater than the precedence of the operator in the 
			stack(or the stack is empty or the stack contains a ‘(‘ ), push it.
		3.2 Else, Pop all the operators from the stack which are greater than or equal to in precedence than 
			that of the scanned operator. After doing that Push the scanned operator to the stack. 
			(If you encounter parenthesis while popping then stop there and push the scanned operator in the stack.)
 * 	4. If the scanned character is an ‘(‘, push it to the stack.
 *	5. If the scanned character is an ‘)’, pop the stack and and output it until a ‘(‘ is encountered, and 
 *		discard both the parenthesis.
 *	6. Repeat steps 2-6 until infix expression is scanned.
 *	7. Print the output
 *	8. Pop and output from the stack until it is not empty.
 * 
 */

package standard;

import basic.LinkedStack;

public class InfixToPostFix {
	static LinkedStack<Character> charStack = new LinkedStack<>();

	// A utility function to return precedence of a given operator
	// Higher returned value means higher precedence
	private static int precedenceDecider(char ch) {
		switch (ch) {
		case '+':
		case '-':
			return 1;

		case '*':
		case '/':
			return 2;

		case '^':
			return 3;

		default:
			return -1;
		}
	}

	private static String inFixtoPostFixConversion(String inFixexpression) {
		String result = new String("");
		for (int i = 0; i < inFixexpression.length(); i++) {
			char c = inFixexpression.charAt(i);

			// If the scanned character is an operand, add it to output.
			if (Character.isLetterOrDigit(c))
				result += c;

			// If the scanned character is an '(', push it to the stack.
			else if (c == '(')
				charStack.push(c);

			// If the scanned character is an ')', pop and output from the stack
			// until an '(' is encountered
			else if (c == ')') {
				while (!charStack.isEmpty() && charStack.peek() != '(')
					result += charStack.pop();
				if (!charStack.isEmpty() && charStack.peek() != '(')
					return "Invalid Infix expression";
				else
					charStack.pop();
			} else { // an operator is encountered
				while (!charStack.isEmpty() && precedenceDecider(c) <= precedenceDecider(charStack.peek()))
					result += charStack.pop();
				charStack.push(c);
			}
		}
		// pop all the operators from the stack
		while (!charStack.isEmpty())
			result += charStack.pop();
		return result;
	}

	public static void main(String[] args) {
		String inFixexpression = "a+b*(c^d-e)^(f+g*h)-i";
		System.out.println(
				"postfix for infix : " + inFixexpression + " is ==> " + inFixtoPostFixConversion(inFixexpression));
	}

}
