/**
 * Calculate the number of occurrence of all the elements in the array.
 */
package faqs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NumberOccurances {

	public static void main(String[] args) {
		Integer arr[] = { 1, 2, 1, 3, 2, 4, 5, 5, 6, 5 };
		numberOccurance(arr);
		numberOccuranceUsingJava8(arr);
	}

	private static void numberOccurance(Integer[] arr) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : arr) {
			if (map.put(i, 1) != null)
				map.put(i, map.get(i) + 1);
			else
				map.put(i, 1);
		}
		System.out.println(map);
	}

	private static void numberOccuranceUsingJava8(Integer[] arr) {
		System.out.println(new ArrayList<Integer>(Arrays.asList(arr)).stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
	}

}
