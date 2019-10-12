/**
 * Write a program to find weather the given strings are anagrams
 */

package faqs;

import java.util.Arrays;

public class Anagram {

	// Assuming the string length will be equal
	public static void main(String[] args) {
		System.out.println(isAnnagram("act", "cat"));
		System.out.println(isAnagram2("listen2".toCharArray(), "sil2ent".toCharArray()));
	}

	// O(n*n)
	private static boolean isAnnagram(String str1, String str2) {
		char[] s1 = str1.toCharArray();
		char[] s2 = str2.toCharArray();
		Arrays.sort(s1);
		Arrays.sort(s2);
		return Arrays.compare(s1, s2) == 0 ? true : false;
	}

	/*
	 * function to check whether two strings are anagram of each other : O(n)
	 */
	static boolean isAnagram2(char str1[], char str2[]) {
		int[] cnt1 = new int[255];
		Arrays.fill(cnt1, 0);
		for (int i = 0; i < str1.length; i++) {
			cnt1[str1[i]]++;
			cnt1[str2[i]]--;
		}
		for (int i = 0; i < cnt1.length; i++) {
			if (cnt1[i] != 0)
				return false;
		}
		return true;
	}
}