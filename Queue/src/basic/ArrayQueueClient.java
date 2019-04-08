package basic;

public class ArrayQueueClient {

	public static void main(String[] args) throws Exception {
		ArrayQueue queue = new ArrayQueue(1000);

		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);

		// while(!queue.isEmpty())
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		

		System.out.println("Front item is " + queue.front());

		System.out.println("Rear item is " + queue.rear());
	}

}
