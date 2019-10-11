/**
 * Find second maximum element in the array.
 */

package faqs;

public class SecondMaxElementInArray {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 5, 3, 10, 12, 9, 18 };
		findSecondMax(arr);
	}

	private static void findSecondMax(int[] arr) {
		int i, max, max2;
		max = max2 = Integer.MIN_VALUE;

		if (arr.length < 2) {
			System.out.println("size is less than 2");
			return;
		}
		for (i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max2 = max;
				max = arr[i];
			} else if (arr[i] > max2 && arr[i] != max)
				max2 = arr[i];
		}
		if (max2 == Integer.MIN_VALUE) {
			System.out.println("No second largest element");
			return;
		}
		System.out.println("second largest is : " + max2);

	}

}
