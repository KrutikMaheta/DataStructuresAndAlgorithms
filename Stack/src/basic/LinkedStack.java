/**
 * Implement stack using LinkedList
 * 
 * Supporting File: LinkedStackClient.java
 * 					ListNode.java
 * 					Stack.java
 */
package basic;

import java.util.EmptyStackException;

public class LinkedStack<T> {
	private int length;
	private ListNode<T> top;

	public LinkedStack() {
		length = 0;
		top = null;
	}

	public void push(T data) {
		ListNode<T> temp = new ListNode<T>(data);
		temp.setNext(top);
		top = temp;
		length++;
	}

	public T pop() throws EmptyStackException {
		if (isEmpty())
			throw new EmptyStackException();
		T data = (T) top.getData();
		top = top.getNext();
		length--;
		return data;
	}

	public T peek() throws EmptyStackException {
		if (isEmpty())
			throw new EmptyStackException();
		return (T) top.getData();
	}

	public String toString() {
		String result = "[";
		ListNode<T> current = top;
		while (current != null) {
			result += current.getData() + ",";
			current = current.getNext();
		}
		return result.equals("[") ? result + "]" : result.substring(0, result.length() - 1) + "]";
	}

	public boolean isEmpty() {
		return (length == 0);
	}

	public int size() {
		return length;
	}

	public void reverse() {
		ListNode<T> cur = top;
		ListNode<T> prev = null;
		while (cur != null) {
			ListNode<T> next = cur.getNext();
			cur.setNext(prev);
			prev = cur;
			cur = next;
		}
		top = prev;
	}
}
