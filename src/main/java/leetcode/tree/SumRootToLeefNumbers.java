package leetcode.tree;

import leetcode.model.TreeNode;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * 
 * Find the total sum of all root-to-leaf numbers.
 * 
 * For example,
 * 
 * 1 / \ 2 3
 * 
 * The root-to-leaf path 1->2 represents the number 12. The root-to-leaf path 1->3 represents the number 13.
 * 
 * Return the sum = 12 + 13 = 25.
 * 
 */
public class SumRootToLeefNumbers {

	// O(N), O(N) space
	public int sumNumbers(TreeNode root) {
		return sumNumbers(root, 0);
	}

	private int sumNumbers(TreeNode root, int current) {
		if (root == null)
			return 0;
		current = current * 10 + root.val;
		if (root.left == null && root.right == null)
			return current;
		else {
			return sumNumbers(root.left, current) + sumNumbers(root.right, current);
		}

	}
}
