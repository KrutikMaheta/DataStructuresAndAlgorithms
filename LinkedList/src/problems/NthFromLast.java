/**
 * Algorithm: Finding the nth node from the last:
 * 
 * 1. Take 2 pointers ; slow & fast
 * 2. Initially both will point to the head.
 * 3. slow will start moving only after fast has made n moves.
 * 4. From there both move forward until fast reaches the end of the list.
 * 5. As a result slow will points to nth node from the last.
 * 
 */

package problems;

import java.util.HashMap;

import implementation.LinkedList;
import implementation.ListNode;

public class NthFromLast {

	static LinkedList list = new LinkedList();
	static int counter;

	// With HASHTABLE
	// timeComplexity : time for creating the hash table
	// Space complexity : O(m) ; since needs to created the hash table of size m
	public static ListNode findNthFromLastMethod1(int pos) {
		HashMap<Integer, Integer> map = new HashMap<>();
		ListNode temp = list.getHead();
		int len = 0;
		int index = 0;
		while (temp != null) {
			map.put(index++, temp.getData());
			temp = temp.getNext();
			len++;
		}
		int data = map.get(len - pos);
		return new ListNode(data);
	}

	// Method 2
	// timeComplexity : O(n) + O(n) = O(n)
	// Space complexity : O(1)
	public static ListNode findNthFromLastMethod2(int pos) {
		ListNode temp = list.getHead();
		int len = 0;
		while (temp != null) {
			temp = temp.getNext();
			len++;
		}
		temp = list.getHead();
		for (int i = 0; i < len - pos; i++)
			temp = temp.getNext();
		return new ListNode(temp.getData());
	}

	// Method 3: Efficient approach
	// timeComplexity : O(n)
	// Space complexity : O(1)
	private static ListNode findNthFromLastMethod3(int pos) {
		ListNode p = list.getHead(), q = list.getHead();
		for (int i = 0; i < pos; i++)
			p = p.getNext();
		while (p != null) {
			p = p.getNext();
			q = q.getNext();
		}
		return q;
	}

	// Method 4: Using recursion
	// timeComplexity : O(2n)
	// Space complexity : O(n)
	static ListNode nthFromLast = null;

	private static void findNthFromLastMethod4(ListNode head, int pos) {
		if (head != null) {
			findNthFromLastMethod4(head.getNext(), pos);
			counter++;
			if (counter == pos)
				nthFromLast = head;
		}
		return;
	}

	public static void main(String[] args) {

		list.insertAtBeginning(new ListNode(3));
		list.insertAtBeginning(new ListNode(4));
		list.insertAtEnd(new ListNode(5));
		list.insertAtEnd(new ListNode(1));
		ListNode newNode = new ListNode(7);
		list.insertAtEnd(new ListNode(10));
		list.insert(newNode, 2);

		System.out.println(list);
		System.out.println("last 2nd from list : " + NthFromLast.findNthFromLastMethod1(2));
		System.out.println("last 4th from list : " + NthFromLast.findNthFromLastMethod2(4));
		System.out.println("last 3rd from list : " + NthFromLast.findNthFromLastMethod3(3));

		NthFromLast.findNthFromLastMethod4(list.getHead(), 5);
		if (nthFromLast != null)
			System.out.println("last 5th from list : " + nthFromLast);

	}

}
