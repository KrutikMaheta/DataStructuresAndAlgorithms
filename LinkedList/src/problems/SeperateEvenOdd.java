/**
 * Write a program to separate out the even and odd elements of the Linkedlist.
 * 
 * Input:
 * [0,1,2,3,5,6,6,5,4,3,2,1]
 * 
 * Output:
 * [0,2,6,6,4,2,1,3,5,5,3,1]
 * 
 */

package problems;

import implementation.LinkedList;
import implementation.ListNode;

public class SeperateEvenOdd {
	static LinkedList list1 = new LinkedList();
	static LinkedList list2 = new LinkedList();

	private static ListNode seperateEvenOdd(ListNode node) {
		ListNode oddHead = null;
		ListNode oddCur = null;
		ListNode traverse = node;
		while (traverse != null) {
			if (traverse.getData() % 2 != 0) {
				if (oddHead == null) {
					oddHead = new ListNode(traverse.getData());
					oddCur = oddHead;
				} else {
					oddCur.setNext(new ListNode(traverse.getData()));
					oddCur = oddCur.getNext();
				}
			}
			traverse = traverse.getNext();
		}
		ListNode newHead = new ListNode(0);
		ListNode newCur = newHead;
		traverse = node;

		while (traverse != null) {
			if (traverse.getData() % 2 == 0) {
				newCur.setNext(new ListNode(traverse.getData()));
				newCur = newCur.getNext();
			}
			traverse = traverse.getNext();
		}
		while (oddHead != null) {
			newCur.setNext(new ListNode(oddHead.getData()));
			newCur = newCur.getNext();
			oddHead = oddHead.getNext();
		}

		return newHead.getNext();
	}

	public static void main(String[] args) {
		list1.insertAtBeginning(new ListNode(1));
		list1.insertAtBeginning(new ListNode(2));
		list1.insertAtBeginning(new ListNode(3));
		list1.insertAtBeginning(new ListNode(4));
		list1.insertAtBeginning(new ListNode(5));
		list1.insertAtBeginning(new ListNode(6));
		list1.insertAtBeginning(new ListNode(6));
		list1.insertAtBeginning(new ListNode(5));
		list1.insertAtBeginning(new ListNode(3));
		list1.insertAtBeginning(new ListNode(2));
		list1.insertAtBeginning(new ListNode(1));
		list1.insertAtBeginning(new ListNode(0));

		System.out.println(list1);
		list2.setHead(seperateEvenOdd(list1.getHead()));
		System.out.println(list2);
	}

}
