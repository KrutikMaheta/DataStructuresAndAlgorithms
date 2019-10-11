/**
 * Program to check if the given LinkedList is palindrome
 */

/**
 * 1. Get the middle of the linkedlist.
 * 2. If the list size is odd than fast pointer will be not null; in that case increment the slowptr to its next to get the head of 
 * 	  second half.
 * 3. Set the previous to slowptr to null.
 * 4. Reverse the second half of the list.
 * 5. Compare first and second half of the list and make a decision for the palindrome.
 * 
 */

package problems;

import implementation.LinkedList;
import implementation.ListNode;

public class PalindromCheck {

	static LinkedList list = new LinkedList();

	private static boolean isPalindrome(ListNode head) {
		ListNode slowPtr = head;
		ListNode fastPtr = head;
		ListNode prevToSlow = slowPtr;
		while (fastPtr != null && fastPtr.getNext() != null) {
			prevToSlow = slowPtr;
			slowPtr = slowPtr.getNext();
			fastPtr = fastPtr.getNext().getNext();
		}
		if (fastPtr != null) {
			slowPtr = slowPtr.getNext();
		}
		prevToSlow.setNext(null);
		ListNode head2 = reverse2ndHalf(slowPtr);
		return compareLists(head, head2);

	}

	private static boolean compareLists(ListNode head, ListNode head2) {
		while (head != null && head2 != null) {
			if (head.getData() != head2.getData())
				return false;

			head = head.getNext();
			head2 = head2.getNext();

		}
		if (head == null && head2 == null)
			return true;
		return false;
	}

	private static ListNode reverse2ndHalf(ListNode slowPtr) {
		ListNode cur = slowPtr, prev = null;
		while (cur != null) {
			ListNode next = cur.getNext();
			cur.setNext(prev);
			prev = cur;
			cur = next;
		}
		return prev;
	}

	public static void main(String[] args) {
		list.insertAtBeginning(new ListNode(5));
		list.insertAtBeginning(new ListNode(4));
		list.insertAtBeginning(new ListNode(3));
		list.insertAtBeginning(new ListNode(4));
		list.insertAtBeginning(new ListNode(5));
		// list.insertAtBeginning(new ListNode(5));
		System.out.println(list);

		System.out.println("Is Palindrome : " + isPalindrome(list.getHead()));

	}

}
