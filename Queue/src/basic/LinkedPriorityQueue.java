/**
 * Implement the priority queue using LinkedList
 * Supporting Files: 	LinkedPriorityQueueClient.java
 * 						PriorityListNode.java
 */

package basic;

public class LinkedPriorityQueue {
	PriorityListNode head;
	int size;

	public LinkedPriorityQueue() {
		head = null;
		size = 0;
	}

	public void enqueue(PriorityListNode newNode) {
		size++;
		if (head == null) {
			head = newNode;
			return;
		}
		if (head.getPriority() < newNode.getPriority()) {
			newNode.setNext(head);
			head = newNode;
		} else {
			PriorityListNode temp = head;
			while (temp.getNext() != null && temp.getNext().getPriority() > newNode.getPriority())
				temp = temp.getNext();
			newNode.setNext(temp.getNext());
			temp.setNext(newNode);
		}
	}

	public int dequeue() throws Exception {
		if (isEmpty())
			throw new Exception("Queue is empty");
		size--;
		PriorityListNode temp = head;
		this.head = head.getNext();
		return temp.getData();
	}

	public boolean isEmpty() {
		return size == 0;
	}

}
