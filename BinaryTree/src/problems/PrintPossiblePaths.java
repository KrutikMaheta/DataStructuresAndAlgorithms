/**
 * 
 */
package problems;


/**
 * @author Krutik
 *
 */
public class PrintPossiblePaths {

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
	 * 
	 * 1. If node is null then return 0
	 * 2. put node.data in array and increment len by 1
	 * 3. If encounterd leaf node(i.e. node.left is null and node.right is null) then print array.
	 * 4. Recursively visit left subtree and right subtree
	 * 
	 */
	
	private void printPaths(TreeNode node, int[] array, int len) {
		// TODO Auto-generated method stub
		if (node == null)
			return;
		array[len] = node.data;
		len++;

		if (node.left == null && node.right == null) {
			printArray(array);
			return;
		}

		printPaths(node.left, array, len);
		printPaths(node.right, array, len);
	}

	private void printArray(int[] array) {
		// TODO Auto-generated method stub
		for (int i : array) {
			if (i != 0)
				System.out.print(i + " ");
		}
		System.out.println();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PrintPossiblePaths bt = new PrintPossiblePaths();
		bt.add(50);
		bt.add(10);
		bt.add(20);
		bt.add(60);
		bt.add(70);
		bt.add(30);
		bt.add(55);
		bt.printPaths(bt.rootNode, new int[8], 0);

	}

}
