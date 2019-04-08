package basic;

public class ListNode<T> {
	private T data;
	private ListNode<T> next;

	public ListNode(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public ListNode<T> getNext() {
		return next;
	}

	public void setNext(ListNode<T> top) {
		this.next = top;
	}

	@Override
	public String toString() {
		return String.valueOf(data);
	}

}
