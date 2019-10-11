/**
 * Write a program to reverse the elements in the linked list in blocks of passed integer.
 * 
 * Before : [1,2,3,4,5,6]
 * After  : [3,2,1,6,5,4]
 */

package problems;

import implementation.LinkedList;
import implementation.ListNode;

public class ReverseInBlocks {
	static LinkedList list = new LinkedList();

	private static void reverseInBlocks(ListNode head, int k) {
		ListNode cur = head;
		boolean isHeadSet = false;
		ListNode prevCurrent = head;
		ListNode prevTail = null;
		while (cur != null) {
			int count = k;
			ListNode prev = null;

			while (cur != null && count > 0) {
				ListNode next = cur.getNext();
				cur.setNext(prev);
				prev = cur;
				cur = next;
				count--;
			}
			if (!isHeadSet) {
				list.setHead(prev);
				isHeadSet = true;
			} else {
				prevTail.setNext(prev);
			}
			prevTail = prevCurrent;
			prevCurrent = cur;

		}
	}

	private static ListNode reverseInBlocksRecursive(ListNode head, int k) {
		ListNode cur = head;
		ListNode prev = null;
		ListNode next = null;
		int count = k;
		while (cur != null & count > 0) {
			next = cur.getNext();
			cur.setNext(prev);
			prev = cur;
			cur = next;
			count--;
		}
		if (next != null) {
			head.setNext(reverseInBlocksRecursive(next, k));
		}
		return prev;
	}

	public static void main(String[] args) {
		list.insertAtBeginning(new ListNode(6));
		list.insertAtBeginning(new ListNode(5));
		list.insertAtBeginning(new ListNode(4));
		list.insertAtBeginning(new ListNode(3));
		list.insertAtBeginning(new ListNode(2));
		list.insertAtBeginning(new ListNode(1));

		System.out.println(list);
		/*
		 * reverseInBlocks(list.getHead(), 4); System.out.println(list);
		 */

		ListNode newNode = reverseInBlocksRecursive(list.getHead(), 3);
		while (newNode != null) {
			System.out.print(newNode.getData() + ",");
			newNode = newNode.getNext();
		}
		// System.out.println(list);
	}

}
