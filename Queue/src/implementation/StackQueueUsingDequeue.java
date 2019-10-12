/**
 * Implement the stack using dequeue
 */

package implementation;

import basic.DoublyLinkedDequeue;

public class StackQueueUsingDequeue {

	private static DoublyLinkedDequeue dequeue = new DoublyLinkedDequeue();

	public void push(int data) {
		dequeue.insertFront(data);
	}

	public int pop() throws Exception {
		return dequeue.removeFront();
	}

	public void enqueue(int data) {
		dequeue.insertFront(data);
	}

	public int dequeue() throws Exception {
		return dequeue.removeRear();
	}

	public static void main(String[] args) throws Exception {
		System.out.println("Stack Operation result");

		// Insert in Front & remove from front

		StackQueueUsingDequeue stack = new StackQueueUsingDequeue();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);

		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

		System.out.println("Queue Operation result");

		// Insert from Front and remove from Rear
		StackQueueUsingDequeue queue = new StackQueueUsingDequeue();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);

		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}

}
