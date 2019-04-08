/**
 * Algorithm:
 * 
 * Start two stacks from two extreme corners of arr[]. 
 * Stack1 starts from the leftmost element, the first element in stack1 is pushed at index 0. 
 * The stack2 starts from the rightmost corner, the first element in stack2 is pushed at index (n-1). 
 * Both stacks grow (or shrink) in opposite direction. 
 * To check for overflow, all we need to check is for space between top elements of both stacks.
 * 
 */

package basic;

public class TwoStacks {
	int size;
	int[] arr;
	int top1, top2;

	public TwoStacks(int size) {
		this.size = size;
		arr = new int[size];
		top1 = -1;
		top2 = size;
	}

	public void push1(int data) {
		if (top1 < top2 - 1) {
			arr[++top1] = data;
		} else {
			throw new StackOverflowError();
		}
	}

	public void push2(int data) throws Exception {
		if (top1 < top2 - 1) {
			arr[--top2] = data;
		} else {
			throw new Exception("Stack overflow exception");
		}
	}

	public int pop1() throws Exception {
		if (top1 <= -1)
			throw new Exception("Stack underflow exception");
		return arr[top1--];
	}

	public int pop2() throws Exception {
		if (top2 >= size)
			throw new Exception("Stack underflow exception");
		return arr[top2++];
	}

}
