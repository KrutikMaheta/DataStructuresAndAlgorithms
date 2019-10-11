/**
 * Search first and last occurrence of given number in an array. 
 */
package faqs;

public class SearchFirstIndexOfRepeatedElement {

	public static void main(String[] args) {
		int arr[] = { 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4 };
		// int arr[] = { 1, 2, 3, 4, 4, 4, 4, 4, 4, 4, 6, 7, 8 };
		// int arr[] = { 1, 2, 2, 3, 4, 5, 6, 7, 8 };
		System.out.println(searchFirstIndex(arr, 0, arr.length - 1, 4));
		System.out.println(searchLastIndex(arr, 0, arr.length - 1, 4));
		System.out.println(noOfOccurrences(arr, 0, arr.length - 1, 4));
	}

	private static int searchFirstIndex(int[] arr, int start, int end, int elementToSearch) {
		int result = -1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == elementToSearch) {
				result = mid;
				end = mid - 1;
			} else if (arr[mid] > elementToSearch)
				end = mid - 1;
			else
				start = mid + 1;
		}
		return result;
	}

	// O(log n)
	private static int searchLastIndex(int[] arr, int start, int end, int elementToSearch) {
		int result = -1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == elementToSearch) {
				result = mid;
				start = mid + 1;
			} else if (arr[mid] > elementToSearch)
				end = mid - 1;
			else
				start = mid + 1;
		}
		return result;
	}

	private static int noOfOccurrences(int[] arr, int start, int end, int elementToSearch) {
		return searchLastIndex(arr, start, end, elementToSearch) - searchFirstIndex(arr, start, end, elementToSearch)
				+ 1;
	}

}