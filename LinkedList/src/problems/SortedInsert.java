/**
 * Write a linkedlist's insert() function which inserts the element in the sorted order.
 */
package problems;

import implementation.LinkedList;
import implementation.ListNode;

public class SortedInsert {

	static LinkedList list = new LinkedList();

	// Time Complexity : O(n)
	// Space Complexity : O(1)
	public static void insertInSortedOrder(ListNode newNode) {
		// Empty list case
		if (list.getHead() == null)
			list.setHead(newNode);
		else {
			ListNode cur = list.getHead(), prev = null;
			while (cur != null && cur.getData() < newNode.getData()) {
				prev = cur;
				cur = cur.getNext();
			}
			// Adding at head position
			if (cur == list.getHead()) {
				newNode.setNext(cur);
				list.setHead(newNode);
			} else {
				prev.setNext(newNode);
				newNode.setNext(cur);
			}
		}

		list.setLength(list.getLength() + 1);
	}

	public static void main(String[] args) {
		insertInSortedOrder(new ListNode(3));
		insertInSortedOrder(new ListNode(2));
		insertInSortedOrder(new ListNode(5));
		insertInSortedOrder(new ListNode(50));
		insertInSortedOrder(new ListNode(4));
		insertInSortedOrder(new ListNode(1));
		System.out.println(list);
	}

}
