package binarysearchtree;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;

import linkedlist.ListNode;

public class BinarySearchTree {

	TreeNode root;

	public TreeNode insert(int data) {

		TreeNode newNode = new TreeNode(data);

		if (this.root == null) {
			root = newNode;
			return root;
		}

		TreeNode current = root;
		TreeNode parent = null;
		while (true) {
			parent = current;
			if (data < current.data) {
				current = current.left;
				if (current == null) {
					parent.left = newNode;
					break;
				}
			} else if (data > current.data) {
				current = current.right;
				if (current == null) {
					parent.right = newNode;
					break;
				}
			} else {
				// we found duplicate node so do nothing;
				break;
			}
		}

		return root;
	}

	public TreeNode findNoreRecursive(TreeNode root, int data) {

		if (root == null) {
			// Tree doesnt exist
			return null;
		}

		if (root.data == data) {
			return root;
		} else if (data < root.data) {
			return findNoreRecursive(root.left, data);
		} else {
			return findNoreRecursive(root.right, data);
		}
	}

	public TreeNode findNodeNonRecursive(TreeNode root, int data) {

		if (root == null) {
			// Tree doesnt exist
			return null;
		}

		TreeNode current = root;

		while (current != null) {
			if (current.data == data) {
				return current;
			} else if (data < current.data) {
				current = current.left;
			} else {
				current = current.right;
			}
		}

		return null;
	}

	public static void inOrderTraversal(TreeNode root) {
		if (root != null) {
			inOrderTraversal(root.left);
			System.out.print(root + " ");
			inOrderTraversal(root.right);
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

	public static int findTreeHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int leftHeight = findTreeHeight(root.left);
		int rightHeight = findTreeHeight(root.right);

		if (leftHeight > rightHeight) {
			return 1 + leftHeight;
		} else {
			return 1 + rightHeight;
		}
	}

	public static int heightDifference(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int leftHeight = findTreeHeight(root.left);
		int rightHeight = findTreeHeight(root.right);

		return Math.abs(leftHeight - rightHeight);
	}

	public static int findNodeHeightRecursive(TreeNode root, int data, int height) {

		if (root == null) {
			return 0;
		}

		if (root.data == data) {
			return height;
		}

		int level = findNodeHeightRecursive(root.left, data, height + 1);
		if (level != 0) {
			return level;
		}
		return findNodeHeightRecursive(root.right, data, height + 1);
	}

	public static int findNodeHeightNonRecursive(TreeNode root, int data) {
		if (root == null) {
			return -1;
		}

		int height = 0;
		TreeNode current = root;

		while (current != null) {
			if (current.data == data) {
				return height;
			} else if (data < current.data) {
				current = current.left;
				height++;
			} else {
				current = current.right;
				height++;
			}
		}

		return -1;
	}

	public static TreeNode findMin(TreeNode current) {
		if (current == null) {
			return null;
		}

		while (current.left != null) {
			current = current.left;
		}
		return current;
	}

	public static TreeNode getInorderSuccessor(TreeNode root, TreeNode current) {

		if (root == null) {
			return null;
		}
		// Case 1: if node has right subtree, find min in right subtree
		if (current.right != null) {
			return findMin(current.right);
		}
		// Case 2: where node does not have a right subtree
		else {

			TreeNode successor = null;
			TreeNode ancestor = root;

			while (ancestor != current) {
				if (current.data < ancestor.data) {
					successor = ancestor;
					ancestor = ancestor.left;
				} else {
					ancestor = ancestor.right;
				}
			}

			return successor;
		}
	}

	public static boolean isSubTreeBST(TreeNode root, Integer min, Integer max) {
		if (root == null) {
			return true;
		}

		if ((min != null && root.data <= min) || (max != null && root.data >= max)) {
			return false;
		}

		return isSubTreeBST(root.left, min, root.data) && isSubTreeBST(root.left, root.data, max);
	}

	public static TreeNode buildBSTFromSortedArray(int a[], int lo, int hi) {
		if (hi < lo) {
			return null;
		}

		int mid = (lo + hi) / 2;
		TreeNode root = new TreeNode(a[mid]);
		root.left = buildBSTFromSortedArray(a, lo, mid - 1);
		root.right = buildBSTFromSortedArray(a, mid + 1, hi);
		return root;
	}

	public static void levelOrderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}

		Queue<TreeNode> helperQueue = new LinkedList<>();
		helperQueue.add(root);

