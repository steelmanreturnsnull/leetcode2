package leetcode.model;

import java.util.LinkedList;

public class TreeNode {
	public int		val;
	public TreeNode	left;
	public TreeNode	right;

	public TreeNode(int x) {
		val = x;
	}

	private static final String	nullTree	= "#";

	public static TreeNode buildFromString(String str) {
		String[] parts = str.substring(1, str.length() - 1).split(",");
		TreeNode root = null;
		LinkedList<TreeNode> unCompletedNode = new LinkedList<>();
		for (int i = 0; i < parts.length; i++) {
			if (i == 0 && !parts[i].equals(nullTree)) {
				root = new TreeNode(Integer.parseInt(parts[i]));
				unCompletedNode.add(root);
			} else {
				TreeNode iter = unCompletedNode.pop();
				if (!parts[i].equals(nullTree)) {
					iter.left = new TreeNode(Integer.parseInt(parts[i]));
					unCompletedNode.add(iter.left);
				}
				i++;
				if (i < parts.length && !parts[i].equals(nullTree)) {
					iter.right = new TreeNode(Integer.parseInt(parts[i]));
					unCompletedNode.add(iter.right);
				}

			}
		}
		return root;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");

		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(this);
		while (!queue.isEmpty()) {
			TreeNode curr = queue.pop();
			if (curr == null) {
				sb.append(nullTree).append(",");
			} else {
				sb.append(curr.val).append(",");
				queue.add(curr.left);
				queue.add(curr.right);
			}
		}
		String toProcess = sb.toString();
		while (toProcess.endsWith(nullTree) || toProcess.endsWith(",")) {
			toProcess = toProcess.substring(0, toProcess.length() - 1);
		}
		toProcess += "}";
		return toProcess;
	}
}