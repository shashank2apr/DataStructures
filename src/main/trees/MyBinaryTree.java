package main.trees;

import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;

import main.trees.MyBinaryTree.Node;

public class MyBinaryTree {

	public static class Node {
		private int val;
		private Node left;
		private Node right;

		private Node(int val) {
			this.val = val;
			this.left = this.right = null;
		}

		/**
		 * @return the val
		 */
		public int getVal() {
			return val;
		}

		/**
		 * @param val
		 *            the val to set
		 */
		public void setVal(int val) {
			this.val = val;
		}

		/**
		 * @return the left
		 */
		public Node getLeft() {
			return left;
		}

		/**
		 * @param left
		 *            the left to set
		 */
		public void setLeft(Node left) {
			this.left = left;
		}

		/**
		 * @return the right
		 */
		public Node getRight() {
			return right;
		}

		/**
		 * @param right
		 *            the right to set
		 */
		public void setRight(Node right) {
			this.right = right;
		}
	}// end of Class Node

	Node root;

	public MyBinaryTree() {
		root = null;
	}

	public MyBinaryTree(int key) {
		root = new Node(key);
	}

	private static void printInorder(Node node) {

		// base case
		if (null == node) {
			return;
		}

		printInorder(node.getLeft());
		System.out.print(node.getVal() + " ");
		printInorder(node.getRight());
	}

	private static void printPreorder(Node node) {
		// base case
		if (null == node) {
			return;
		}

		System.out.print(node.getVal() + " ");
		printPreorder(node.getLeft());
		printPreorder(node.getRight());

	}

	private static void printPostorder(Node node) {
		// base case
		if (null == node) {
			return;
		}

		printPostorder(node.getLeft());
		printPostorder(node.getRight());
		System.out.print(node.getVal() + " ");

	}

	/**
	 * @return
	 */
	private static MyBinaryTree createBinaryTree() {
		MyBinaryTree tree = new MyBinaryTree(1);
		tree.root.setLeft(new Node(2));
		tree.root.setRight(new Node(3));
		tree.root.getLeft().setLeft(new Node(4));
		tree.root.getRight().setRight(new Node(5));
		return tree;
	}

	private static MyBinaryTree createBinarySearchTreeFromArray(int arr[]) {
		int size = arr.length;

		MyBinaryTree tree = new MyBinaryTree();
		for (int i = 0; i < size; i++)
			tree.insert(arr[i]);

		return tree;
	}

	private void insert(int i) {
		this.root = insertNode(root, i);
	}

	private Node insertNode(Node root, int i) {
		// base case
		if (root == null) {
			root = new Node(i);
			return root;
		}

		if (root.getVal() >= i)
			root.setLeft(insertNode(root.getLeft(), i));
		else
			root.setRight(insertNode(root.getRight(), i));

		return root;
	}

	private void search(int value) {
		if (searchNode(this.root, value))
			System.out.println(value + " present in Tree !!!");
		else
			System.out.println(value + " not present in Tree !!!");
	}

	private boolean searchNode(Node root, int value) {
		// base class
		if (null == root)
			return false;
		if (root.getVal() == value)
			return true;

		if (root.getVal() > value) {
			return searchNode(root.getLeft(), value);
		} else {
			return searchNode(root.getRight(), value);
		}

		// return false;
	}

	private int height(Node root) {
		if (root == null)
			return 0;

		int l = 1 + height(root.getLeft());
		int r = 1 + height(root.getRight());

		if (l > r)
			return l;
		else
			return r;

	}

	private int heightIterative(Node root) {

		if (root == null)
			return 0;

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		
		int count = 0;
		while (true) {
			int nodeCount=queue.size();
			if(nodeCount==0)
				return count;
			count = count + 1;
			while (nodeCount > 0) {
				
				if (queue.peek().getLeft() != null)
					queue.add(queue.peek().getLeft());
				if (queue.peek().getRight() != null)
					queue.add(queue.peek().getRight());
				
				queue.remove();
				nodeCount--;
			}
			System.out.println("Count = " + count);

		}


	}

	public static void main(String[] args) {
		int arr[] = { 3, 2, 1, 4, 5 };

		// DO NOT DELETE MyBinaryTree tree = createBinaryTree();

		MyBinaryTree tree = createBinarySearchTreeFromArray(arr);
		System.out.println("Tree root : " + tree.root.getVal());

		System.out.print("Inorder Traversal : ");
		printInorder(tree.root);
		System.out.println();
		System.out.print("Preorder Traversal : ");
		printPreorder(tree.root);
		System.out.println();
		System.out.print("Postorder Traversal : ");
		printPostorder(tree.root);

		// DO NOT DELETE searchInTree(tree);
		System.out.println("Tree root : " + tree.root.getVal());
		System.out.println("Height of tree = " + tree.height(tree.root));
		System.out.println("Height Iterative of tree = "
				+ tree.heightIterative(tree.root));
	}

	/**
	 * @param tree
	 */
	private static void searchInTree(MyBinaryTree tree) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number to be searched : ");
		int element = sc.nextInt();
		tree.search(element);
	}

}
