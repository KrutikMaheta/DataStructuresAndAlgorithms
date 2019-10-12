/**
 * 
 * Write a program to remove the middle element from the stack
 * 
 * Algorithm: The idea is to use recursive calls. We first remove all items one by one, then we recur. 
 * After recursive calls, we push all items back except the middle item.
 */

package standard;

import basic.LinkedStack;

public class RemoveMiddleElement {

	private static void removeMiddleElement(LinkedStack<Integer> stack, int size, int curr) {
		if (stack.isEmpty() || curr == size) {
			return;
		}
		int element = stack.pop();
		removeMiddleElement(stack, size, curr + 1);
		if (curr != size / 2)
			stack.push(element);
	}

	public static void main(String[] args) {
		LinkedStack<Integer> stack = new LinkedStack<>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(25);
		stack.push(35);

		System.out.println(stack);

		removeMiddleElement(stack, stack.size(), 0);
		System.out.println(stack);
	}

}
