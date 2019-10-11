/**
 * Merge two LinkedList in sort
 * Lists before sorting...
		list 1 : [2,5,4,1]
		list 2 : [11,2,3,8,6,10]

 *	Lists After sorting...
		list 1 : [1,2,4,5]
		list 2 : [2,3,6,8,10,11]
		
 *	List After merging...
		1,2,2,3,4,5,6,8,10,11,
 * 
 */

package problems;

import implementation.LinkedList;
import implementation.ListNode;

public class MergeTwoListInSort {
	static LinkedList list1 = new LinkedList();
	static LinkedList list2 = new LinkedList();

	static LinkedList list3 = new LinkedList();
	static LinkedList list4 = new LinkedList();

	/**
	 * Sorting the list by replacing the data not by its links
	 * 
	 * @param head
	 */
	private static void selectionSort(ListNode head) {
		ListNode min;
		for (ListNode node1 = head; node1 != null; node1 = node1.getNext()) {
			min = node1;
			for (ListNode node2 = node1; node2 != null; node2 = node2.getNext()) {
				if (min.getData() > node2.getData())
					min = node2;
			}
			int temp = min.getData();
			min.setData(node1.getData());
			node1.setData(temp);
		}
	}

	// provided linked list should be sorted
	private static ListNode mergeInSortedOrder(ListNode traverse1, ListNode traverse2) {
		ListNode head = new ListNode(0);
		ListNode cur = head;
		while (traverse1 != null && traverse2 != null) {
			if (traverse1.getData() < traverse2.getData()) {
				cur.setNext(traverse1);
				traverse1 = traverse1.getNext();
			} else {
				cur.setNext(traverse2);
				traverse2 = traverse2.getNext();
			}
			cur = cur.getNext();
		}
		if (traverse1 != null)
			cur.setNext(traverse1);
		else if (traverse2 != null)
			cur.setNext(traverse2);
		return head.getNext();
	}

	// provided linked list should be sorted
	private static ListNode mergeInSortedOrderUsingRecursion(ListNode head1, ListNode head2) {
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;
		ListNode head = new ListNode(0);
		if (head1.getData() <= head2.getData()) {
			head = head1;
			head.setNext(mergeInSortedOrderUsingRecursion(head1.getNext(), head2));
		} else {
			head = head2;
			head.setNext(mergeInSortedOrderUsingRecursion(head1, head2.getNext()));
		}
		return head;
	}

	public static void main(String[] args) {

		list1.insertAtBeginning(new ListNode(1));
		list1.insertAtBeginning(new ListNode(4));
		list1.insertAtBeginning(new ListNode(5));
		list1.insertAtBeginning(new ListNode(2));

		list2.insertAtBeginning(new ListNode(10));
		list2.insertAtBeginning(new ListNode(6));
		list2.insertAtBeginning(new ListNode(8));
		list2.insertAtBeginning(new ListNode(3));
		list2.insertAtBeginning(new ListNode(2));
		list2.insertAtBeginning(new ListNode(11));

		System.out.println("Lists before sorting...");
		System.out.println("list 1 : " + list1);
		System.out.println("list 2 : " + list2);

		selectionSort(list1.getHead());
		selectionSort(list2.getHead());

		System.out.println();
		System.out.println("Lists After sorting...");
		System.out.println("list 1 : " + list1);
		System.out.println("list 2 : " + list2);

		ListNode newHead = mergeInSortedOrder(list1.getHead(), list2.getHead());
		System.out.println("\nList After merging...");
		while (newHead != null) {
			System.out.print(newHead + ",");
			newHead = newHead.getNext();
		}

		list3.insertAtBeginning(new ListNode(5));
		list3.insertAtBeginning(new ListNode(4));

		list4.insertAtBeginning(new ListNode(7));
		list4.insertAtBeginning(new ListNode(3));
		list4.insertAtBeginning(new ListNode(1));

		System.out.println("\n\nLists after sorting...");
		System.out.println("list 3 : " + list3);
		System.out.println("list 4 : " + list4);

		System.out.println("\nList After merging...");
		ListNode newHeadUsingRecursion = mergeInSortedOrderUsingRecursion(list3.getHead(), list4.getHead());
		while (newHeadUsingRecursion != null) {
			System.out.print(newHeadUsingRecursion + ",");
			newHeadUsingRecursion = newHeadUsingRecursion.getNext();
		}
	}

}
