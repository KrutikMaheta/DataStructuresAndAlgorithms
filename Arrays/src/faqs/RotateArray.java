/**
 * Rotate and array by given position
 */
package faqs;

import java.util.Arrays;

public class RotateArray {

	public static void main(String[] args) {
		int[] arr = { 2, 3, 1, 4, 5, 6 };
		leftRotateArray(arr, 3);
	}

	private static void leftRotateArray(int[] arr, int n) {
		int resArray[] = new int[arr.length];
		for (int i = n; i < arr.length; i++)
			resArray[i - n] = arr[i];
		for (int i = 0; i < n; i++)
			resArray[arr.length - n + i] = arr[i];
		System.out.println(Arrays.toString(resArray));
	}

}
