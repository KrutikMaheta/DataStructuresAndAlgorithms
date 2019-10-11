/**
 * Reverse and array elements in pair of given number.
 */
package faqs;
import java.util.Arrays;

public class ReverseInPair {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		reverseInPair(arr, 3);
	}

	private static void reverseInPair(int[] arr, int k) {
		for (int i = 0; i <= arr.length - k; i = i + k) {
			for (int p = i, q = i + k - 1; p < q; p++, q--) {
				int temp = arr[p];
				arr[p] = arr[q];
				arr[q] = temp;
			}
		}
		System.out.println(Arrays.toString(arr));
	}

}
