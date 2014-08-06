package leetcode.tree;

import leetcode.model.TreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BinaryTreePostorderTraversalTest {
	BinaryTreePostorderTraversal	test	= new BinaryTreePostorderTraversal();

	@Test
	public void test() {
		TreeNode root0 = null;
		TreeNode root1 = TreeNode.buildFromString("{1}");
		TreeNode root2 = TreeNode.buildFromString("{1,#,2,3}");
		TreeNode root3 = TreeNode.buildFromString("{1,2,3,4,#,#,5}");
		Assert.assertEquals(test.postorderTraversal(root0).toString(), "[]");
		Assert.assertEquals(test.postorderTraversal(root1).toString(), "[1]");
		Assert.assertEquals(test.postorderTraversal(root2).toString(), "[3, 2, 1]");
		Assert.assertEquals(test.postorderTraversal(root3).toString(), "[4, 2, 5, 3, 1]");
	}
}
