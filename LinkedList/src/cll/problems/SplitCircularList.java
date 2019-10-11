/**
 * Write a program to split the circular linked list.
 */
package cll.problems;

import implementation.CLLNode;
import implementation.CircularLinkedList;

public class SplitCircularList {

	static CircularLinkedList cll = new CircularLinkedList();

	private static void splitCircular(CLLNode head, CLLNode head1, CLLNode head2) {
		CLLNode slowPtr = head;
		CLLNode fastPtr = head;
		while (fastPtr.getNext() != head && fastPtr.getNext().getNext() != null) {
			fastPtr = fastPtr.getNext().getNext();
			slowPtr = slowPtr.getNext();
		}
		if (fastPtr.getNext().getNext() == head)
			fastPtr = fastPtr.getNext();

		head2 = slowPtr.getNext();
		head1 = head;
		slowPtr.setNext(head1);
		fastPtr.setNext(head2);

		System.out.println("Printing First Half ");
		CLLNode temp1 = head1;
		while (temp1.getNext() != head1) {
			System.out.println(temp1.getData());
			temp1 = temp1.getNext();
		}
		System.out.println(temp1.getData());

		System.out.println("Printing Second Half ");
		temp1 = head2;
		while (temp1.getNext() != head2) {
			System.out.println(temp1.getData());
			temp1 = temp1.getNext();
		}
		System.out.println(temp1.getData());
	}

	public static void main(String[] args) {

		cll.insertAtBeginning(new CLLNode(5));
		cll.insertAtEnd(new CLLNode(6));
		cll.insertAtBeginning(new CLLNode(7));
		cll.insertAtBeginning(new CLLNode(11));
		cll.insertAtBeginning(new CLLNode(2));

		System.out.println(cll);
		CLLNode head1 = null;
		CLLNode head2 = null;
		splitCircular(cll.getTail().getNext(), head1, head2);

	}

}
