package leetcode.tree;

import java.util.ArrayList;

import java.util.List;
import java.util.Stack;

import leetcode.model.TreeNode;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * 
 * For example: Given binary tree {1,#,2,3}, 
 * 1 
 *  \ 
 *   2 
 *  / 
 * 3 
 * return [3,2,1].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 */
public class BinaryTreePostorderTraversal {
	
	// O(N), O(lgN) space
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();

		if (root != null)
			stack.add(root);
		TreeNode prev = null;
		while (!stack.isEmpty()) {
			root = stack.peek();
			if (prev == null || prev.left == root || prev.right == root) { // First time
				if (root.left != null)
					stack.push(root.left);
				else if (root.right != null) // Notice here!
					stack.push(root.right);
			} else if (prev == root.left) { // Second time
				if (root.right != null)
					stack.push(root.right);
			} else { // Third time
				// root == prev I didn't add a node last time.
				// (it has no left child and no right child, or i have visited left child and it has no right child)
				// or root == prev.right I just visited its right child.
				result.add(root.val);
				stack.pop();
			}
			prev = root;
		}
		return result;
	}
}
