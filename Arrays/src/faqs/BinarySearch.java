/**
 * Search an element in the array with binary search recursively.
 */
package faqs;

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = { 2, 3, 4, 10, 20 };
		int left = 0;
		int right = arr.length - 1;
		int elementToSearch = 10;
		System.out.println(binarySearch(arr, left, right, elementToSearch));

	}

	private static int binarySearch(int[] arr, int left, int right, int elementToSearch) {
		if (right >= left) {
			int mid = (right + left) / 2;
			if (arr[mid] == elementToSearch)
				return mid;
			else if (arr[mid] > elementToSearch)
				return binarySearch(arr, left, mid - 1, elementToSearch);
			return binarySearch(arr, mid + 1, right, elementToSearch);
		}

		return -1;
	}

}
