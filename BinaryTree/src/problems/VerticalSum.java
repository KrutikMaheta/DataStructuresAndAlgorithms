package problems;

import java.util.TreeMap;

public class VerticalSum {

	TreeNode rootNode;

	static class TreeNode {
		TreeNode left;
		TreeNode right;
		int data;

		TreeNode(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	public void add(int data) {

		TreeNode newNode = new TreeNode(data);
		if (rootNode == null) {
			rootNode = newNode;
			return;
		}
		TreeNode focusNode = rootNode;
		TreeNode parent;
		while (true) {
			parent = focusNode;
			if (focusNode.data > data) {
				focusNode = focusNode.left;
				if (focusNode == null) {
					parent.left = newNode;
					return;
				}
			} else {
				focusNode = focusNode.right;
				if (focusNode == null) {
					parent.right = newNode;
					return;
				}
			}

		}

	}

	public void inOrder(TreeNode root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.data + ",");
			inOrder(root.right);
		}
	}

	/**
	 * 1. Traverse tree in inorder traversal.
	 * 2. Create a variable level and initialise it with 0. When you traverse left child, decrease level by 1(level--) and when you traverse right child, increase level by 1(level++).
	 * 3. We need to maintain TreeMap with key as level and value as node data. If you get same key(level) again, then you need to add current node data to previous stored value to calculate sum. 
	 * 		For example:
	 * 		TreeMap has entry with (0,40) where 0 is level and 40 is node data. So while traversing, if you encountered node 30 at level 0, so after processing node 30, TreeMap will have entry as (0,70)
	 * 4. Once TreeMap is populated after iterating all nodes, print the results.
	 *
	 */
	
	
	public void printVerticalSum(TreeNode root, TreeMap<Integer, Integer> verticalSumMap, Integer level) {
		// TODO Auto-generated method stub
		if (root == null)
			return;
		printVerticalSum(root.left, verticalSumMap, level - 1);
		if (verticalSumMap.get(level) != null) {
			int sum = verticalSumMap.get(level) + root.data;
			verticalSumMap.put(level, sum);
		} else {
			verticalSumMap.put(level, root.data);
		}
		printVerticalSum(root.right, verticalSumMap, level + 1);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		VerticalSum bst = new VerticalSum();
		bst.add(50);
		bst.add(10);
		bst.add(20);
		bst.add(60);
		bst.add(70);
		bst.add(30);
		bst.add(55);

		TreeMap<Integer, Integer> verticalSumMap = new TreeMap<>();
		bst.printVerticalSum(bst.rootNode, verticalSumMap, 0);
		verticalSumMap.forEach((k, v) -> System.out.print(k + ":" + v+","));

	}

}
