/**
 * Rearrange the elements in the Linked list as below example:
 * 
 * Before : [1,2,3,4,5,6,7]
 * After  :  [1,7,2,6,3,5,4]
 */

package problems;

import implementation.LinkedList;
import implementation.ListNode;

public class ReorderLinkedList {

	static LinkedList list = new LinkedList();

	private static void reorderTheList(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		ListNode head2 = null;
		while (fast != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		head2 = slow.getNext();
		slow.setNext(null);
		head2 = reverseList(head2);
		alternate(head, head2);
	}

	private static void alternate(ListNode head, ListNode head2) {
		ListNode newHead = new ListNode(0);
		ListNode newTranverse = newHead;
		boolean isNextList = false;
		while (head != null & head2 != null) {
			if (!isNextList) {
				newTranverse.setNext(head);
				head = head.getNext();
				isNextList = true;
				newTranverse = newTranverse.getNext();
			} else {
				newTranverse.setNext(head2);
				head2 = head2.getNext();
				isNextList = false;
				newTranverse = newTranverse.getNext();
			}
		}
		if (head != null)
			newTranverse.setNext(head);
		list.setHead(newHead.getNext());
		return;
	}

	private static ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode cur = head;
		while (cur != null) {
			ListNode next = cur.getNext();
			cur.setNext(prev);
			prev = cur;
			cur = next;
		}
		return prev;
	}

	public static void main(String[] args) {
		list.insertAtBeginning(new ListNode(7));
		list.insertAtBeginning(new ListNode(6));
		list.insertAtBeginning(new ListNode(5));
		list.insertAtBeginning(new ListNode(4));
		list.insertAtBeginning(new ListNode(3));
		list.insertAtBeginning(new ListNode(2));
		list.insertAtBeginning(new ListNode(1));

		System.out.println(list);
		reorderTheList(list.getHead());
		System.out.println(list);
	}

}
