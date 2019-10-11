/**
 * Implement the Binary Tree
 * -> Insertion
 * -> Travesal: in,pre,post,level order traversal
 * -> Print given level
 * 
 * Supporting Files: BinaryTreeClient.java & TreeNode.java
 */

package implementation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	TreeNode root;

	public BinaryTree(int root) {
		this.root = new TreeNode(root);
	}

	public void inOrder(TreeNode root) {
		if (root != null) {
			// first recur on left child
			inOrder(root.left);
			// then print the data of node
			System.out.print(root.key + " ");
			// now recur on right child
			inOrder(root.right);
		}
	}

	public void inOrderWithoutRecursion(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode temp = root;
		boolean done = false;
		while (!done) {
			if (temp != null) {
				stack.push(temp);
				temp = temp.left;
			} else {
				if (stack.isEmpty()) {
					done = true;
					break;
				}
				temp = stack.pop();
				System.out.print(temp.key + " ");
				temp = temp.right;
			}
		}
	}

	public void preOrder(TreeNode root) {
		if (root != null) {
			// first print data of node
			System.out.print(root.key + " ");

			// then recur on left subtree
			preOrder(root.left);

			// now recur on right subtree
			preOrder(root.right);
		}
	}

	public void preOrderWithoutRecursion(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode temp = stack.pop();
			System.out.print(temp.key + " ");
			if (temp.right != null)
				stack.push(temp.right);
			if (temp.left != null)
				stack.push(temp.left);
		}
	}

	public void postOrder(TreeNode root) {
		if (root != null) {
			// first recur on left subtree
			postOrder(root.left);

			// then recur on right subtree
			postOrder(root.right);

			// now deal with the node
			System.out.print(root.key + " ");
		}
	}

	public void postOrderWithoutRecursion(TreeNode root2) {

	}

	public void levelOrder() {
		int height = height(root);
		for (int i = 0; i <= height; i++) {
			printGivenLevel(root, i);
			System.out.println();
		}
	}

	public void printGivenLevel(TreeNode root, int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.print(root.key + " ");
		else {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}

	public void levelOrderUsingQueue() {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode temp = queue.peek();
			queue.poll();
			System.out.print(temp.key + " ");
			if (temp.left != null)
				queue.add(temp.left);
			if (temp.right != null)
				queue.add(temp.right);
		}
	}

	public int height(TreeNode root) {
		if (root == null)
			return 0;
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);

		if (leftHeight >= rightHeight)
			return leftHeight + 1;
		else
			return rightHeight + 1;
	}

	public void insert(TreeNode root, int key) {
		TreeNode newNode = new TreeNode(key);
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		TreeNode temp = null;

		// Do level order traversal until we find
		// an empty place.
		while (!queue.isEmpty()) {
			temp = queue.peek();
			queue.poll();
			if (temp.left == null) {
				temp.left = newNode;
				break;
			} else
				queue.add(temp.left);
			if (temp.right == null) {
				temp.right = newNode;
				break;
			} else
				queue.add(temp.right);

		}
	}

}
