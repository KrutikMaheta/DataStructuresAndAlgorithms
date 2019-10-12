/**
 * Write a program to calculate the frequency of words in the given string.
 */

package faqs;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordOccurances {

	public static void main(String[] args) {
		String s = "My Name is Krutik Krutik is on sick leave";
		findWordOccurances(s);
	}

	private static void findWordOccurances(String s) {
		System.out.println(
				Stream.of(s.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
	}

}
