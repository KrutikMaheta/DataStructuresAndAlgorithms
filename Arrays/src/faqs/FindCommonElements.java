/**
 * Find the common elements from the given 3 sorted arrays.
 */

package faqs;
public class FindCommonElements {

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3, 4, 8 };
		int[] arr2 = { 2, 3, 4, 5, 7, 8 };
		int[] arr3 = { 4, 5, 6, 7, 8, 9 };

		findCommonElements(arr1, arr2, arr3);

	}

	private static void findCommonElements(int[] arr1, int[] arr2, int[] arr3) {
		int i = 0, j = 0, k = 0;
		while (i < arr1.length && j < arr2.length && k < arr3.length) {
			if (arr1[i] == arr2[j] && arr1[i] == arr3[k]) {
				System.out.println(arr1[i]);
				i++;
				j++;
				k++;
			}
			else if (arr1[i] < arr2[j])
				i++;
			else if (arr2[j] < arr3[k])
				j++;
			else
				k++;
		}
	}

}
