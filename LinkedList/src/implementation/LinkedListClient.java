package implementation;

public class LinkedListClient {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		System.out.println(list.toString());
		list.insertAtBeginning(new ListNode(3));
		list.insertAtBeginning(new ListNode(4));
		list.insertAtEnd(new ListNode(5));
		ListNode newNode = new ListNode(7);
		list.insert(newNode, 2);

		System.out.println(list);
		//list.removeFromBegin();
		//list.removeFromEnd();

		list.removeFromMatched(newNode);
		System.out.println(list);
		//list.remove(2);
		list.remove(0);
		// list.remove(5);
		// list.remove(-1);
		System.out.println(list);
		System.out.println(list.getPosition(5));
	}

}
