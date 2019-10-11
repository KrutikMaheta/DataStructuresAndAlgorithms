/**
 * Algorithm:
 * 
 * 1. Once we found out that loop exists, we can initialize slow pointer to head of the list.
 * 2. After that we will move slow and fast pointer one move at a time.
 * 3. The point at which they met is the start of the loop.
 * 
 */

package problems;

import implementation.LinkedList;
import implementation.ListNode;

public class FindBeginOfLoop {

	static LinkedList list = new LinkedList();

	// Time Complexity : O(n)
	// Space Complexity : O(1)
	private static ListNode findBeginOfLoop() {
		ListNode slowPtr = list.getHead();
		ListNode fastPtr = list.getHead();
		boolean loopExists = false;
		while (fastPtr != null && fastPtr.getNext() != null) {
			slowPtr = slowPtr.getNext();
			fastPtr = fastPtr.getNext().getNext();
			if (slowPtr == fastPtr) {
				loopExists = true;
				break;
			}
		}
		if (loopExists) {
			slowPtr = list.getHead();
			while (slowPtr != fastPtr) {
				slowPtr = slowPtr.getNext();
				fastPtr = fastPtr.getNext();
			}
			return fastPtr;
		} else
			return null;
	}

	public static void main(String[] args) {
		list.insertAtBeginning(new ListNode(3));
		list.insertAtBeginning(new ListNode(4));
		list.insertAtEnd(new ListNode(5));
		list.insertAtEnd(new ListNode(1));
		ListNode newNode1 = new ListNode(10);
		ListNode newNode = new ListNode(7);
		list.insertAtEnd(newNode1);
		list.insert(newNode, 2);
		// Below code will create loop in the linked list
		// newNode1.setNext(newNode);
		newNode1.setNext(list.getHead());

		System.out.println("loop exists at : " + findBeginOfLoop());
	}

}
