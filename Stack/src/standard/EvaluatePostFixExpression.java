/**
 * Write a program to evaluate the given valid post fix expression
 */

package standard;

import basic.LinkedStack;

public class EvaluatePostFixExpression {

	// create a stack
	private static LinkedStack<Integer> stack = new LinkedStack<>();

	static int evaluatePostfix(String exp) {

		// Scan all characters one by one
		for (int i = 0; i < exp.length(); i++) {
			char c = exp.charAt(i);

			// If the scanned character is an operand (number here),
			// push it to the stack.
			if (Character.isDigit(c))
				stack.push(c - '0');

			// If the scanned character is an operator, pop two
			// elements from stack apply the operator
			else {
				int val1 = stack.pop();
				int val2 = stack.pop();

				switch (c) {
				case '+':
					stack.push(val2 + val1);
					break;

				case '-':
					stack.push(val2 - val1);
					break;

				case '/':
					stack.push(val2 / val1);
					break;

				case '*':
					stack.push(val2 * val1);
					break;
				}
			}
		}
		return stack.pop();
	}

	public static void main(String[] args) {
		String exp = "231*+9-";
		System.out.println("postfix evaluation: " + evaluatePostfix(exp));
	}

}
