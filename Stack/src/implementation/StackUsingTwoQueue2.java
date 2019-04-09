//	By making pop operation costly - Preferred approach
package implementation;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueue2 {
	Queue<Integer> q1 = new LinkedList<>();
	Queue<Integer> q2 = new LinkedList<>();

	public void push(int data) {
		q1.add(data);
	}

	public int pop() {
		int res = 0;
		if (q1.isEmpty() && q2.isEmpty())
			throw new EmptyStackException();
		while (true) {
			// Leave one element in q1 and
			// push others in q2.
			if (q1.size() == 1) {
				res = q1.poll();
				break;
			} else
				q2.add(q1.poll());
		}
		// swap the names of two queues
		Queue<Integer> q = new LinkedList<>();
		q = q1;
		q1 = q2;
		q2 = q;
		return res;
	}

	public static void main(String[] args) {
		StackUsingTwoQueue2 stack = new StackUsingTwoQueue2();
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
