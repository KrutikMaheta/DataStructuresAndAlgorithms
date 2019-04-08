/**
 * Algorithm:
 * 
 * 1. Take 2 pointers : slow & fast
 * 2. Both will point to the head initially.
 * 3. Move fast pointer at the speed which is double than slower one
 * 4. Once they enter the loop they are expected to meet, which denotes that there is loop exists.
 * 
 */

package problems;

import basic.LinkedList;
import basic.ListNode;

public class FindIfLoopExists {

	static LinkedList list = new LinkedList();

	// Efficient solution
	// Time Complexity : O(n)
	// Space Complexity : O(1)
	static boolean findIfLoopExists() {
		ListNode fastPtr = list.getHead();
		ListNode slowPtr = list.getHead();
		while (fastPtr != null && fastPtr.getNext() != null) {
			fastPtr = fastPtr.getNext().getNext();
			slowPtr = slowPtr.getNext();
			if (fastPtr == slowPtr)
				return true;
		}
		return false;
	}

	/**
	 * Algorithm 2 : Solving with HashTable:
	 * 
	 * 1. Traverse the list nodes one by one 
	 * 2. Check if the address of the node is available in the hash table or not.
	 * 3. If it is already present then it denotes that we are visiting the same node which we have visited earlier This
	 * 	  is possible only if the loop exists in the list 
	 * 4. If the address of that node is not present in the hashtable than add insert that node's address in the hastable. 
	 * 5. Continue this process until we reach the end of the list or we find the loop.
	 * 
	 */

	public static void main(String[] args) {
		list.insertAtBeginning(new ListNode(3));
		list.insertAtBeginning(new ListNode(4));
		list.insertAtEnd(new ListNode(5));
		list.insertAtEnd(new ListNode(1));
		ListNode newNode1 = new ListNode(10);
		ListNode newNode = new ListNode(7);
		list.insertAtEnd(newNode1);
		list.insert(newNode, 2);
		// Below code will create loop in the linked list
		newNode1.setNext(newNode);

		System.out.println("loop exists : " + findIfLoopExists());
	}

}
