package leetcode.tree;

import leetcode.model.TreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SumRootToLeefNumbersTest {
	SumRootToLeefNumbers	test	= new SumRootToLeefNumbers();

	@Test
	public void test() {
		TreeNode root0 = null;
		TreeNode root1 = TreeNode.buildFromString("{1}");
		TreeNode root2 = TreeNode.buildFromString("{1,#,2,3,4}");
		TreeNode root3 = TreeNode.buildFromString("{1,2,3,4,#,#,5}");
		Assert.assertEquals(test.sumNumbers(root0), 0);
		Assert.assertEquals(test.sumNumbers(root1), 1);
		Assert.assertEquals(test.sumNumbers(root2), 247);
		Assert.assertEquals(test.sumNumbers(root3), 259);
	}
}
