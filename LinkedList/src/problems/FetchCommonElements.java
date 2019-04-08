/**
 * Creating new linkedlist from the common elements of the 2 sorted linkedlist
 * 
 * Input:
 * [1,2,3,5,5,11]
 * [1,3,4,5,5,5]
 * 
 * Output:
 * [1,3,5,5]
 * 
 */
package problems;

import basic.LinkedList;
import basic.ListNode;

public class FetchCommonElements {

	static LinkedList list1 = new LinkedList();
	static LinkedList list2 = new LinkedList();
	static LinkedList resList = new LinkedList();

	private static ListNode commonElements(ListNode node1, ListNode node2) {
		ListNode newHead = new ListNode(0);
		ListNode cur = newHead;
		while (node1 != null && node2 != null) {
			if (node1.getData() == node2.getData()) {
				cur.setNext(new ListNode(node1.getData()));
				cur = cur.getNext();
				node1 = node1.getNext();
				node2 = node2.getNext();
			} else if (node1.getData() > node2.getData())
				node2 = node2.getNext();
			else
				node1 = node1.getNext();
		}
		return newHead.getNext();
	}

	public static void main(String[] args) {
		list1.insertAtBeginning(new ListNode(11));
		list1.insertAtBeginning(new ListNode(5));
		list1.insertAtBeginning(new ListNode(5));
		list1.insertAtBeginning(new ListNode(3));
		list1.insertAtBeginning(new ListNode(2));
		list1.insertAtBeginning(new ListNode(1));

		list2.insertAtBeginning(new ListNode(5));
		list2.insertAtBeginning(new ListNode(5));
		list2.insertAtBeginning(new ListNode(5));
		list2.insertAtBeginning(new ListNode(4));
		list2.insertAtBeginning(new ListNode(3));
		list2.insertAtBeginning(new ListNode(1));

		System.out.println(list1);
		System.out.println(list2);
		resList.setHead(commonElements(list1.getHead(), list2.getHead()));
		System.out.println(resList);
	}

}
