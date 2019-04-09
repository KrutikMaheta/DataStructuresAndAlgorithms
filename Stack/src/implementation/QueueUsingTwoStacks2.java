//	deQueue operation costly - - Preferred approach

package implementation;

import basic.LinkedStack;
import implementation.QueueUsingTwoStacks.EmptyQueueException;

public class QueueUsingTwoStacks2 {

	LinkedStack<Integer> stack1 = new LinkedStack<>();
	LinkedStack<Integer> stack2 = new LinkedStack<>();

	public void enQueue(int data) {
		stack1.push(data);
	}

	// Dequeue an item from the queue
	public int deQueue() throws EmptyQueueException {
		if (stack1.isEmpty() && stack2.isEmpty())
			throw new EmptyQueueException("Queue is empty at this point");
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty())
				stack2.push(stack1.pop());
		}
		return stack2.pop();
	}

	public static void main(String[] args) throws EmptyQueueException {
		QueueUsingTwoStacks2 queue = new QueueUsingTwoStacks2();
		// System.out.println(queue.deQueue());
		queue.enQueue(5);
		queue.enQueue(6);
		queue.enQueue(7);

		System.out.println(queue.deQueue());

		queue.enQueue(10);
		queue.enQueue(9);

		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
	}

}
