package implementation;

public class CircularLinkedListClient {

	public static void main(String[] args) {
		CircularLinkedList cll = new CircularLinkedList();
		cll.insertAtBeginning(new CLLNode(5));
		cll.insertAtEnd(new CLLNode(6));
		cll.insertAtBeginning(new CLLNode(7));
		cll.insertAtBeginning(new CLLNode(11));
		cll.insertAtBeginning(new CLLNode(2));
		
		System.out.println(cll);
		
		System.out.println("Remove from front");
		cll.removeFromBegin();
		System.out.println(cll);
		
		System.out.println("Remove from rear");
		cll.removeFromEnd();
		System.out.println(cll);
		
		System.out.println("Remove data --> 7");
		cll.remove(7);
		System.out.println(cll);
		
		System.out.println("Remove data --> 5");
		cll.remove(5);
		System.out.println(cll);
		
		System.out.println("Remove data --> 11");
		cll.remove(11);
		System.out.println(cll);
	}

}
