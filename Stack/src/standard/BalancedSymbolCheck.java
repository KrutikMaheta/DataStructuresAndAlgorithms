/**
 * 
 * Write a program to check the given expression is valid or not
 * 
 * Algorithm:
 * 
 * 1. Create the character stack
 * 2. If the expression is of zero length then send it as true
 * 3. Avoid pushing characters other than brackets
 * 4. If the character is open brace than push it on to the stack.
 * 5. If the character is closing brace and the stack is empty than report error; otherwise pop the stack
 * 6. If the symbol popped is not corresponding to opening brace then report error.
 * 7. At the end if the stack is not empty then report an error.
 *  
 */

package standard;

import java.util.Arrays;
import java.util.List;

import basic.LinkedStack;

public class BalancedSymbolCheck {

	static LinkedStack<Character> charStack = new LinkedStack<>();
	static List<Character> list = Arrays.asList('(', ')', '[', ']', '{', '}');

	// time Complexity : O(n) - since just one iteration
	private static boolean isValidSymbolPattern(String expression) {
		if (expression == null || expression.length() == 0)
			return true;
		for (int i = 0; i < expression.length(); i++) {
			if (!list.contains(expression.charAt(i)))
				continue;
			else if (expression.charAt(i) == ')') {
				if (!charStack.isEmpty() && charStack.peek() == '(')
					charStack.pop();
				else
					return false;
			} else if (expression.charAt(i) == ']') {
				if (!charStack.isEmpty() && charStack.peek() == '[')
					charStack.pop();
				else
					return false;
			} else if (expression.charAt(i) == '}') {
				if (!charStack.isEmpty() && charStack.peek() == '{')
					charStack.pop();
				else
					return false;
			} else {
				charStack.push(expression.charAt(i));
			}
		}
		if (charStack.isEmpty())
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		String expression = "[{(A+B)}+{(C-D)}]";
		System.out.println(expression + " is Valid ? " + isValidSymbolPattern(expression));
	}

}
