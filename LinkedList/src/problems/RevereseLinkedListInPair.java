/**
 * Write a program to reverse the linkedlist in pair of 2
 * Before : [2,3,8,6,10]
 * After  : [3,2,6,8,10]
 */

package problems;

import implementation.LinkedList;
import implementation.ListNode;

public class RevereseLinkedListInPair {

	static LinkedList list = new LinkedList();

	private static void reverseInPair(ListNode head) {
		if (head == null || head.getNext() == null)
			return;
		ListNode cur = head.getNext();
		ListNode prev = head;
		list.setHead(cur);
		while (true) {
			ListNode next = cur.getNext();
			cur.setNext(prev);
			if (next == null || next.getNext() == null) {
				prev.setNext(next);
				break;
			}
			prev.setNext(next.getNext());
			prev = next;
			cur = prev.getNext();
		}
		return;
	}

	private static ListNode reverseInPairUsingRecursion(ListNode node) {
		// Base Case: The list is empty or has only one node
		if (node == null || node.getNext() == null)
			return node;
		if (node.equals(list.getHead()))
			list.setHead(node.getNext());

		ListNode cur = node.getNext();
		ListNode prev = node;
		ListNode next = cur.getNext();
		cur.setNext(prev);
		prev.setNext(reverseInPairUsingRecursion(next));
		return cur;

	}

	public static void main(String[] args) {
		list.insertAtBeginning(new ListNode(10));
		list.insertAtBeginning(new ListNode(6));
		list.insertAtBeginning(new ListNode(8));
		list.insertAtBeginning(new ListNode(3));
		list.insertAtBeginning(new ListNode(2));
		// list.insertAtBeginning(new ListNode(11));

		System.out.println(list);
		System.out.println("After reversing in pair: ");
		reverseInPair(list.getHead());
		System.out.println(list);

		reverseInPairUsingRecursion(list.getHead());
		System.out.println(list);
		// reverseInPairUsingRecursion(list.getHead());
	}

}
