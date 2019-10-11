package implementation;

import java.util.Arrays;

public class BubbleSortRecursion {

	public static void main(String[] args) {
		int[] arr = { 6, 5, 4, 3, 2, 1 };
		sort(arr, arr.length);
		System.out.println(Arrays.toString(arr));
	}

	private static void sort(int[] arr, int n) {
		if (n == 1)
			return;
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				int temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
			}
		}
		sort(arr, n - 1);
	}

}
