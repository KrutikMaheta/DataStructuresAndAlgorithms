/**
 * Write an efficient program to find the sum of contiguous subarray within a one-dimensional 
 * array of numbers which has the largest sum.
 */
package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSumSubArray {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(-2, 1, -3, 4, -1, 2, 1, -5, 4));
		System.out.println(maxSumSubArray(list));
	}

	private static int maxSumSubArray(List<Integer> list) {
		int max = list.get(0);
		int max_so_far = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			max = Math.max(list.get(i), max + list.get(i));
			max_so_far = Math.max(max_so_far, max);
		}

		return max_so_far;
	}

}
