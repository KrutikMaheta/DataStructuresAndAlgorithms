/**
 * Recursive linear search for the element in the array.
 */

package faqs;

public class RecursiveLinearSearch {

	public static void main(String[] args) {
		int[] arr = { 3, 6, 7, 12, 1, 2, 0, 27 };
		System.out.println(search(arr, 0, arr.length - 1, 27));
	}

	private static boolean search(int[] arr, int l, int r, int k) {
		if (l > r)
			return false;
		else if (arr[l] == k || arr[r] == k)
			return true;
		else
			return search(arr, l + 1, r - 1, k);
	}

}
