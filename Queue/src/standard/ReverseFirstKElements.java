/**
 *	Write a program to reverse the first k elements from the given queue
 */

package standard;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKElements {

	private static Queue<Integer> queue = new LinkedList<Integer>();

	private static void reversseFirstKElements(int k) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < k; i++)
			stack.push(queue.poll());

		while (!stack.isEmpty())
			queue.add(stack.pop());

		for (int i = k + 1; i <= queue.size(); i++)
			queue.add(queue.poll());

	}

	public static void main(String[] args) {
		queue.add(10);
		queue.add(20);
		queue.add(30);
		queue.add(40);
		queue.add(50);
		queue.add(60);

		System.out.println(queue);
		reversseFirstKElements(3);
		System.out.println(queue);

	}

}
