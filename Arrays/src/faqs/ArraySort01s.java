/**
 * Sort array of 0's and 1's
 */

package faqs;

import java.util.Arrays;

public class ArraySort01s {

	public static void main(String[] args) {
		int[] arr = { 1, 0, 0, 1, 0, 0, 1, 1, 1 };
		int[] res = new int[arr.length];
		int left = 0;
		int right = arr.length - 1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 1)
				res[right--] = 1;
			else
				res[left++] = 0;
		}
		System.out.println(Arrays.toString(res));
	}

}
