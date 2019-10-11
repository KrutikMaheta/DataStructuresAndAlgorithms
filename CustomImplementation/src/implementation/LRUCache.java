/**
 * Implementation of custom LRU cache.
 */

//	Reference : https://java2blog.com/lru-cache-implementation-java/

package implementation;

import java.util.HashMap;

class Node {
	int key;
	int value;
	Node prev;
	Node next;

	public Node(int key, int value) {
		this.key = key;
		this.value = value;
	}
}

public class LRUCache {

	int capacity;
	HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	Node head = null;
	Node end = null;

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node n = map.get(key);
			delete(n);
			setHead(n);
			return n.value;
		}

		return -1;
	}

	/* This method will delete node */
	public void delete(Node node) {
		if (node.prev != null) {
			node.prev.next = node.next;
		} else {
			head = node.next;
		}

		if (node.next != null) {
			node.next.prev = node.prev;
		} else {
			end = node.prev;
		}

	}

	/* This method will make passed node as head */
	public void setHead(Node node) {
		node.next = head;
		node.prev = null;

		if (head != null)
			head.prev = node;

		head = node;

		if (end == null)
			end = head;
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			// update the old value
			Node old = map.get(key);
			old.value = value;
			delete(old);
			setHead(old);
		} else {
			Node newNode = new Node(key, value);
			if (map.size() >= capacity) {

				map.remove(end.key);
				// remove last node
				delete(end);
				setHead(newNode);

			} else {
				setHead(newNode);
			}

			map.put(key, newNode);
		}
	}

	public static void main(String[] args) {
		LRUCache lrucache = new LRUCache(4);

		lrucache.set(1, 10);
		lrucache.set(2, -99);
		lrucache.set(3, 99);
		lrucache.set(1, 50);
		lrucache.set(4, 40);
		lrucache.set(5, 30);
		lrucache.set(2, 100);

		System.out.println(lrucache.get(1));
		System.out.println(lrucache.get(3));
		System.out.println(lrucache.get(2));

	}

}
