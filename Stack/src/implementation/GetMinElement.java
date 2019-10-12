/**
 * Create an advanced stack which can give the minimum value from the stack with O(1) time and space complexity
 * 
 * Algorithm:
 * 
 * Push(x) : Inserts x at the top of stack.
 * 1.	If stack is empty, insert x into the stack and make minEle equal to x.
 * 2.	If stack is not empty, compare x with minEle. 
  		Two cases arise:
		If x is greater than or equal to minEle, simply insert x.
		If x is less than minEle, insert (2*x – minEle) into the stack and make minEle equal to x. 
		For example, let previous minEle was 3. Now we want to insert 2. 
		We update minEle as 2 and insert 2*2 – 3 = 1 into the stack.
 * 
 *	Pop() : Removes an element from top of stack.
 *	1.	Remove element from top. Let the removed element be y. 
 *		Two cases arise:
 *		If y is greater than or equal to minEle, the minimum element in the stack is still minEle.
 *		If y is less than minEle, the minimum element now becomes (2*minEle – y), 
 *		so update (minEle = 2*minEle – y). 
 *		This is where we retrieve previous minimum from current minimum and its value in stack. 
 *		For example, let the element to be removed be 1 and minEle be 2. 
 *		We remove 1 and update minEle as 2*2 – 1 = 3.
 * 
 * How does this approach work?
 * 		When element to be inserted is less than minEle, we insert “2x – minEle”. 
 * 		The important thing to notes is, 2x – minEle will always be less than x (proved below), 
 * 		i.e., new minEle and while popping out this element we will see that something unusual has 
 * 		happened as the popped element is less than the minEle. So we will be updating minEle.
 * 
 * 
 */

package implementation;

import java.util.Stack;

class AdvancedStack {
	private Stack<Integer> myStack;

	private int minElement;

	public AdvancedStack() {
		myStack = new Stack<>();
	}

	public void push(int data) {
		if (myStack.isEmpty()) {
			minElement = data;
			myStack.push(data);
		} else if (minElement > data) {
			myStack.push(2 * data - minElement);
			minElement = data;
		} else
			myStack.push(data);
	}

	public int pop() {
		if (myStack.isEmpty())
			return Integer.MIN_VALUE;
		int popValue = myStack.pop();
		if (popValue < minElement) {
			int temp = popValue;
			popValue = minElement;
			minElement = 2 * minElement - temp;
		}
		return popValue;
	}

	public int peek() {
		if (myStack.isEmpty())
			return Integer.MIN_VALUE;
		int peekValue = myStack.peek();
		if (peekValue < minElement)
			peekValue = minElement;
		return peekValue;
	}

	public int getMinElement() {
		return minElement;
	}

	public Stack<Integer> getMyStack() {
		return myStack;
	}

	/*
	 * public int getMaxElement() { return maxElement; }
	 */

}

public class GetMinElement {

	public static void main(String[] args) {
		AdvancedStack advanceStack = new AdvancedStack();

		advanceStack.push(4);
		advanceStack.push(3);
		advanceStack.push(5);
		advanceStack.push(1);
		advanceStack.push(2);
		advanceStack.push(-1);

		System.out.println(advanceStack.getMinElement());
	}

}
