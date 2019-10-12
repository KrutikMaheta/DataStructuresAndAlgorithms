/**
 * Write a program to reverse the queue
 */

package standard;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {

	private static Queue<Integer> queue = new LinkedList<Integer>();

	private static void reverseQueue(Queue<Integer> queue) throws Exception {
		Stack<Integer> stack = new Stack<>();
		while (!queue.isEmpty()) {
			stack.push(queue.peek());
			queue.poll();
		}
		while (!stack.isEmpty()) {
			queue.add(stack.peek());
			stack.pop();
		}

	}

	private static void reverseQueueUsingRecursion() {

		if (!queue.isEmpty()) {
			// Dequeue current item
			int x = queue.poll();
			// Reverse remaining queue
			reverseQueueUsingRecursion();
			// Enqueue current item
			queue.add(x);
		}
	}

	public static void main(String[] args) throws Exception {

		queue.add(10);
		queue.add(20);
		queue.add(30);
		queue.add(40);
		queue.add(50);

		reverseQueue(queue);
		while (!queue.isEmpty()) {
			System.out.print(queue.peek() + ", ");
			queue.remove();
		}
		reverseQueueUsingRecursion();

		while (!queue.isEmpty()) {
			System.out.print(queue.peek() + ", ");
			queue.remove();
		}

	}

}
