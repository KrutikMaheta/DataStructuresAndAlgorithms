package basic;

public class LinkedPriorityQueueClient {

	public static void main(String[] args) throws Exception {
		LinkedPriorityQueue priorityQueue = new LinkedPriorityQueue();
		priorityQueue.enqueue(new PriorityListNode(10, 3));
		priorityQueue.enqueue(new PriorityListNode(20, 1));
		priorityQueue.enqueue(new PriorityListNode(30, 2));
		priorityQueue.enqueue(new PriorityListNode(40, 5));
		priorityQueue.enqueue(new PriorityListNode(50, 4));
		
		System.out.println(priorityQueue.dequeue());
		System.out.println(priorityQueue.dequeue());
		System.out.println(priorityQueue.dequeue());
		System.out.println(priorityQueue.dequeue());
		System.out.println(priorityQueue.dequeue());
		
		System.out.println(priorityQueue.dequeue());
	}

}
