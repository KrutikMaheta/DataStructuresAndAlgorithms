package basic;

public class LinkedQueueClient {

	public static void main(String[] args) throws Exception {
		LinkedQueue q = new LinkedQueue();
		q.enqueue(10);
		q.enqueue(20);
		System.out.println("Dequeued item is " + q.dequeue());
		System.out.println("Dequeued item is " + q.dequeue());

		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);

		System.out.println("Dequeued item is " + q.dequeue());
		System.out.println("Dequeued item is " + q.dequeue());
		System.out.println("Dequeued item is " + q.dequeue());
		System.out.println("Dequeued item is " + q.dequeue());
	}

}
