/**
 * 
 * Write a program to convert the prefix expression to infix.
 * 
 * Algorithm:
 * 
 * 1.	Read the Prefix expression in reverse order (from right to left)
 * 2.	If the symbol is an operand, then push it onto the Stack
 * 3.	If the symbol is an operator, then pop two operands from the Stack	
 * 4.	Create a string by concatenating the two operands and the operator between them.
			string = (operand1 + operator + operand2)
 * 5.	And push the resultant string back to Stack
 * 6.	Repeat the above steps until end of Prefix expression.
 */

package standard;

import basic.LinkedStack;

public class PrefixToInfix {

	static LinkedStack<String> stringStack = new LinkedStack<>();

	private static String preFixToInfixConversion(String preFixExpression) {
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
				stringStack.push("(" + op1 + String.valueOf(c) + op2 + ")");
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
				"Infix For postfix : " + preFixExpression + " is ==> " + preFixToInfixConversion(preFixExpression));
	}

}
