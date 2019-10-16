package problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeTraversal {

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
	 * Visit the node. Traverse the left subtree in PreOrder. Traverse the right
	 * subtree in PreOrder.
	 * 
	 * @param temp
	 */

	public void preOrder(TreeNode temp) {
		if (temp != null) {
			System.out.print(temp.data + ",");
			preOrder(temp.left);
			preOrder(temp.right);
		}
	}

	/**
	 * 1. Create empty stack and pust root node to it. Do the following when
	 * stack is not empty 2. Pop a node from stack and print it 3. Push right
	 * child of popped node to stack 4. Push left child of popped node to stack
	 * We are pushing right child first, so it will be processed after left
	 * subtree as Stack is LIFO.
	 * 
	 * @param temp
	 */

	public void preOrderWithItr(TreeNode temp) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(temp);
		while (!stack.isEmpty()) {
			TreeNode n = stack.pop();
			System.out.print(n.data + ",");

			if (n.right != null)
				stack.push(n.right);
			if (n.left != null)
				stack.push(n.left);
		}
	}

	private void inOrder(TreeNode rootNode2) {
		// TODO Auto-generated method stub
		if (rootNode2 != null) {
			inOrder(rootNode2.left);
			System.out.print(rootNode2.data + ",");
			inOrder(rootNode2.right);
		}
	}

	private void inOrderWithItr(TreeNode rootNode2) {
		// TODO Auto-generated method stub
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode currentNode = rootNode2;
		while (!stack.empty() || currentNode != null) {
			if (currentNode != null) {
				stack.push(currentNode);
				currentNode = currentNode.left;
			} else {
				TreeNode node = stack.pop();
				System.out.print(node.data + ",");
				currentNode = node.right;
			}
		}

	}

	private void postOrder(TreeNode rootNode2) {
		// TODO Auto-generated method stub
		if (rootNode2 != null) {
			postOrder(rootNode2.left);
			postOrder(rootNode2.right);
			System.out.print(rootNode2.data + ",");
		}
	}

	/**
	 * level Order traversal: 1. Create empty queue and pust root node to it. 2.
	 * Pop a node from queue and print it 3. Push left child of popped node to
	 * queue if not null 4. Push right child of popped node to queue if not null
	 * 
	 * @param rootNode2
	 */

	private void levelOrderTraversal(TreeNode rootNode2) {
		// TODO Auto-generated method stub
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(rootNode2);
		while (!queue.isEmpty()) {
			TreeNode poppedNode = queue.poll();
			System.out.print(poppedNode.data + ",");
			if (poppedNode.left != null)
				queue.add(poppedNode.left);
			if (poppedNode.right != null)
				queue.add(poppedNode.right);
		}

	}

	/**
	 * 1. Create empty queue and push root node to it. 2. Pop a node from queue
	 * 3. Push right child of popped node to queue if not null 4. Push left
	 * child of popped node to queue if not null 5. Push current node to stack
	 * 6. Pop node from stack and print it
	 * 
	 * @param rootNode2
	 */

	private void reverseLevelOrderTraversal(TreeNode rootNode2) {
		// TODO Auto-generated method stub

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Stack<TreeNode> stack = new Stack<TreeNode>();

		queue.add(rootNode2);
		while (!queue.isEmpty()) {
			TreeNode tempNode = queue.poll();
			if (tempNode.right != null)
				queue.add(tempNode.right);
			if (tempNode.left != null)
				queue.add(tempNode.left);

			stack.push(tempNode);
		}
		while (!stack.isEmpty()) {
			TreeNode tempNode = stack.pop();
			System.out.print(tempNode.data + ",");
		}
	}

	private static void printLeafNodes(TreeNode root) {
		if (root == null)
			return;

		if (root.left == null && root.right == null) {
			System.out.print(root.data + " ");
			return;
		}
		printLeafNodes(root.left);
		printLeafNodes(root.right);
	}

	private static void printRightBottomUp(TreeNode root) {
		if (root == null)
			return;

		// if leaf node, ignore while printing edges
		if (root.left == null && root.right == null) {
			return;
		}

		if (root.right != null) {
			printRightBottomUp(root.right);
		} else if (root.left != null) {
			printRightBottomUp(root.left);
		}

		System.out.print(root.data + " ");
	}

	private static void printLeftEdgeNodes(TreeNode root) {
		if (root == null)
			return;

		// if leaf node, ignore while printing edges
		if (root.left == null && root.right == null)
			return;

		System.out.print(root.data + " ");

		// If left is null, right will be the boundary edge.
		if (root.left == null) {
			printLeftEdgeNodes(root.right);
		} else {
			printLeftEdgeNodes(root.left);
		}

	}

	/**
	 * 1. Print left edge nodes (Excluding leaf nodes)
	 * 2. Print leaf nodes
	 * 3. Print right edge nodes (From bottom to top)
	 * @param root
	 */
	
	private void boundaryLevelTraversal(TreeNode root) {
		// TODO Auto-generated method stub
		System.out.print(root.data + " ");
		printLeftEdgeNodes(root.left);
		printLeafNodes(root);
		printRightBottomUp(root.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinaryTreeTraversal bt = new BinaryTreeTraversal();
		bt.add(50);
		bt.add(10);
		bt.add(20);
		bt.add(60);
		bt.add(70);
		bt.add(30);
		bt.add(55);
		System.out.print("PreOrder Travesal with Recursion      : ");
		bt.preOrder(bt.rootNode);
		System.out.print("\nPreOrder Travesal without Recursion : ");
		bt.preOrderWithItr(bt.rootNode);
		System.out.print("\nInOrder Travesal with Recursion     : ");
		bt.inOrder(bt.rootNode);
		System.out.print("\nInOrder Travesal without Recursion  : ");
		bt.inOrderWithItr(bt.rootNode);
		System.out.print("\nPostOrder Travesal with Recursion  : ");
		bt.postOrder(bt.rootNode);
		System.out.print("\nLevel order Travesal without Recursion  : ");
		bt.levelOrderTraversal(bt.rootNode);
		System.out.print("\nReverse Level order Travesal without Recursion  : ");
		bt.reverseLevelOrderTraversal(bt.rootNode);
		System.out.print("\nBoundary Level traversal  : ");
		bt.boundaryLevelTraversal(bt.rootNode);

	}

}
