/**
 * Input:
 * LinkedList1 = [9,9,9]
 * LinkedList2 = [9,9,9,9]
 * 
 * Output:
 * FinalList = [8,9,9,0,1]
 * 
 */

package problems;

import implementation.LinkedList;
import implementation.ListNode;

public class AdditionOfLinkedList {
	static LinkedList list1 = new LinkedList();
	static LinkedList list2 = new LinkedList();
	static LinkedList list3 = new LinkedList();

	private static ListNode addTwoLinkedList(ListNode node1, ListNode node2) {
		if (node1 == null)
			return node2;
		if (node2 == null)
			return node1;
		ListNode resHead = new ListNode(0);
		ListNode cur = resHead;
		int sum = 0;
		int advance = 0;
		while (node1 != null && node2 != null) {
			sum = node1.getData() + node2.getData() + advance;
			advance = sum / 10;
			sum = sum % 10;
			cur.setNext(new ListNode(sum));
			cur = cur.getNext();
			node1 = node1.getNext();
			node2 = node2.getNext();
		}
		if (node1 != null) {
			if (advance != 0)
				cur.setNext(addTwoLinkedList(node1, new ListNode(advance)));
			else
				cur.setNext(node1);
		} else if (node2 != null) {
			if (advance != 0)
				cur.setNext(addTwoLinkedList(node2, new ListNode(advance)));
			else
				cur.setNext(node2);
		} else if (advance != 0) {
			cur.setNext(new ListNode(advance));
		}

		return resHead.getNext();
	}

	public static void main(String[] args) {
		list1.insertAtBeginning(new ListNode(9));
		list1.insertAtBeginning(new ListNode(9));
		list1.insertAtBeginning(new ListNode(9));

		System.out.println(list1);

		list2.insertAtBeginning(new ListNode(9));
		list2.insertAtBeginning(new ListNode(9));
		list2.insertAtBeginning(new ListNode(9));
		list2.insertAtBeginning(new ListNode(9));

		System.out.println(list2);

		ListNode resHead = addTwoLinkedList(list1.getHead(), list2.getHead());
		list3.setHead(resHead);

		System.out.println(list3);

	}

}
