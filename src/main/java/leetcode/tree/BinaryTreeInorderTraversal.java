package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode.model.TreeNode;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * For example: Given binary tree {1,#,2,3}, 
 * 1 
 *  \ 
 *   2 
 *  / 
 * 3 
 * return [1,3,2].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 */
public class BinaryTreeInorderTraversal {
	// O(N), O(lgN) space
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();

		while (!stack.isEmpty() || root != null) {
			if (root != null) {
				stack.add(root);
				root = root.left;
			} else {
				root = stack.pop();
				result.add(root.val);
				root = root.right;
			}
		}

		return result;
	}

}
