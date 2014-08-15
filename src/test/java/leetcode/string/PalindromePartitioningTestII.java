package leetcode.string;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PalindromePartitioningTestII {

	PalindromePartitioningII	test	= new PalindromePartitioningII();

	@Test
	public void test() {
		Assert.assertEquals(test.minCut(null), 0);
		Assert.assertEquals(test.minCut(""), 0);
		Assert.assertEquals(test.minCut("a"), 0);
		Assert.assertEquals(test.minCut("aab"), 1);
		Assert.assertEquals(test.minCut("abbab"), 1);
		Assert.assertEquals(test.minCut("gggasdf"), 4);
	}
}
