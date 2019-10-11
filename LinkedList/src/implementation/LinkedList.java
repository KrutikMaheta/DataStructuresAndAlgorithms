/**
 * Implementation of Doubly LinkedList
 * Supporting Files: ListNode.java and LinkedListClient.java
 */

package implementation;

public class LinkedList {
	private int length;
	ListNode head;

	public LinkedList() {
		length = 0;
	}

	public ListNode getHead() {
		return head;
	}

	public void setHead(ListNode head) {
		this.head = head;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int val) {
		length += val;
	}

	// Return the string representation of collection
	@Override
	public String toString() {
		String result = "[";
		if (head == null)
			return result + "]";
		ListNode traverse = head;
		while (traverse != null) {
			result += traverse.getData() + ",";
			traverse = traverse.getNext();
		}
		return result.substring(0, result.length() - 1) + "]";
	}

	/**
	 * INSERT functions
	 */
	public void insertAtBeginning(ListNode newNode) {
		newNode.setNext(head);
		head = newNode;
		length++;
	}

	public void insertAtEnd(ListNode newNode) {
		if (head == null) {
			head = newNode;
			newNode.setNext(null);
			return;
		}
		ListNode traverseNode = head;
		while (traverseNode.getNext() != null)
			traverseNode = traverseNode.getNext();
		traverseNode.setNext(newNode);
		newNode.setNext(null);
		length++;
	}

	public void insert(ListNode newNode, int position) {
		if (position < 0)
			position = 0;
		else if (position > length)
			position = length;
		if (head == null)
			head = newNode;
		else if (position == 0) {
			// insert at the beginning
			newNode.setNext(head);
			head = newNode;
		} else {
			ListNode traverse = head;
			for (int i = 1; i < position; i++) {
				traverse = traverse.getNext();
			}
			newNode.setNext(traverse.getNext());
			traverse.setNext(newNode);
		}
		length++;
	}

	/**
	 * Remove Functions
	 * 
	 * @return
	 */
	public ListNode removeFromBegin() {
		ListNode traverse = head;
		if (traverse != null) {
			head = head.getNext();
			traverse.setNext(null);
		}
		length--;
		return traverse;
	}

	public ListNode removeFromEnd() {
		if (head == null)
			return null;
		ListNode cur = head, prev = null;

		if (cur.getNext() == null) {
			head = null;
			return cur;
		}

		while (cur.getNext() != null) {
			prev = cur;
			cur = cur.getNext();
		}
		prev.setNext(null);
		length--;
		return cur;
	}

	public void removeFromMatched(ListNode node) {
		if (head == null)
			return;
		if (node.equals(head)) {
			head = head.getNext();
			return;
		}
		ListNode cur = head, prev = null;
		while (cur.getNext() != null) {
			prev = cur;
			cur = cur.getNext();
			if (cur.equals(node)) {
				prev.setNext(cur.getNext());
				length--;
				return;
			}
		}
		length--;
	}

	public void remove(int position) {
		if (position < 0)
			position = 0;
		else if (position > length)
			position = length - 1;
		if (head == null)
			return;
		if (position == 0)
			head = head.getNext();
		else {
			ListNode cur = head;
			for (int i = 1; i < position; i++)
				cur = cur.getNext();
			cur.setNext(cur.getNext().getNext());
		}
		length -= 1;
	}

	// Retrieve position
	public int getPosition(int n) {
		ListNode traverse = head;
		int position = 0;
		while (traverse != null) {
			if (traverse.getData() == n)
				return position;
			position++;
			traverse = traverse.getNext();
		}
		return Integer.MAX_VALUE;

	}

}
