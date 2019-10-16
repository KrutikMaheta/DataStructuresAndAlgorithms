/**
 * Program to print all the leaf nodes of the binary tree
 */
package problems;

/**
 * @author Krutik
 *
 */
public class PrintLeafNodes {

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

	private int countLeafs(TreeNode temp) {
		// TODO Auto-generated method stub
		if (temp == null)
			return 0;
		if (temp.left == null && temp.right == null)
			return 1;
		return countLeafs(temp.left) + countLeafs(temp.right);
	}

	/**
	 * 1. If node is null then return 0
	 * 2. If encounterd leaf node(i.e. node.left is null and node.right is null) then print the node.
	 * 3. Recursively visit leaf subtree and right subtree.
	 * @param rootNode2
	 */
	
	private void printLeafs(TreeNode rootNode2) {
		// TODO Auto-generated method stub
		if (rootNode2 == null)
			return;
		if (rootNode2.left == null && rootNode2.right == null)
			System.out.print(rootNode2.data + " ");
		printLeafs(rootNode2.left);
		printLeafs(rootNode2.right);
	}

	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PrintLeafNodes bt = new PrintLeafNodes();
		bt.add(50);
		bt.add(10);
		bt.add(20);
		bt.add(60);
		bt.add(70);
		bt.add(30);
		bt.add(55);

		bt.printLeafs(bt.rootNode);
		System.out.println("\nNumber of leaf nodes : " + bt.countLeafs(bt.rootNode));
	}

}
