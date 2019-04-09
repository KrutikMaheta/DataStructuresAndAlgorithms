//	By making push operation costly
package implementation;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueue {

	Queue<Integer> q1 = new LinkedList<>();
	Queue<Integer> q2 = new LinkedList<>();

	int size = 0;

	public void push(int data) {
		size++;
		// Push x first in empty q2
		q2.add(data);

		// Push all the remaining
		// elements in q1 to q2.
		while (!q1.isEmpty()) {
			q2.add(q1.poll());
		}
		// swap the names of two queues
		Queue<Integer> q = new LinkedList<>();
		q = q1;
		q1 = q2;
		q2 = q;
	}

	public int pop() {
		// if no elements are there in q1
		if (q1.isEmpty())
			throw new EmptyStackException();
		size--;
		return q1.poll();
	}

	public static void main(String[] args) {
		StackUsingTwoQueue stack = new StackUsingTwoQueue();
		stack.push(1);
		stack.push(2);
	//	System.out.println(stack.pop());
		stack.push(3);

		//System.out.println(stack.pop());
	//	System.out.println(stack.pop());
		stack.push(4);
		System.out.println(stack.pop());
	}

}
