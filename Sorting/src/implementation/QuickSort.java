//	The key process in quickSort is partition(). Target of partitions is, given an array and 
//	an element x of array as pivot, put x at its correct position in sorted array and put all 
//	smaller elements (smaller than x) before x, and put all greater elements (greater than x) after x. 
//	All this should be done in linear time.

package implementation;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = { 6, 5, 4, 3, 2, 1 };
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	private static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int pivot = partition(arr, low, high);
			quickSort(arr, low, pivot - 1);
			quickSort(arr, pivot + 1, high);
		}
	}

	/*
	 * This function takes last element as pivot, places the pivot element at its
	 * correct position in sorted array, and places all smaller (smaller than pivot)
	 * to left of pivot and all greater elements to right of pivot
	 */

	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int pivotIndex = low;
		for (int j = low; j < high; j++) {
			if (arr[j] <= pivot) {
				int temp = arr[pivotIndex];
				arr[pivotIndex] = arr[j];
				arr[j] = temp;
				pivotIndex++;
			}
		}
		int temp = arr[pivotIndex];
		arr[pivotIndex] = arr[high];
		arr[high] = temp;
		return pivotIndex;
	}

}
