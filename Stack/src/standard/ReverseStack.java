/**
 * 
 * Write a program to reverse the given stack
 * 
 * 
 * Algorithm: The idea of the solution is to hold all values in Function Call Stack until the stack becomes 
 * empty. When the stack becomes empty, insert all held items one by one at the bottom of the stack.
 * 
 * void insertAtBottom((): 
 * 		First pops all stack items and stores the popped item in function call stack using recursion. 
 * 		And when stack becomes empty, pushes new item and all items stored in call stack.
 * void reverse(): 
 * 		This function mainly uses insertAtBottom() to pop all items one by one and insert the popped items 
 * 		at the bottom.
 * 
 */

package standard;

import basic.LinkedStack;

public class ReverseStack {

	private static LinkedStack<Integer> stack = new LinkedStack<>();

	// Time complexity : O(n2)
	// Space Complexity : O(n)
	private static void reverseUsingRecursion() {
		if (!stack.isEmpty()) {
			// Hold all items in Function
			// Call Stack until we
			// reach end of the stack
			int x = stack.peek();
			stack.pop();
			reverseUsingRecursion();
			// Insert all the items held
			// in Function Call Stack
			// one by one from the bottom
			// to top. Every item is
			// inserted at the bottom
			insert_at_bottom(x);
		}
	}

	private static void insert_at_bottom(int x) {
		if (stack.isEmpty())
			stack.push(x);
		else {
			// All items are held in Function
			// Call Stack until we reach end
			// of the stack. When the stack becomes
			// empty, the st.size() becomes 0, the
			// above if part is executed and
			// the item is inserted at the bottom
			int a = stack.peek();
			stack.pop();
			insert_at_bottom(x);

			// push allthe items held
			// in Function Call Stack
			// once the item is inserted
			// at the bottom
			stack.push(a);
		}
	}

	public static void main(String[] args) {
		stack.push(15);
		stack.push(5);
		stack.push(20);
		stack.push(3);
		stack.push(1);
		System.out.println(stack);
		stack.reverse();
		System.out.println(stack);
		reverseUsingRecursion();
		System.out.println(stack);
	}

}
