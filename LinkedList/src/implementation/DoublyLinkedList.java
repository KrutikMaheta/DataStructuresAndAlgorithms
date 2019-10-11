/**
 * Implementation of Doubly LinkedList
 * Supporting Files: DLLNode.java and DoublyLinkedListClient.java
 */

package implementation;

public class DoublyLinkedList {
	private DLLNode head;
	private int length;

	DoublyLinkedList() {
		length = 0;
	}

	int getLength() {
		return length;
	}

	@Override
	public String toString() {
		String result = "[";
		if (head == null)
			return result + "]";
		DLLNode traverse = head;
		while (traverse != null) {
			result += traverse.getData() + ",";
			traverse = traverse.getNext();
		}
		return result.substring(0, result.length() - 1) + "]";
	}

	// INSERT Functions
	public void insertAtBeginning(DLLNode newNode) {
		newNode.setPrev(null);
		newNode.setNext(head);
		if (head != null)
			head.setPrev(newNode);
		head = newNode;
		length++;
	}

	public void insertAtEnd(DLLNode newNode) {
		if (head == null) {
			head = newNode;
			length++;
		} else {
			DLLNode traverse = head;
			while (traverse.getNext() != null)
				traverse = traverse.getNext();
			newNode.setNext(null);
			newNode.setPrev(traverse);
			traverse.setNext(newNode);
			length++;
		}
	}

	public void insert(DLLNode newNode, int position) {
		if (position < 0)
			position = 0;
		if (position > length)
			position = length;
		if (head == null) {
			head = newNode;
		}
		// Inserting at the head case
		else if (position == 0) {
			newNode.setPrev(null);
			newNode.setNext(head);
			if (head != null)
				head.setPrev(newNode);
			head = newNode;

		} else {
			DLLNode traverse = head;
			for (int i = 1; i < position; i++)
				traverse = traverse.getNext();
			newNode.setNext(traverse.getNext());
			newNode.setPrev(traverse);
			// inserting at the end case
			if (traverse.getNext() != null)
				traverse.getNext().setPrev(newNode);
			traverse.setNext(newNode);
		}
		length++;
	}

	// DELETE functions
	public DLLNode removeFromBegin() {
		if (length == 0)
			return null;
		DLLNode temp = head;
		if (temp.getNext() != null) {
			temp.getNext().setPrev(null);
			head = temp.getNext();
		}
		// Single element case
		else
			head = null;
		length--;
		return temp;
	}

	public DLLNode removeFromEnd() {
		if (length == 0)
			return null;
		DLLNode traverse = head;
		while (traverse.getNext() != null)
			traverse = traverse.getNext();
		if (traverse.getPrev() != null)
			traverse.getPrev().setNext(null);
		else
			head = null;
		length--;
		return traverse;
	}

	public void remove(int position) {
		if (position < 0)
			position = 0;
		if (position >= length)
			position = length - 1;
		if (length == 0)
			return;
		if (position == 0) {
			DLLNode temp = head;
			if (temp.getNext() != null) {
				temp.getNext().setPrev(null);
				head = temp.getNext();
			}
			// Single element case
			else
				head = null;
			length--;
		} else {
			DLLNode traverse = head;
			for (int i = 0; i < position; i++)
				traverse = traverse.getNext();
			if (traverse.getNext() != null)
				traverse.getNext().setPrev(traverse.getPrev());
			else
				traverse.setNext(null);
			traverse.getPrev().setNext(traverse.getNext());
			length--;
		}
	}

	public void removeMatched(DLLNode node) {
		if (head == null)
			return;
		if (head.equals(node))
			if (head.getNext() == null)
				head = null;
			else
				head = head.getNext();
		else {
			DLLNode traverse = head;
			while (traverse != null) {
				if (traverse.equals(node)) {
					// last element case
					if (traverse.getNext() != null)
						traverse.getNext().setPrev(traverse.getPrev());
					traverse.getPrev().setNext(traverse.getNext());
				}
				traverse = traverse.getNext();
			}
		}
		length--;
	}

	public void clearList() {
		length = 0;
		head = null;
	}
}
