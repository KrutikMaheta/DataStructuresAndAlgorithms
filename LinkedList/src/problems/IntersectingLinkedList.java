package problems;

import basic.LinkedList;
import basic.ListNode;

public class IntersectingLinkedList {

	static LinkedList list1 = new LinkedList();
	static LinkedList list2 = new LinkedList();

	/**
	 * Algorithm:
	 * 	1.	Find length of both the list (O(n) + O(m))
	 * 	2.	Take difference d of length	O(1)
	 * 	3.	Make d steps in the longer list	O(d)
	 * 	4.	Traverse both the list until the next node match found (O(m) + O(n))
	 * 
	 */
	
	// Time Complexity : O(max(m,n))
	// Space Complexity : O(1)
	private static ListNode findIntersectingNode() {
		int l1 = 0, l2 = 0, diff = 0;
		ListNode traverse1 = list1.getHead();
		ListNode traverse2 = list2.getHead();
		while (traverse1 != null) {
			l1++;
			traverse1 = traverse1.getNext();
		}
		while (traverse2 != null) {
			l2++;
			traverse2 = traverse2.getNext();
		}
		if (l1 > l2) {
			traverse1 = list1.getHead();
			traverse2 = list2.getHead();
			diff = l1 - l2;
		} else {
			traverse1 = list2.getHead();
			traverse2 = list1.getHead();
			diff = l2 - l1;
		}
		for (int i = 0; i < diff; i++)
			traverse1 = traverse1.getNext();
		while (traverse1 != null && traverse2 != null) {
			if (traverse1.equals(traverse2))
				return traverse1;
			traverse1 = traverse1.getNext();
			traverse2 = traverse2.getNext();
		}
		return null;
	}

	public static void main(String[] args) {
		ListNode newNode1 = new ListNode(10);
		ListNode newNode2 = new ListNode(11);
		ListNode newNode3 = new ListNode(12);
		ListNode newNode4 = new ListNode(13);

		list1.insertAtBeginning(new ListNode(3));
		list1.insertAtBeginning(new ListNode(4));
		list1.insertAtBeginning(new ListNode(7));
		list1.insertAtBeginning(new ListNode(8));
		list1.insertAtEnd(newNode1);
		list1.insertAtEnd(newNode2);
		list1.insertAtEnd(newNode3);
		list1.insertAtEnd(newNode4);

		list2.insertAtEnd(new ListNode(5));
		list2.insertAtEnd(new ListNode(1));
		list2.insertAtBeginning(new ListNode(4));
		list2.insertAtBeginning(new ListNode(7));
		list2.insertAtBeginning(new ListNode(8));

		list2.insertAtEnd(newNode1);
		list2.insertAtEnd(newNode2);
		list2.insertAtEnd(newNode3);
		list2.insertAtEnd(newNode4);

		ListNode intersectingNode = findIntersectingNode();
		if (intersectingNode != null)
			System.out.println("Intersecting point in both is : " + intersectingNode);
		else
			System.out.println("Not intersecting");
		System.out.println("list 1 : " + list1);
		System.out.println("list 2 : " + list2);

	}

}
