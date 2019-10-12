/**
 * Implement Fixed size stack
 * 
 * Supporting files: 	FixedArrayStackClient.java
 * 						Stack.java
 * 
 */
package basic;

public class FixedArrayStack implements Stack {
	// Length of an array used to implement the stack
	private int capacity;
	// Default array capacity
	private static final int CAPACITY = 10;
	// Array used to implement the stack
	private int[] stack;
	// Index for the top element in the array
	private int top = -1;

	// Initialize the stack with the default capacity
	public FixedArrayStack() {
		stack = new int[CAPACITY];
	}

	// Initialize the stack to use an array of given length
	public FixedArrayStack(int capacity) {
		this.capacity = capacity;
		stack = new int[capacity];
	}

	// Returns the number of elements in the array : O(1)
	public int size() {
		return (top + 1);
	}

	// Tests whether the stack is empty : O(1)
	public boolean isEmpty() {
		return (top < 0);
	}

	// Insert an element at the top of the stack : O(1)
	public void push(int data) throws Exception {
		if (size() == capacity)
			throw new Exception("StackOverflow Exception");
		stack[++top] = data;
	}

	// Inspect the element at the top of the stack : O(1)
	public int top() throws Exception {
		if (isEmpty())
			throw new Exception("StackUnderflow Exception");
		return stack[top];
	}

	// Returns the top element from the stack : O(1)
	public int pop() throws Exception {
		if (isEmpty())
			throw new Exception("StackUnderflow Exception");
		int data = stack[top];
		stack[top--] = Integer.MIN_VALUE;
		return data;
	}

	@Override
	public String toString() {
		String s = "[";
		if (size() > 0) {
			for (int i = 0; i < size(); i++)
				s += stack[i] + ",";
		}
		return s.equals("[") ? s + "]" : s.substring(0, s.length() - 1) + "]";

	}
}
