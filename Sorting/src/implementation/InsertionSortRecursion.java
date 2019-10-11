package implementation;

import java.util.Arrays;

public class InsertionSortRecursion {

	public static void main(String[] args) {
		int[] arr = { 6, 5, 4, 3, 2, 1 };
		System.out.println("start : "+ Arrays.toString(arr));
		insertionSortRecursion(arr, arr.length);
		System.out.println("end : "+Arrays.toString(arr));
	}

	private static void insertionSortRecursion(int[] arr, int n) {
		if (n == 1)
			return;
		insertionSortRecursion(arr, n - 1);
		int j = n - 2;
		int key = arr[n - 1];
		while (j >= 0 && arr[j] > key) {
			arr[j + 1] = arr[j];
			j = j - 1;
		}
		arr[j + 1] = key;
		System.out.println(n + ":" + Arrays.toString(arr));
	}

}
