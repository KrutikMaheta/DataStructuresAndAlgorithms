/**
 * Write a program to reverse the linkedlist
 */

package problems;

import implementation.LinkedList;
import implementation.ListNode;

public class ReverseLinkedList {
	static LinkedList list = new LinkedList();

	// Time Complexity : O(n)
	// Space Complexity : O(1)
	private static void reverseLinkedList() {
		ListNode cur = list.getHead(), prev = null, next = null;
		while (cur != null) {
			next = cur.getNext();
			cur.setNext(prev);
			prev = cur;
			cur = next;
		}
		list.setHead(prev);
	}

	private static void reverseLinkedListUsingRecursion(ListNode cur, ListNode prev) {
		if (cur.getNext() == null) {
			list.setHead(cur);
			cur.setNext(prev);
			return;
		}
		ListNode next = cur.getNext();
		cur.setNext(prev);
		reverseLinkedListUsingRecursion(next, cur);
		return;
	}

	public static void main(String[] args) {
		list.insertAtBeginning(new ListNode(3));
		list.insertAtBeginning(new ListNode(4));
		list.insertAtEnd(new ListNode(5));
		list.insertAtEnd(new ListNode(1));
		ListNode newNode1 = new ListNode(10);
		list.insertAtEnd(newNode1);
		System.out.println(list);
		reverseLinkedList();
		System.out.println("After reversing the Linkedlist : ");
		System.out.println(list);
		System.out.println("After reversing using recursion the Linkedlist is : ");
		reverseLinkedListUsingRecursion(list.getHead(), null);
		System.out.println(list);
	}

}
