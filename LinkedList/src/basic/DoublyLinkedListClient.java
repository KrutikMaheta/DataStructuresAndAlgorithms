package basic;

public class DoublyLinkedListClient {

	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		DLLNode firstNode = new DLLNode(5);
		list.insertAtBeginning(firstNode);
		list.insertAtEnd(new DLLNode(1));
		list.insertAtBeginning(new DLLNode(2));
		DLLNode newNode1 = new DLLNode(7);
		list.insertAtBeginning(newNode1);
		DLLNode newNode = new DLLNode(10);
		list.insert(newNode, 5);
		System.out.println(list);

		System.out.println("removing from begin...");
		list.removeFromBegin();
		System.out.println(list);

		System.out.println("removing from end...");
		list.removeFromEnd();
		System.out.println(list);

		System.out.println("removing from 2nd position...");
		list.remove(2);
		System.out.println(list);

		System.out.println("removing matched node with value 5...");
		list.removeMatched(firstNode);
		System.out.println(list);

	}

}
