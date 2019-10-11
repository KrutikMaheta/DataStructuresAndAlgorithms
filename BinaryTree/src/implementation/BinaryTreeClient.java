package implementation;

public class BinaryTreeClient {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree(10);

		System.out.println("Tree Before insert : ");
		tree.inOrder(tree.root);

		tree.insert(tree.root, 11);
		tree.insert(tree.root, 7);
		tree.insert(tree.root, 9);
		tree.insert(tree.root, 15);
		tree.insert(tree.root, 8);
		tree.insert(tree.root, 12);
		tree.insert(tree.root, 20);

		System.out.println();
		System.out.println("Inorder Traversal: ");
		tree.inOrder(tree.root);

		System.out.println();
		System.out.println("Inorder Traversal without recursion:: ");
		tree.inOrderWithoutRecursion(tree.root);

		System.out.println();
		System.out.println("Preorder Traversal: ");
		tree.preOrder(tree.root);

		System.out.println();
		System.out.println("Preorder Traversal without recursion: ");
		tree.preOrderWithoutRecursion(tree.root);

		System.out.println();
		System.out.println("Postorder Traversal: ");
		tree.postOrder(tree.root);

		System.out.println();
		System.out.println("Postorder Traversal without recursion: ");
		tree.postOrderWithoutRecursion(tree.root);

		System.out.println();
		System.out.println("Height of Tree is : " + tree.height(tree.root));

		System.out.println();
		System.out.println("Level order traversal : ");
		tree.levelOrder();
		
		System.out.println();
		System.out.println("Level order using queue: ");
		tree.levelOrderUsingQueue();
	}

}
