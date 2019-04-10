package basic;

public class DoublyLinkedDequeue {
	DLLNode front, rear;
	int size;

	public DoublyLinkedDequeue() {
		front = rear = null;
		size = 0;
	}

	public void insertFront(int data) {
		DLLNode newNode = new DLLNode(data);
		newNode.setNext(front);
		if (front != null)
			front.setPrev(newNode);
		if (front == null)
			rear = newNode;
		front = newNode;
	}

	public void insertRear(int data) {
		DLLNode newNode = new DLLNode(data);
		newNode.setPrev(rear);
		if (rear != null)
			rear.setNext(newNode);
		if (rear == null)
			front = newNode;
		rear = newNode;
	}

	public int removeFront() throws Exception {
		if (front == null)
			throw new Exception("Empty queue exception");
		int data = front.getData();
		DLLNode temp = front.getNext();
		if (temp == null)
			rear = null;
		else
			temp.setPrev(null);
		front = temp;
		return data;
	}

	public int removeRear() throws Exception {
		if (front == null)
			throw new Exception("Empty queue exception");
		int data = rear.getData();
		DLLNode temp = rear.getPrev();
		if (temp == null)
			front = null;
		else
			temp.setNext(null);
		rear = temp;
		return data;
	}
}