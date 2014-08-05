package leetcode.tree;

import leetcode.model.TreeNode;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BinaryTreePreorderTraversalTest {
	BinaryTreePreorderTraversal	test	= new BinaryTreePreorderTraversal();

	@Test
	public void test() {
		TreeNode root0 = null;
		TreeNode root1 = TreeNode.buildFromString("{1}");
		TreeNode root2 = TreeNode.buildFromString("{1,#,2,3}");
		TreeNode root3 = TreeNode.buildFromString("{1,2,3,4,#,#,5}");
		Assert.assertEquals(test.preorderTraversal(root0).toString(), "[]");
		Assert.assertEquals(test.preorderTraversal(root1).toString(), "[1]");
		Assert.assertEquals(test.preorderTraversal(root2).toString(), "[1, 2, 3]");
		Assert.assertEquals(test.preorderTraversal(root3).toString(), "[1, 2, 4, 3, 5]");
	}
}
