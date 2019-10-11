/**
 * Implementation of Circular LinkedList
 * Supporting Files: CLLNode.java and CircularLinkedListClient.java
 */

package implementation;

public class CircularLinkedList {
	protected CLLNode tail;
	protected int length;

	// Constructs a new circular list
	public CircularLinkedList() {
		tail = null;
		length = 0;
	}

	@Override
	public String toString() {
		String result = "[";
		if (length == 0)
			return result + "]";
		CLLNode traverse = tail.getNext();
		while (traverse != tail) {
			result += traverse.getData() + ",";
			traverse = traverse.getNext();
		}
		result += tail.getData() + ",";
		return result.substring(0, result.length() - 1) + "]";
	}

	// INSERT Functions
	public void insertAtBeginning(CLLNode newNode) {
		if (length == 0) {
			tail = newNode;
			tail.setNext(tail);
		} else {
			newNode.setNext(tail.getNext());
			tail.setNext(newNode);
		}
		length++;
	}

	public void insertAtEnd(CLLNode newNode) {
		insertAtBeginning(newNode);
		tail = tail.getNext();
	}

	// DELETE functions
	public CLLNode removeFromBegin() {
		// zero item case
		if (length == 0)
			return null;
		// One item case
		if (tail.getNext() == tail) {
			tail = null;
			length--;
			return tail;
		}

		CLLNode nodeToRemove = tail.getNext();
		tail.setNext(nodeToRemove.getNext());
		nodeToRemove.setNext(null);
		length--;
		return nodeToRemove;
	}

	public CLLNode removeFromEnd() {
		if (length == 0)
			return null;
		if (length == 1) {
			tail = null;
			length--;
			return tail;
		}
		CLLNode traverse = tail;
		while (traverse.getNext() != tail)
			traverse = traverse.getNext();
		traverse.setNext(tail.getNext());
		tail = traverse;
		length--;
		return traverse;
	}

	public int remove(int data) {
		if (length == 0)
			return Integer.MIN_VALUE;
		CLLNode cur = tail.getNext(), prev = null;
		while (cur != tail) {
			prev = cur;
			cur = cur.getNext();
			if (cur.getData() == data)
				break;
		}
		if (cur.getData() == data) {
			if (tail == tail.getNext())
				tail = null;
			else {
				prev.setNext(cur.getNext());
				cur.setNext(null);
				if (cur == tail)
					tail = prev;
			}
			length--;
		} else {
			return Integer.MIN_VALUE;
		}
		return cur.getData();
	}

	public CLLNode getTail() {
		return tail;
	}

	public void setTail(CLLNode tail) {
		this.tail = tail;
	}

}
