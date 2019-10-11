/**
 * The selection sort algorithm sorts an array by repeatedly finding the minimum element 
 * (considering ascending order) from unsorted part and putting it at the beginning. 
 * The algorithm maintains two subarrays in a given array.

	1) The subarray which is already sorted.
	2) Remaining subarray which is unsorted.

	In every iteration of selection sort, the minimum element (considering ascending order) from the 
	unsorted subarray is picked and moved to the sorted subarray.
 * 
 * 
 */

//	Time Complexity: O(n2) as there are two nested loops.
//	Auxiliary Space: O(1)

package implementation;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = { 6, 5, 4, 3, 2, 1 };
		int min_index;
		int count = 0;

		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < arr.length - 1; i++) {
			min_index = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min_index])
					min_index = j;
				count++;
			}
			int temp = arr[min_index];
			arr[min_index] = arr[i];
			arr[i] = temp;
			count++;
			System.out.println("Iteration: " + Arrays.toString(arr));
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(count);
	}

}
