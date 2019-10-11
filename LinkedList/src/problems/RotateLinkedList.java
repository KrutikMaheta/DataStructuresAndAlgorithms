/**
 * Write a program to rotate the linkedlist.
 */

package problems;

import implementation.LinkedList;
import implementation.ListNode;

public class RotateLinkedList {

	static LinkedList list = new LinkedList();

	private static void rotateRight(ListNode head, int count) {
		ListNode fast = head;
		ListNode slow = head;
		while (count-- > 0) {
			fast = fast.getNext();
		}
		while (fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext();
		}
		fast.setNext(list.getHead());
		list.setHead(slow.getNext());
		slow.setNext(null);
	}

	public static void main(String[] args) {
		// list.insertAtBeginning(new ListNode(7));
		// list.insertAtBeginning(new ListNode(6));
		list.insertAtBeginning(new ListNode(5));
		list.insertAtBeginning(new ListNode(4));
		list.insertAtBeginning(new ListNode(3));
		list.insertAtBeginning(new ListNode(2));
		list.insertAtBeginning(new ListNode(1));
		System.out.println(list);
		rotateRight(list.getHead(), 2);
		System.out.println(list);
	}

}
