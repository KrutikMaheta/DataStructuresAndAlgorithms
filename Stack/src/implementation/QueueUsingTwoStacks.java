//	Enqueue operation costly

package implementation;

import basic.LinkedStack;

public class QueueUsingTwoStacks {

	LinkedStack<Integer> stack1 = new LinkedStack<>();
	LinkedStack<Integer> stack2 = new LinkedStack<>();

	static class EmptyQueueException extends Exception {

		private static final long serialVersionUID = 1L;

		public EmptyQueueException(String message) {
			super(message);
		}
	}

	public void enQueue(int data) {
		// Move all elements from s1 to s2
		while (!stack1.isEmpty())
			stack2.push(stack1.pop());
		// Push item into s1
		stack1.push(data);
		// Push everything back to s1
		while (!stack2.isEmpty())
			stack1.push(stack2.pop());
	}

	// Dequeue an item from the queue
	public int deQueue() throws EmptyQueueException {
		if (stack1.isEmpty()) {
			throw new EmptyQueueException("Queue is empty");
		} else
			// Return top of s1
			return stack1.pop();
	}

	public static void main(String[] args) throws EmptyQueueException {
		QueueUsingTwoStacks queue = new QueueUsingTwoStacks();
		// System.out.println(queue.deQueue());
		queue.enQueue(5);
		queue.enQueue(6);
		queue.enQueue(7);

		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
	}

}
