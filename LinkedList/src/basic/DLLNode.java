package basic;

public class DLLNode {
	private int data;
	private DLLNode prev;
	private DLLNode next;

	DLLNode(int data) {
		this.data = data;
		prev = next = null;
	}

	DLLNode(int data, DLLNode prev, DLLNode next) {
		this.data = data;
		this.next = next;
		this.prev = prev;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public DLLNode getPrev() {
		return prev;
	}

	public void setPrev(DLLNode prev) {
		this.prev = prev;
	}

	public DLLNode getNext() {
		return next;
	}

	public void setNext(DLLNode next) {
		this.next = next;
	}
}
