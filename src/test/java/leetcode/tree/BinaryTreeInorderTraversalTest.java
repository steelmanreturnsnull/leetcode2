package leetcode.tree;

import leetcode.model.TreeNode;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BinaryTreeInorderTraversalTest {
	BinaryTreeInorderTraversal	test	= new BinaryTreeInorderTraversal();

	@Test
	public void test() {
		TreeNode root0 = null;
		TreeNode root1 = TreeNode.buildFromString("{1}");
		TreeNode root2 = TreeNode.buildFromString("{1,#,2,3}");
		TreeNode root3 = TreeNode.buildFromString("{1,2,3,4,#,#,5}");
		Assert.assertEquals(test.inorderTraversal(root0).toString(), "[]");
		Assert.assertEquals(test.inorderTraversal(root1).toString(), "[1]");
		Assert.assertEquals(test.inorderTraversal(root2).toString(), "[1, 3, 2]");
		Assert.assertEquals(test.inorderTraversal(root3).toString(), "[4, 2, 1, 3, 5]");
	}
}
