package problems;

import java.util.LinkedList;
import java.util.Queue;

public class FindMaxMin {

	TreeNode rootNode;

	public static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
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

	/**
	 * 1. Find maximum element in left subtree
	 * 2. Find maximum element in right subtree
	 * 3. Compare maximum of above subtrees to current node
	 * 4. We will find maximum element with above steps
	 * @param root
	 * @return
	 */
	
	public static int getMaximumRec(TreeNode root) {
		int max = Integer.MIN_VALUE;
		int value = 0;
		int left, right;
		if (root != null) {
			value = root.data;
			left = getMaximumRec(root.left);
			right = getMaximumRec(root.right);

			if (left > right) {
				max = left;
			} else {
				max = right;
			}

			if (max < value) {
				max = value;
			}
		}

		return max;
	}


	public int max(TreeNode rootNode2) {
		// TODO Auto-generated method stub
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(rootNode2);
		int max = rootNode2.data;
		while (!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			if (max < temp.data)
				max = temp.data;
			if (temp.left != null)
				queue.add(temp.left);
			if (temp.right != null)
				queue.add(temp.right);
		}

		return max;

	}

	public int min(TreeNode rootNode2) {
		// TODO Auto-generated method stub
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(rootNode2);
		int min = rootNode2.data;
		while (!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			if (min > temp.data)
				min = temp.data;
			if (temp.left != null)
				queue.add(temp.left);
			if (temp.right != null)
				queue.add(temp.right);
		}

		return min;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindMaxMin bt = new FindMaxMin();
		bt.add(50);
		bt.add(10);
		bt.add(20);
		bt.add(60);
		bt.add(70);
		bt.add(30);
		bt.add(55);

		System.out.println("Maximum node is : " + bt.max(bt.rootNode));
		System.out.println("Minimum node is : " + bt.min(bt.rootNode));
		
		System.out.println("Maximum node by recursion is : " + bt.getMaximumRec(bt.rootNode));
		
	}

}
