/*

Given a matrix of m * n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example:

Given the following matrix:

[
    [ 1, 2, 3 ],
    [ 4, 5, 6 ],
    [ 7, 8, 9 ]
]
You should return

[1, 2, 3, 6, 9, 8, 7, 4, 5]

*/
//	Watch for the algorithm : https://www.youtube.com/watch?v=siKFOI8PNKM&feature=player_embedded

package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralOrderTraversal {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> listOfList = new ArrayList<ArrayList<Integer>>();
		listOfList.add(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4)));
		listOfList.add(new ArrayList<Integer>(Arrays.asList(5, 6, 7, 8)));
		listOfList.add(new ArrayList<Integer>(Arrays.asList(9, 10, 11, 12)));
		listOfList.add(new ArrayList<Integer>(Arrays.asList(13, 14, 15, 16)));

		System.out.println(listOfList);
		System.out.println("Spiral Form");
		System.out.println(sprialOrderPrint(listOfList));

	}

	private static List<Integer> sprialOrderPrint(ArrayList<ArrayList<Integer>> A) {
		int T, B, L, R;
		int m = A.size();
		int n = A.get(0).size();
		T = 0;
		B = m - 1;
		L = 0;
		R = n - 1;
		int dir = 0;
		List<Integer> resArray = new ArrayList<Integer>();

		while (T <= B && L <= R) {
			if (dir == 0) {
				for (int i = L; i <= R; i++)
					resArray.add(A.get(T).get(i));
				T++;

			} else if (dir == 1) {
				for (int i = T; i <= B; i++)
					resArray.add(A.get(i).get(R));
				R--;

			} else if (dir == 2) {
				for (int i = R; i >= L; i--)
					resArray.add(A.get(B).get(i));
				B--;

			} else if (dir == 3) {
				for (int i = B; i >= T; i--)
					resArray.add(A.get(i).get(L));
				L++;

			}
			dir = (dir + 1) % 4;
		}
		return resArray;
	}

}
