package basic;

public class PriorityListNode {
	private int data;
	private int priority;

	private PriorityListNode next;

	public PriorityListNode(int data, int priority) {
		this.data = data;
		this.priority = priority;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public PriorityListNode getNext() {
		return next;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public void setNext(PriorityListNode next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return String.valueOf(data);
	}

}
