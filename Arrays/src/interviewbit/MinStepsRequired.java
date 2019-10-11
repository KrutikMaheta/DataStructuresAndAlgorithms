/**
 * You are given a sequence of points and the order in which you need to cover the points. 
 * Give the minimum number of steps in which you can achieve it. You start from the first point.
 * 
 * You are in an infinite 2D grid where you can move in any of the 8 directions :
 * (x,y) to 
 * (x+1, y), 
 * (x - 1, y), 
 * (x, y+1), 
 * (x, y-1), 
 * (x-1, y-1), 
 * (x+1,y+1), 
 * (x-1,y+1), 
 * (x+1,y-1)
 *
 */

package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;


public class MinStepsRequired {

	public static void main(String[] args) {
		ArrayList<Integer> xCords = new ArrayList<Integer>(Arrays.asList(4, 1, 4, 10));
		ArrayList<Integer> yCords = new ArrayList<Integer>(Arrays.asList(6, 2, 5, 12));
		minSteps(xCords, yCords);
	}

	private static void minSteps(ArrayList<Integer> xCords, ArrayList<Integer> yCords) {
		int count = 0;
		for (int i = 0; i < xCords.size() - 1; i++) {
			int xMax = Math.abs(xCords.get(i + 1) - xCords.get(i));
			int yMax = Math.abs(yCords.get(i + 1) - yCords.get(i));
			count += ((xMax > yMax) ? xMax : yMax);
		}
		System.out.println(count);
	}

}
