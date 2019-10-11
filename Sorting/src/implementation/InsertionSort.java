//	Iterations:
/**
 * 12, 11, 13, 5, 6
 * 11, 12, 13, 5, 6
 * 11, 12, 13, 5, 6
 * 5, 11, 12, 13, 6
 * 5, 6, 11, 12, 13
 * 
 */

//	Time Complexity: O(n*2)
//	Auxiliary Space: O(1)

package implementation;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = { 6, 5, 4, 3, 2, 1 };
		insertionSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int hole = i;
			int value = arr[i];
			while (hole > 0 && arr[hole - 1] > value) {
				arr[hole] = arr[hole - 1];
				hole--;
			}
			arr[hole] = value;
			System.out.println("Iteration : " + Arrays.toString(arr));
		}
	}

}
