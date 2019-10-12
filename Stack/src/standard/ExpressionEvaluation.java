/**
 * Write a program to evaluate the given valid expression
 * 
 */

package standard;

import basic.LinkedStack;

public class ExpressionEvaluation {
	// Stack for numbers: 'values'
	private static LinkedStack<Integer> valueStack = new LinkedStack<>();
	// Stack for Operators: 'ops'
	private static LinkedStack<Character> operatorStack = new LinkedStack<>();

	private static boolean hasPrecedenceGreater(char op1, char op2) {

		if (op2 == '(' || op2 == ')')
			return false;
		else if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
			return false;
		else
			return true;

	}

	private static int applyOperation(char op, int b, int a) {
		switch (op) {
		case '+':
			return a + b;

		case '-':
			return a - b;

		case '*':
			return a * b;

		case '/':
			if (b == 0) {
				throw new UnsupportedOperationException("Cannot divide by zero");
			}
			return a / b;
		}
		return 0;
	}

	public static int evaluate(String expression) {
		char[] tokens = expression.toCharArray();
		for (int i = 0; i < tokens.length; i++) {
			// Current token is a whitespace, skip it
			if (tokens[i] == ' ') {
				continue;
			}
			// Current token is a number, push it to stack for numbers
			else if (tokens[i] >= '0' && tokens[i] <= '9') {
				StringBuffer sb = new StringBuffer();
				// There may be more than one digits in number
				while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
					sb.append(tokens[i++]);
				i -= 1;
				valueStack.push(Integer.valueOf(sb.toString()));
			}
			// Current token is an opening brace, push it to 'ops'
			else if (tokens[i] == '(') {
				operatorStack.push(tokens[i]);
			}
			// Closing brace encountered, solve entire brace
			else if (tokens[i] == ')') {
				while (operatorStack.peek() != '(')
					valueStack.push(applyOperation(operatorStack.pop(), valueStack.pop(), valueStack.pop()));
				operatorStack.pop();
			}
			// Current token is an operator.
			else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {

				// While top of 'ops' has same or greater precedence to current
				// token, which is an operator. Apply operator on top of 'ops'
				// to top two elements in values stack

				while (!operatorStack.isEmpty() && hasPrecedenceGreater(tokens[i], operatorStack.peek()))
					valueStack.push(applyOperation(operatorStack.pop(), valueStack.pop(), valueStack.pop()));

				// Push current token to 'ops'.
				operatorStack.push(tokens[i]);
			}
		}
		// Entire expression has been parsed at this point, apply remaining
		// ops to remaining values
		while (!operatorStack.isEmpty())
			valueStack.push(applyOperation(operatorStack.pop(), valueStack.pop(), valueStack.pop()));

		// Top of 'values' contains result, return it
		return valueStack.pop();
	}

	public static void main(String[] args) {
		String expression = "(2+3*(4/4))";
		System.out.println("Value of Expression : " + expression + " is : " + evaluate(expression));
	}

}
