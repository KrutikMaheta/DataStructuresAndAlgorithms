/**
 * MergeSort(arr[], l,  r)
	If r > l
     1. Find the middle point to divide the array into two halves:  
             middle m = (l+r)/2
     2. Call mergeSort for first half:   
             Call mergeSort(arr, l, m)
     3. Call mergeSort for second half:
             Call mergeSort(arr, m+1, r)
     4. Merge the two halves sorted in step 2 and 3:
             Call merge(arr, l, m, r)
 * 
 */

//	O(n Log(n))

//	Merge sort is quite useful in case of LinkedList as we don't need more of the random access.

package implementation;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = { 6, 5, 4, 3, 2, 1 };
		mergeSort(arr, 0, arr.length - 1);
	}

	private static void mergeSort(int[] arr, int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;
			mergeSort(arr, l, m);
			mergeSort(arr, m + 1, r);
			merge(arr, l, m, r);
		}
	}

	private static void merge(int[] arr, int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;
		int L[] = new int[n1];
		int R[] = new int[n2];

		for (int i = 0; i < n1; i++)
			L[i] = arr[l + i];
		for (int i = 0; i < n2; i++)
			R[i] = arr[m + 1 + i];

		System.out.println("L: " + Arrays.toString(L));
		System.out.println("R: " + Arrays.toString(R));

		int i = 0, j = 0, k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j])
				arr[k] = L[i++];
			else
				arr[k] = R[j++];
			k++;
		}
		while (i < n1)
			arr[k++] = L[i++];
		while (j < n2)
			arr[k++] = R[j++];
		System.out.println("Arr : " + Arrays.toString(arr));
	}

}
