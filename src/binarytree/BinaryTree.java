package binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

import binarysearchtree.BinarySearchTree;
import binarysearchtree.TreeNode;

public class BinaryTree {

	public static void main(String args[]) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(12);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(9);
		root.right.left = new TreeNode(11);
		root.right.right = new TreeNode(15);
		root.right.right.right = new TreeNode(17);

		/// System.out.println(checkIsoMorphicTree(root.left, root.right));

		System.out.println("Level Order Traversal Print By Level");
		BinarySearchTree.levelOrderTraversalPrintByLevel(root);
		// printLongestPath(root);
		System.out.println("Vertical Order Traversal");
		printVerticalOrder(root);
		
		System.out.println("Lowest Common Ancestor");
		TreeNode lca = lowestCommonAncestor(root, 15, 17);
		System.out.println(lca);
	}

	public static boolean checkIsoMorphicTree(TreeNode root1, TreeNode root2) {

		// Both null means we are beyond leaf node.
		if (root1 == null && root2 == null) {
			return true;
		}

		// One of them is null, means not isomorphic
		if (root1 == null || root2 == null) {
			return false;
		}

		// Data is not same in the nodes
		if (root1.data != root2.data) {
			return false;
		}

		// return (checkIsoMorphicTree(root1.left, root2.right) &&
		// checkIsoMorphicTree(root1.right, root2.left));
		return (checkIsoMorphicTree(root1.left, root2.left) && checkIsoMorphicTree(root1.right, root2.right));

	}

	public static void inOrderTraversal(TreeNode root) {
		if (root != null) {
			inOrderTraversal(root.left);
			System.out.print(root + " ");
			inOrderTraversal(root.right);
		}
	}

	public static void reverseInOrderTraversal(TreeNode root) {
		if (root != null) {
			inOrderTraversal(root.right);
			System.out.print(root + " ");
			inOrderTraversal(root.left);
		}
	}

	public static void preOrderTraversal(TreeNode root) {
		if (root != null) {
			System.out.print(root + " ");
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
		}
	}

	public static void postOrderTraversal(TreeNode root) {
		if (root != null) {
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			System.out.print(root + " ");
		}
	}

	public static int treeHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = treeHeight(root.left);
		int rightHeight = treeHeight(root.right);

		if (leftHeight > rightHeight) {
			return 1 + leftHeight;
		} else {
			return 1 + rightHeight;
		}
	}

	public static void printLongestPath(TreeNode root) {
		if (root == null) {
			return;
		}

		// get max height
		int maxHeight = treeHeight(root);
		ArrayDeque<Integer> helperQueue = new ArrayDeque<>();
		traverseAndPrint(root, helperQueue, maxHeight, 1);
	}

	public static boolean traverseAndPrint(TreeNode root, ArrayDeque<Integer> helperQueue, int maxHeight,
			int currentHeight) {

		if (root == null) {
			return false;
		}

		helperQueue.add(root.data);
		if (root != null && root.right == null && root.left == null && currentHeight == maxHeight) {
			// print queue
			printQueue(helperQueue);
			return true;
		}

		boolean found = traverseAndPrint(root.left, helperQueue, maxHeight, currentHeight + 1);
		if (!found) {
			traverseAndPrint(root.right, helperQueue, maxHeight, currentHeight + 1);
		}

		if (!helperQueue.isEmpty()) {
			helperQueue.removeLast();
		}

		return found;
	}

	public static void printQueue(ArrayDeque<Integer> helperQueue) {
		while (!helperQueue.isEmpty()) {
			System.out.print(helperQueue.poll() + " ");
		}
	}

	// public static void printVerticalOrder(TreeNode root){
	// HashMap<Integer, ArrayList<Integer>> distanceMap = new HashMap<>();
	//
	// getVerticalOrder(root, 0, distanceMap);
	//
	// System.out.println(distanceMap);
	// }
	//
	// public static void getVerticalOrder(TreeNode root, int hd,
	// HashMap<Integer, ArrayList<Integer>> distanceMap){
	//
	// if(root == null){
	// return;
	// }
	//
	// if(distanceMap.containsKey(hd)){
	// ArrayList<Integer> map = distanceMap.get(hd);
	// map.add(root.data);
	// } else {
	// ArrayList<Integer> map = new ArrayList<>();
	// map.add(root.data);
	// distanceMap.put(hd, map);
	// }
	//
	// getVerticalOrder(root.left, hd-1, distanceMap);
	// getVerticalOrder(root.right, hd+1, distanceMap);
	// }

	public static void printVerticalOrder(TreeNode root) {
		if (root == null) {
			return;
		}

		int leftHD = findMinHorizontalDistance(root);
		int rightHD = findMaxHorizontalDistance(root);
		HashMap<Integer, ArrayList<Integer>> distanceMap = new HashMap<>();
		getVerticalOrder(root, 0, distanceMap);
		System.out.println(distanceMap);

		for (int i = leftHD; i <= rightHD; i++) {
			ArrayList<Integer> map = distanceMap.get(i);
			for (int data : map) {
				System.out.print(data + " ");
			}
			System.out.println();
		}
	}

	public static int findMinHorizontalDistance(TreeNode root) {

		int dist = 0;
		TreeNode current = root;
		while (current.left != null) {
			dist--;
			current = current.left;
		}
		return dist;
	}

	public static int findMaxHorizontalDistance(TreeNode root) {

		int dist = 0;
		TreeNode current = root;
		while (current.right != null) {
			dist++;
			current = current.right;
		}
		return dist;
	}

	public static void getVerticalOrder(TreeNode root, int hd, HashMap<Integer, ArrayList<Integer>> distanceMap) {

		if (root == null) {
			return;
		}

		if (distanceMap.containsKey(hd)) {
			ArrayList<Integer> map = distanceMap.get(hd);
			map.add(root.data);
		} else {
			ArrayList<Integer> map = new ArrayList<>();
			map.add(root.data);
			distanceMap.put(hd, map);
		}

		getVerticalOrder(root.left, hd - 1, distanceMap);
		getVerticalOrder(root.right, hd + 1, distanceMap);
	}

	public static TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
		if (root == null)
			return null;

		if (root.data == p || root.data == q)
			return root;

		TreeNode l = lowestCommonAncestor(root.left, p, q);
		TreeNode r = lowestCommonAncestor(root.right, p, q);

		if (l != null && r != null) {
			return root;
		} else if (l == null && r == null) {
			return null;
		} else {
			return l == null ? r : l;
		}
	}
}
