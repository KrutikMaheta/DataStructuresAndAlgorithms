package basic;

public class LinkedQueue implements Queue {
	// The queue, front stores the front node of LL and rear stores the
	// last node of LL
	ListNode front, rear;
	int size;

	public LinkedQueue() {
		front = null;
		rear = null;
		size = 0;
	}

	// Method to add an key to the queue.
	public void enqueue(int data) {
		ListNode newNode = new ListNode(data);
		// If queue is empty, then new node is front and rear both
		if (rear == null) {
			front = rear = newNode;
			return;
		}
		// Add the new node at the end of queue and change rear
		rear.setNext(newNode);
		rear = rear.getNext();
		++size;
	}

	// Method to remove an key from queue.
	public int dequeue() throws Exception {
		// If queue is empty, throw exception.
		if (front == null)
			throw new Exception("Queue is empty");
		// Store previous front and move front one node ahead
		ListNode temp = front;
		front = front.getNext();
		// If front becomes NULL, then change rear also as NULL
		if (front == null)
			rear = null;
		--size;
		return temp.getData();
	}

	@Override
	public int front() {
		if (isEmpty())
			return Integer.MIN_VALUE;
		return front.getData();

	}

	@Override
	public int rear() {
		if (isEmpty())
			return Integer.MIN_VALUE;

		return rear.getData();
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

}
