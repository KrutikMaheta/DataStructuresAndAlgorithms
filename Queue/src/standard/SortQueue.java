/**
 * 
 * Write a program to sort the queue
 * 
 * Algorithm:
 * 
 * On every pass on the queue, we seek for the next minimum index. 
 * To do this we dequeue and enqueue elements until we find the next minimum. 
 * In this operation the queue is not changed at all. 
 * After we have found the minimum index, we dequeue and enqueue elements from the queue except for 
 * the minimum index, after we finish the traversal in the queue we insert the minimum to the rear of the 
 * queue. We keep on this until all minimums are pushed all way long to the front and the queue becomes 
 * sorted. On every next seeking for the minimum, we exclude seeking on the minimums that have already sorted.
 * 
 */

package standard;

import java.util.LinkedList;
import java.util.Queue;

public class SortQueue {

	private static Queue<Integer> queue = new LinkedList<Integer>();

	// Queue elements after sortIndex are
	// already sorted. This function returns
	// index of minimum element from front to
	// sortIndex
	private static int min_index(int sortedIndex) {
		int min_index = -1;
		int min_val = Integer.MAX_VALUE;
		for (int i = 0; i < queue.size(); i++) {
			int value = queue.poll();
			if (value < min_val && i <= sortedIndex) {
				min_index = i;
				min_val = value;
			}
			queue.add(value);
		}
		return min_index;
	}

	// Moves given minimum element
	// to rear of queue
	private static void insert_min(int min_index) {
		int min_val = Integer.MAX_VALUE;
		for (int i = 0; i <= queue.size(); i++) {

			if (i == min_index) {
				min_val = queue.poll();
				continue;
			}

			queue.add(queue.poll());
		}
		queue.add(min_val);

	}

	private static void sort() {
		for (int i = 1; i <= queue.size(); i++) {
			int min_index = min_index(queue.size() - i);
			insert_min(min_index);
		}
	}

	public static void main(String[] args) {
		queue.add(11);
		queue.add(5);
		queue.add(4);
		queue.add(21);

		sort();
		System.out.println(queue);
	}

}
