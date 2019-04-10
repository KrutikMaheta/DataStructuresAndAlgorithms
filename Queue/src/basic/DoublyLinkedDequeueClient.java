package basic;

public class DoublyLinkedDequeueClient {

	public static void main(String[] args) throws Exception {
		DoublyLinkedDequeue deque = new DoublyLinkedDequeue();
		deque.insertFront(134);
		deque.insertFront(14);
		deque.insertFront(13);
		System.out.println(deque.removeFront());
		deque.insertRear(455);
		System.out.println(deque.removeFront());
		System.out.println(deque.removeRear());
	}

}
