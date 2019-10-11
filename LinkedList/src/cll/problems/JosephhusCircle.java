/**
 * Write a program to find the position of an element in the circular linkedlist.
 */
package cll.problems;

import implementation.CLLNode;

public class JosephhusCircle {

	public static void main(String[] args) {
		System.out.println("Josephus position is : " + getJosephusPosition(10, 3));
	}

	private static int getJosephusPosition(int n, int m) {
		CLLNode p = new CLLNode(1);
		CLLNode q = p;
		for (int i = 2; i <= n; i++) {
			CLLNode temp = new CLLNode(i);
			p.setNext(temp);
			p = p.getNext();
		}
		p.setNext(q);

		for (int i = n; i > 1; i--) {
			for (int j = 1; j < m; j++)
				p = p.getNext();

			p.setNext(p.getNext().getNext());
		}
		return p.getData();
	}

}
