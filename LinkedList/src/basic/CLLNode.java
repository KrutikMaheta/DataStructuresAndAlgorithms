package basic;

public class CLLNode {
	private CLLNode next;
	private int data;

	// Creates an empty node.
	public CLLNode() {
		next = null;
		data = Integer.MIN_VALUE;
	}

	// Creates a node storing the specified data.
	public CLLNode(int data) {
		next = null;
		this.data = data;
	}

	// Returns the node that follows this one.
	public CLLNode getNext() {
		return next;
	}

	// Sets the node that follows this one.
	public void setNext(CLLNode node) {
		next = node;
	}

	// Returns the data stored in this node.
	public int getData() {
		return data;
	}

	// Sets the data stored in this node.
	public void setData(int elem) {
		data = elem;
	}

	// Sets the data stored in this node.
	public String toString() {
		return Integer.toString(data);
	}
}