		while (!helperQueue.isEmpty()) {
			TreeNode first = helperQueue.remove();
			System.out.println(first.data);
			if (first.left != null) {
				helperQueue.add(first.left);
			}

			if (first.right != null) {
				helperQueue.add(first.right);
			}
		}
	}

	public static void levelOrderTraversalPrintByLevel(TreeNode root) {
		if (root == null) {
			return;
		}

		int levelnodes = 0;
		Queue<TreeNode> helperQueue = new LinkedList<>();
		helperQueue.add(root);

		while (!helperQueue.isEmpty()) {
			levelnodes = helperQueue.size();
			while (levelnodes != 0) {
				TreeNode first = helperQueue.remove();
				System.out.print(first.data + " ");
				if (first.left != null) {
					helperQueue.add(first.left);
				}

				if (first.right != null) {
					helperQueue.add(first.right);
				}
				levelnodes--;
			}
			System.out.println();
		}
	}

	public static int getCountBetweenRange(TreeNode root, int min, int max) {

		if (root == null) {
			return 0;
		}

		Queue<TreeNode> helperQueue = new LinkedList<TreeNode>();
		helperQueue.add(root);

		int count = 0;

		while (!helperQueue.isEmpty()) {
			TreeNode temp = helperQueue.remove();

			if (temp.data >= min && temp.data <= max) {
				count++;
			}

			if (temp.left != null) {
				helperQueue.add(temp.left);
			}

			if (temp.right != null) {
				helperQueue.add(temp.right);
			}
		}

		return count;
	}

	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		return buildBST(head, null);
	}

	public TreeNode buildBST(ListNode head, ListNode tail) {
		ListNode mid = head;
		ListNode runner = head;
		if (head == tail)
			return null;

		while (runner != tail && runner.next != tail) {
			runner = runner.next.next;
			mid = mid.next;
		}

		TreeNode node = new TreeNode(mid.data);
		node.left = buildBST(head, mid);
		node.right = buildBST(mid.next, tail);
		return node;
	}

	public static int getCountBetweenRangeRecursive(TreeNode root, int low, int high) {
		if (root == null)
			return 0;

		if (root.data == high && root.data == low)
			return 1;

		if (root.data <= high && root.data >= low)
			return 1 + getCountBetweenRangeRecursive(root.left, low, high)
					+ getCountBetweenRangeRecursive(root.right, low, high);

		else if (root.data < low)
			return getCountBetweenRangeRecursive(root.right, low, high);

		else
			return getCountBetweenRangeRecursive(root.left, low, high);
	}

	public static TreeNode lcaRecursive(TreeNode root, int v1, int v2) {

		if (root == null) {
			return null;
		}

		if (v1 < root.data && v2 < root.data) {
			return lcaRecursive(root.left, v1, v2);
		}

		if (v1 > root.data && v2 > root.data) {
			return lcaRecursive(root.right, v1, v2);
		}

		return root;
	}

	public static TreeNode lcaNonRecursive(TreeNode root, int v1, int v2) {

		if (root == null) {
			return null;
		}

		TreeNode current = root;

		while (current != null) {
			if (v1 < current.data && v2 < current.data) {
				current = current.left;
			} else if (v1 > current.data && v2 > current.data) {
				current = current.right;
			} else {
				return current;
			}
		}

		return root;
	}

	public static void childrenCount(TreeNode root) {
		LinkedHashMap<Integer, Integer> countMap = new LinkedHashMap<>();
		findChildrenCount(root, countMap);
		
		for(int key: countMap.keySet()){
			System.out.println(key+" "+ countMap.get(key));
		}
	}

	public static int findChildrenCount(TreeNode root, LinkedHashMap<Integer, Integer> countMap) {

		if (root == null) {
			return 0;
		}

		int count = 0;
		if(root.left != null){
			count = count + 1 + findChildrenCount(root.left, countMap);
		}
		
		if(root.right != null){
			count = count + 1 + findChildrenCount(root.right, countMap);
		}
		countMap.put(root.data, count);
		return count;
	}

	public static void main(String args[]) {
		BinarySearchTree bst = new BinarySearchTree();
		int nums[] = { 1, 2, 3, 4, 5, 6, 7 };	//{ 4, 5, 10, 11, 12, 14 }; 
		bst.root = buildBSTFromSortedArray(nums, 0, nums.length - 1);

		// System.out.println("Level order traversal");
		// levelOrderTraversal(bst.root);
		//
		// System.out.println("Level order traversal by levels");
		// levelOrderTraversalPrintByLevel(bst.root);
		//
		// System.out.println("Get count between nodes 2 and 6");
		// System.out.println(getCountBetweenRange(bst.root, 2, 6));
		// System.out.println(getCountBetweenRangeRecursive(bst.root, 2, 6));

		// System.out.println("Find LCA 7 and 1");
		// System.out.println(lcaNonRecursive(bst.root, 7, 1));
		
		childrenCount(bst.root);

	}
}
