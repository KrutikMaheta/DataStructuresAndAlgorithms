/**
 * The stock span problem is a financial problem where we have a series of n daily price quotes 
 * for a stock and we need to calculate span of stock’s price for all n days.
 * 
 * The span Si of the stock’s price on a given day i is defined as the maximum number of 
 * consecutive days just before the given day, for which the price of the stock on the current day 
 * is less than or equal to its price on the given day.
 * 
 * For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, 
 * then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}
 */

package standard;

import java.util.Arrays;

import basic.LinkedStack;

public class StockSpan {

	private static LinkedStack<Integer> spanStack = new LinkedStack<>();

	private static void calculateSpan(int[] price, int n, int[] s) {
		// Span value of first element is always 1
		s[0] = 1;
		// Create a stack and push index of first element
		// to it
		spanStack.push(0);

		// Calculate span values for rest of the elements
		for (int i = 1; i < price.length; i++) {
			// Pop elements from stack while stack is not
			// empty and top of stack is smaller than
			// price[i]
			while (!spanStack.isEmpty() && price[spanStack.peek()] <= price[i])
				spanStack.pop();

			// If stack becomes empty, then price[i] is
			// greater than all elements on left of it, i.e.,
			// price[0], price[1], ..price[i-1]. Else price[i]
			// is greater than elements after top of stack
			s[i] = spanStack.isEmpty() ? i + 1 : i - spanStack.peek();
			// Push this element to stack
			spanStack.push(i);
		}

	}

	static void printArray(int arr[]) {
		System.out.print(Arrays.toString(arr));
	}

	public static void main(String[] args) {
		int price[] = { 10, 4, 5, 90, 120, 80 };
		int n = price.length;
		int S[] = new int[n];

		calculateSpan(price, n, S);

		printArray(S);
	}

}
