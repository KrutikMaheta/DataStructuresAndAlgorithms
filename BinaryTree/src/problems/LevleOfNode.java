package problems;

public class LevleOfNode {

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
	 * 1. If node is null then return 0 2. If node's data is equal to key, then
	 * return level. 3. Recursively search key in left subtree 4. If not found,
	 * then search in right subtree
	 * 
	 */

	private int levelOfNode(TreeNode root, int key, int level) {
		// TODO Auto-generated method stub
		if (root == null)
			return 0;
		if (root.data == key)
			return level;
		int result = levelOfNode(root.left, key, level + 1);
		if (result != 0)
			return result;
		return levelOfNode(root.right, key, level + 1);

	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LevleOfNode bst = new LevleOfNode();
		bst.add(50);
		bst.add(10);
		bst.add(20);
		bst.add(60);
		bst.add(70);
		bst.add(30);
		bst.add(55);

		System.out.println("Level of 30 is : " + bst.levelOfNode(bst.rootNode, 30, 1));
		System.out.println("Level of 50 is : " + bst.levelOfNode(bst.rootNode, 50, 1));
		System.out.println("Level of 70 is : " + bst.levelOfNode(bst.rootNode, 70, 1));
		System.out.println("Level of 80 is : " + bst.levelOfNode(bst.rootNode, 80, 1));
	}

}
