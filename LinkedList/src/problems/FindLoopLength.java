/**
 * Write a program to check if the loop exists in the given LinkedList
 * if exists then calculate its length.
 */
package problems;

import implementation.LinkedList;
import implementation.ListNode;

public class FindLoopLength {
	static LinkedList list = new LinkedList();

	// Time Complexity : O(n)
	// Space Complexity : O(1)
	private static int findLoopLength() {
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
		int length = 0;
		if (loopExists) {
			do {
				length++;
				slowPtr = slowPtr.getNext();
			} while (slowPtr != fastPtr);
		}
		return length;
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
		newNode1.setNext(newNode);
		// newNode1.setNext(list.getHead());

		System.out.println("loop length is : " + findLoopLength());
	}

}
