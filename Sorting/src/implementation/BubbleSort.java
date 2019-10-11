//	Always compares the adjacent elements
//	Finding the best position for particular element
//	O(n*n). Worst case occurs when array is reverse sorted.
//	O(n). Best case occurs when array is already sorted.

package implementation;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = { 4, 5, 6, 1, 3, 2 };
		boolean swapped = false;
		int count = 0;
		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				count++;
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
				}
			}
			System.out.println("Iteration: " + Arrays.toString(arr));
			if (!swapped)
				break;
			count++;
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(count);
	}

}
