/**
 * Implement Stack using queue
 * 
 * Push operation costly
 * 
 */

package implementation;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
	Queue<Integer> queue = new LinkedList<>();

	public void push(int data) {
		// get previous size of queue
		int size = queue.size();
		// Add current element
		queue.add(data);

		// Pop (or Dequeue) all previous
		// elements and put them after current
		// element
		for (int i = 0; i < size; i++) {
			// this will add front element into
			// rear of queue
			queue.add(queue.poll());
		}
	}

	// Removes the top element
	public int pop() {
		if (queue.isEmpty())
			throw new EmptyStackException();
		return queue.poll();
	}

	public static void main(String[] args) {
		StackUsingQueue stack = new StackUsingQueue();
		stack.push(1);
		stack.push(2);
		System.out.println(stack.pop());
		stack.push(3);

		System.out.println(stack.pop());
		System.out.println(stack.pop());
		stack.push(4);
		System.out.println(stack.pop());
	}

}
