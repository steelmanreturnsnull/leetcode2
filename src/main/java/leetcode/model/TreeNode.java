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

		String toProcess = toStringHepler(this);
		while (toProcess.endsWith("#") || toProcess.endsWith(",")) {
			toProcess = toProcess.substring(0, toProcess.length() - 1);
		}
		sb.append(toProcess);
		sb.append("}");
		return sb.toString();
	}

	private String toStringHepler(TreeNode node) {

		if (node == null)
			return nullTree;
		StringBuilder sb = new StringBuilder();
		sb.append(node.val).append(",").append(toStringHepler(node.left)).append(",").append(toStringHepler(node.right));
		return sb.toString();
	}

	public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		a.right = b;
		b.left = c;
		System.out.println(TreeNode.buildFromString("{1,#,2,3}"));
	}

}