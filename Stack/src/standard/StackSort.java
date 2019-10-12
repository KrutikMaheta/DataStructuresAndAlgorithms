/**
 * 
 * Write a program to sort the given stack
 * 
 */

package standard;

import basic.LinkedStack;

public class StackSort {

	private static LinkedStack<Integer> inputStack = new LinkedStack<>();

	/**
	 * Algorithm: 
	 * 1. Create a temporary stack say sortedStack. 
	 * 2. While input stack is NOT empty do this: 
	 * 		i. Pop an element from input stack call it temp 
	 * 		ii. while temporary stack is NOT empty and top of temporary stack is greater than temp,
	 * 			pop from temporary stack and push it to the input stack 
	 * 		iii. push temp in temporary stack 
	 * 3. The sorted numbers are in sortedStack
	 * 
	 */

	private static LinkedStack<Integer> sortUsingTempStack() {
		LinkedStack<Integer> sortedStack = new LinkedStack<>();
		while (!inputStack.isEmpty()) {
			int temp = inputStack.pop();
			while (!sortedStack.isEmpty() && sortedStack.peek() > temp) {
				inputStack.push(sortedStack.pop());
			}
			sortedStack.push(temp);
		}
		return sortedStack;
	}

	/**
	 * Algorithm:
	 * The idea of the solution is to hold all values in Function Call Stack until the stack becomes empty. 
	 * When the stack becomes empty, insert all held items one by one in sorted order. 
	 * Here sorted order is important.
	 * 
	 */
	
	private static void sortedInsert(int x) {
		if (inputStack.isEmpty() || x > inputStack.peek())
			inputStack.push(x);
		else {
			int a = inputStack.pop();
			sortedInsert(x);
			inputStack.push(a);
		}

	}

	private static void sortUsingRecursion() {
		if (!inputStack.isEmpty()) {
			int x = inputStack.pop();
			sortUsingRecursion();
			sortedInsert(x);
		}
	}

	public static void main(String[] args) {
		inputStack.push(15);
		inputStack.push(5);
		inputStack.push(20);
		inputStack.push(3);
		inputStack.push(1);
		System.out.println(inputStack);
		LinkedStack<Integer> sortedStack = sortUsingTempStack();
		System.out.println(sortedStack);

		inputStack.push(15);
		inputStack.push(5);
		inputStack.push(20);
		inputStack.push(3);
		inputStack.push(1);
		System.out.println(inputStack);
		sortUsingRecursion();
		System.out.println(inputStack);

	}

}
