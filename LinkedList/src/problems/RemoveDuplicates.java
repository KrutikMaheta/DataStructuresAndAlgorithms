/**
 * Write a program to remove the duplicates from the given LinkedList.
 */

package problems;

import java.util.HashSet;

import implementation.LinkedList;
import implementation.ListNode;

public class RemoveDuplicates {
	static LinkedList list1 = new LinkedList();

	private static void removeDuplicates(ListNode node) {
		ListNode cur = node;
		ListNode prev = null;
		HashSet<Integer> hashset = new HashSet<>();
		while (cur != null) {
			if (hashset.add(cur.getData())) {
				prev = cur;
				cur = cur.getNext();
			} else {
				prev.setNext(cur.getNext());
				cur = cur.getNext();
			}

		}

	}

	public static void main(String[] args) {
		list1.insertAtBeginning(new ListNode(1));
		list1.insertAtBeginning(new ListNode(2));
		list1.insertAtBeginning(new ListNode(3));
		list1.insertAtBeginning(new ListNode(4));
		list1.insertAtBeginning(new ListNode(5));
		list1.insertAtBeginning(new ListNode(1));

		System.out.println(list1);
		removeDuplicates(list1.getHead());
		System.out.println(list1);
	}

}
