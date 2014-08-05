package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode.model.TreeNode;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * For example: Given binary tree {1,#,2,3}, 1 \ 2 / 3 return [1,2,3].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 */
public class BinaryTreePreorderTraversal {
	
	// O(N), O(N) space
	public List<Integer> preorderTraversal(TreeNode root) {

		List<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();

		while (!stack.isEmpty() || root != null) {
			if (root != null) {
				result.add(root.val);
				if (root.right != null)
					stack.push(root.right);
				root = root.left; // same as push right, then push left, then pop (thus root = root.left)
			} else
				root = stack.pop();
		}

		return result;
	}
}
